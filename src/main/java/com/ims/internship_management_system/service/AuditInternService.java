package com.ims.internship_management_system.service;

import com.ims.internship_management_system.model.AuditInternEntity;
import com.ims.internship_management_system.model.GradeEntity;
import com.ims.internship_management_system.model.dto.AuditInternDto;
import com.ims.internship_management_system.model.dto.GradeDto;
import com.ims.internship_management_system.model.mapper.AuditInternMapper;
import com.ims.internship_management_system.repository.AuditInternRepository;
import com.ims.internship_management_system.repository.GradeRepository;
import com.ims.internship_management_system.util.generator.IdGenerator;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuditInternService {
    private final AuditInternRepository auditInternRepository;
    private final AuditInternMapper auditInternMapper;
    private final GradeRepository gradeRepository;
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
        return auditInternRepository.findAuditInternByInternIdOrderByCreatedTimeDesc(internId).stream().map(auditInternMapper::toDTO).toList();
    }

    public List<AuditInternDto> getAllAuditInternsByResultId(String resultId) {
        return auditInternRepository.findAuditInternByResultIdOrderByCreatedTimeDesc(resultId).stream().map(auditInternMapper::toDTO).toList();
    }

    public Optional<AuditInternDto> getAuditInternsByAuditInternId(String id) {
        return auditInternRepository.findAuditInternEntityByAuditInternId(id).map(auditInternMapper::toDTO);
    }

    public AuditInternDto addAuditInternGrade(String id, List<GradeDto> columns) {
        Optional<AuditInternEntity> optionalEntity = auditInternRepository.findAuditInternEntityByAuditInternId(id);

        if (optionalEntity.isPresent()) {
            AuditInternEntity auditInternEntity = optionalEntity.get();
            double sum=0;
            for(GradeDto grade: columns){
                    new GradeEntity(auditInternEntity.getAuditInternId(),
                            grade.getName(), grade.getValue(), grade.getDescription());

                    sum += grade.getValue();
                }

            auditInternEntity.setAveGrade(sum/3);
            return auditInternMapper.toDTO(auditInternRepository.save(auditInternEntity));
        }else{
            throw new EntityNotFoundException("Audit Intern Form with id " + id + " not found");
        }
    }

    public AuditInternDto updateGrade(String id, List<GradeDto> columns) {
        AuditInternEntity auditIntern =
                auditInternRepository.findAuditInternEntityByAuditInternId(id).get();
        List<GradeEntity> grades = gradeRepository.findGradeEntitiesByAuditInternId(id);
        double sum=0;
        for(GradeEntity grade: grades){
            for(GradeDto gradeDto: columns){
                if(grade.getName().equals(gradeDto.getName())){
                    grade.setValue(gradeDto.getValue());
                    grade.setDescription(gradeDto.getDescription());
                    gradeRepository.save(grade);
                    sum += grade.getValue();
                }
            }
        }
            auditIntern.setAveGrade(sum/3);
          return auditInternMapper.toDTO(auditInternRepository.save(auditIntern));

    }

}
