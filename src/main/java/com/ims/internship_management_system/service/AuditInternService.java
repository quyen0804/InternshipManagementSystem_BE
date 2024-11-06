package com.ims.internship_management_system.service;

import com.ims.internship_management_system.constant.GradeColumn;
import com.ims.internship_management_system.model.AuditInternEntity;
import com.ims.internship_management_system.model.GradeEntity;
import com.ims.internship_management_system.model.dto.AuditInternDto;
import com.ims.internship_management_system.model.mapper.AuditInternMapper;
import com.ims.internship_management_system.repository.AuditInternRepository;
import com.ims.internship_management_system.util.generator.IdGenerator;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuditInternService {
    private final AuditInternRepository auditInternRepository;
    private final AuditInternMapper auditInternMapper;
//    private final AuditService auditService;


    public AuditInternEntity createAuditIntern(String auditId, String internId) {
        AuditInternEntity auditInternEntity = new AuditInternEntity();
        auditInternEntity.setAuditID(auditId);
        auditInternEntity.setResultId(IdGenerator.generateAuditResultId(internId));
        auditInternEntity.setAuditInternId(IdGenerator.generateAuditInternId(internId));
        return auditInternRepository.save(auditInternEntity);
    }

    public List<AuditInternDto> getAllAuditInterns() {
        return auditInternRepository.findAll().stream().map(auditInternMapper::toDTO).toList();
    }

    public List<AuditInternDto> getAllAuditInternsByInternId(String internId) {
        return auditInternRepository.findAuditInternByInternId(internId).stream().map(auditInternMapper::toDTO).toList();
    }

    public List<AuditInternDto> getAllAuditInternsByResultId(String resultId) {
        return auditInternRepository.findAuditInternByResultId(resultId).stream().map(auditInternMapper::toDTO).toList();
    }

    public Optional<AuditInternDto> getAuditInternsByAuditInternId(String id, double value) {
        return auditInternRepository.findAuditInternEntityByAuditInternId(id).map(auditInternMapper::toDTO);
    }

    public AuditInternDto addAuditInternGrade(String id, Map<GradeColumn, Map<Double, String>> columns) {
        Optional<AuditInternEntity> optionalEntity = auditInternRepository.findAuditInternEntityByAuditInternId(id);

        if (optionalEntity.isPresent()) {
            AuditInternEntity auditInternEntity = optionalEntity.get();
            double sum=0;
            for (Map.Entry<GradeColumn, Map<Double, String>> entry : columns.entrySet()) {
                GradeColumn column = entry.getKey();
                Map<Double, String> gradeData = entry.getValue();

                for (Map.Entry<Double, String> gradeEntry : gradeData.entrySet()) {
                    double value = gradeEntry.getKey();
                    String description = gradeEntry.getValue();

                    GradeEntity grade = new GradeEntity(auditInternEntity.getAuditInternId(),
                            column, value, description);

                    sum += value;
                }
            }
            auditInternEntity.setAveGrade(sum/3);
            return auditInternMapper.toDTO(auditInternRepository.save(auditInternEntity));
        }else{
            throw new EntityNotFoundException("Audit Intern Form with id " + id + " not found");
        }
    }

}
