package com.ims.internship_management_system.service;

import com.ims.internship_management_system.constant.EvaluationPeriod;
import com.ims.internship_management_system.constant.Role;
import com.ims.internship_management_system.exception.IMSRuntimeException;
import com.ims.internship_management_system.model.AuditEntity;
import com.ims.internship_management_system.model.AuditInternEntity;
import com.ims.internship_management_system.model.AuditParticipants;
import com.ims.internship_management_system.model.InternEntity;
import com.ims.internship_management_system.model.dto.AuditDto;
import com.ims.internship_management_system.model.dto.AuditInternDto;
import com.ims.internship_management_system.model.dto.InternDto;
import com.ims.internship_management_system.model.mapper.AuditInternMapper;
import com.ims.internship_management_system.model.mapper.AuditMapper;
import com.ims.internship_management_system.model.mapper.InternMapper;
import com.ims.internship_management_system.repository.AuditRepository;
import com.ims.internship_management_system.repository.InternRepository;
import com.ims.internship_management_system.request.AuditFormCreationRequest;
import com.ims.internship_management_system.util.generator.IdGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuditService {
    private final AuditRepository auditRepository;
    private final InternService internService;
    private final AuditInternService auditInternService;
    private final MentorService mentorService;
    private final AuditMapper auditMapper;
    private final AuditParticipantsService auditParticipantsService;
    private final InternRepository internRepository;
    private final InternMapper internMapper;
    private final AuditInternMapper auditInternMapper;

    public AuditEntity createAudit(AuditFormCreationRequest request) {

        if(mentorService.findById(request.getMentorId()).isEmpty()) {
            throw new IMSRuntimeException(HttpStatus.NOT_FOUND, "Mentor id not found");
        }
        String id = IdGenerator.generateAuditId(request.getMentorId());
        AuditEntity audit = checkExisted(id);

        audit.setEvaluationPeriod(EvaluationPeriod.fromValue(request.getEvaluationPeriod()));
        audit.setMentorId(request.getMentorId());

        auditParticipantsService.save(new AuditParticipants(audit.getAuditId(),
                audit.getMentorId(), Role.MENTOR));
        for(String intern : request.getInterns()) {
            InternEntity i =
                    internService.getInternByInternId(intern).orElseThrow(() -> new IMSRuntimeException(HttpStatus.NOT_FOUND, "intern not found"));
            auditParticipantsService.save(new AuditParticipants(audit.getAuditId(), i.getUserId(),
                    Role.INTERN));
            auditInternService.createAuditIntern(audit.getAuditId(), i.getUserId(), request.getMentorId());
        }

        return auditRepository.save(audit);
    }

    public List<InternDto> getParticipants(AuditEntity audit){
        List<AuditParticipants> participants =
                auditParticipantsService.findInternParticipantsByAuditId(audit.getAuditId());
        return participants.stream().map((participant) -> {
            InternEntity i = internRepository.findInternEntityByUserId(participant.getUserId())
                    .orElseThrow(() -> new IMSRuntimeException(HttpStatus.NOT_FOUND, "user not " +
                            "found."));
            return internMapper.toDTO(i);
        }).toList();
    }

    public List<AuditInternDto> getAuditInterns(AuditEntity audit){
        List<AuditInternEntity> auditInternEntities = auditInternService.getAuditInternsByAuditId(audit.getAuditId());
        return auditInternEntities.stream().map(auditInternMapper::toDTO).toList();
    }


    public List<AuditEntity> findAll() {
        return auditRepository.findAll();
    }

    public AuditEntity checkExisted(String id) {
        if(getAuditById(id).isEmpty()) {
            AuditEntity audit = new AuditEntity();
            audit.setAuditId(id);
            return audit;
        }else{
            return getAuditById(id).get();
        }
    }

    public List<AuditEntity> getAuditByMentorID(String id) {
        return auditRepository.findByMentorId(id);
    }

    public List<AuditEntity> findAuditByMonth(int month, int year) {
        LocalDate currentDate = LocalDate.now();
        int currentMonth = currentDate.getMonthValue();
        int currentYear = currentDate.getYear();
        return auditRepository.findByMonthAndYear(currentMonth, currentYear);
    }

    public Optional<AuditEntity> getAuditById(String id) {
        return auditRepository.findByAuditId(id);
    }


}
