package com.ims.internship_management_system.service;

import com.ims.internship_management_system.constant.EvaluationPeriod;
import com.ims.internship_management_system.constant.Role;
import com.ims.internship_management_system.model.AuditEntity;
import com.ims.internship_management_system.model.AuditParticipants;
import com.ims.internship_management_system.model.InternEntity;
import com.ims.internship_management_system.model.dto.AuditDto;
import com.ims.internship_management_system.model.mapper.AuditMapper;
import com.ims.internship_management_system.repository.AuditRepository;
import com.ims.internship_management_system.request.AuditFormCreationRequest;
import com.ims.internship_management_system.util.generator.IdGenerator;
import lombok.RequiredArgsConstructor;
//import lombok.var;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuditService {
//    @Autowired
    private final AuditRepository auditRepository;
    
//    @Autowired
    private final AuditMapper auditMapper;
    private final AuditInternService auditInternService;

    public AuditEntity createAudit(AuditFormCreationRequest request) {
//        AuditEntity entity = new AuditEntity();
        AuditEntity audit = new AuditEntity();
        audit.setAuditId(IdGenerator.generateAuditId(request.getMentorId()));
        audit.setEvaluationPeriod(EvaluationPeriod.fromValue(request.getEvaluationPeriod()));
        audit.setMentorId(request.getMentorId());
        new AuditParticipants(audit.getAuditId(), audit.getMentorId(), Role.MENTOR);
        for(InternEntity intern : request.getInterns()) {
            new AuditParticipants(audit.getAuditId(), intern.getUserId(), Role.INTERN);
            auditInternService.createAuditIntern(audit.getAuditId(), intern.getUserId());
        }

//        AuditEntity entity = auditMapper.toEntity(audit);
        return auditRepository.save(audit);
    }

    public Optional<AuditEntity> getAuditById(String id) {
        return auditRepository.findByAuditId(id);
    }


}
