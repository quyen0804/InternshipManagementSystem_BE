package com.ims.internship_management_system.service;

import com.ims.internship_management_system.model.AuditInternEntity;
import com.ims.internship_management_system.model.dto.AuditInternDto;
import com.ims.internship_management_system.model.mapper.AuditInternMapper;
import com.ims.internship_management_system.repository.AuditInternRepository;
import com.ims.internship_management_system.util.generator.IdGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuditInternService {
    private final AuditInternRepository auditInternRepository;
    private final AuditInternMapper auditInternMapper;
    private final AuditService auditService;


    public AuditInternEntity createAuditIntern(String auditId, String internId) {
        AuditInternEntity auditInternEntity = new AuditInternEntity();
        auditInternEntity.setAuditID(auditId);
        auditInternEntity.setResultId(IdGenerator.generateAuditResultId(internId));
        auditInternEntity.setAuditInternId(IdGenerator.generateAuditInternId(internId));
        return auditInternRepository.save(auditInternEntity);
    }


}
