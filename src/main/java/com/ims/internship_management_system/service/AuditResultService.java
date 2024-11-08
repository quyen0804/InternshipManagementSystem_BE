package com.ims.internship_management_system.service;


import com.ims.internship_management_system.model.AuditInternEntity;
import com.ims.internship_management_system.model.AuditResultEntity;
import com.ims.internship_management_system.model.InternEntity;
import com.ims.internship_management_system.model.dto.AuditInternDto;
import com.ims.internship_management_system.model.dto.AuditResultDto;
import com.ims.internship_management_system.repository.AuditResultRepository;
import com.ims.internship_management_system.repository.InternRepository;
import com.ims.internship_management_system.util.generator.IdGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class AuditResultService {

    private final AuditResultRepository auditResultRepository;
    private final InternService internService;
    private final AuditInternService auditInternService;

    @Autowired
    public AuditResultService(AuditResultRepository auditResultRepository, InternService internService, AuditInternService auditInternService) {
        this.auditResultRepository = auditResultRepository;
        this.internService = internService;
        this.auditInternService = auditInternService;
    }

    // Scheduled method must be no-arg
    @Scheduled(cron = "0 0 8 ? * MON#1")
    public void createAuditResult() {

        List<InternEntity> allActiveIntern=internService.findAllActiveInterns();
        for(InternEntity internEntity : allActiveIntern) {
            AuditResultEntity auditResultEntity = new AuditResultEntity();
            auditResultEntity.setResultId(IdGenerator.generateAuditResultId(internEntity.getUserId()));
            auditResultEntity.setAveResult(0);
            auditResultEntity.setMentorId(internEntity.getMentorId());
            auditResultEntity.setQualify(false);

            auditResultRepository.save(auditResultEntity);
        }

    }


    @Scheduled(cron = "0 0 8 ? * 5L")
    public void updateAuditResult() {
        List<InternEntity> allActiveIntern=internService.findAllActiveInterns();

        for(InternEntity internEntity : allActiveIntern) {
            AuditResultEntity auditResultEntity =
                    auditResultRepository
                            .findAuditResultEntityByResultId(
                                    IdGenerator.generateAuditResultId(
                                            internEntity.getUserId()))
                            .get();
            List<AuditInternDto> auditIntern =
                    auditInternService.getAllAuditInternsByResultId(auditResultEntity.getResultId());
            double totalSum=0;
            for(AuditInternDto dto : auditIntern) {
                totalSum+=dto.getAveGrade();
            }
            auditResultEntity.setAveResult(totalSum/auditIntern.size());
            auditResultEntity.setQualify(auditResultEntity.getAveResult() >= 5 ? true : false);

        }
    }

}

