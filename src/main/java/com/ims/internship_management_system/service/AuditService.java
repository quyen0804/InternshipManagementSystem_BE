package com.ims.internship_management_system.service;

import com.ims.internship_management_system.constant.EvaluationPeriod;
import com.ims.internship_management_system.model.AuditEntity;
import com.ims.internship_management_system.model.dto.AuditDto;
import com.ims.internship_management_system.model.mapper.AuditMapper;
import com.ims.internship_management_system.repository.AuditRepository;
import com.ims.internship_management_system.request.AuditFormCreationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuditService {
//    @Autowired
    private final AuditRepository auditRepository;
    
//    @Autowired
    private final AuditMapper auditMapper;

    public AuditEntity createAudit(AuditFormCreationRequest request) {
        // Map the DTO to an entity using the mapper
//        AuditEntity entity = new AuditEntity();
        AuditDto audit = new AuditDto();
        audit.setEvaluationPeriod(EvaluationPeriod.fromValue(request.getEvaluationPeriod()));
        audit.setInterns(request.getInterns());
        AuditEntity entity = auditMapper.toEntity(audit);
        return auditRepository.save(entity);
    }
}
