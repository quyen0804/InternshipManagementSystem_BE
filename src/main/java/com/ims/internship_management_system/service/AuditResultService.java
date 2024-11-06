package com.ims.internship_management_system.service;


import com.ims.internship_management_system.model.AuditResultEntity;
import com.ims.internship_management_system.model.dto.AuditResultDto;
import com.ims.internship_management_system.repository.AuditResultRepository;
import com.ims.internship_management_system.util.generator.IdGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuditResultService {
    private final AuditResultRepository auditResultRepository;

//    @Scheduled(cron="0 0 8 ? * MON#1")
//    public AuditResultEntity createAuditResult(AuditResultDto auditResultDto) {
//        AuditResultEntity auditResultEntity = new AuditResultEntity();
//        auditResultEntity.setResultId(IdGenerator.generateAuditResultId(auditResultDto.getInternId()));
//        auditResultEntity.setAveResult(0);
//        auditResultEntity.setMentorId(auditResultDto.getMentorId());
//        auditResultEntity.setAveResult(0);
//        auditResultEntity.setResult(false);
//        auditResultRepository.save(auditResultEntity);
//        return auditResultEntity;
//    }

}
