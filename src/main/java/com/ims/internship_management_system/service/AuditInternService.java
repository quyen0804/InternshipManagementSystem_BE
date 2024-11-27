package com.ims.internship_management_system.service;

import com.ims.internship_management_system.exception.IMSRuntimeException;
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
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuditInternService {
    private final AuditInternRepository auditInternRepository;
    private final AuditInternMapper auditInternMapper;
    private final GradeRepository gradeRepository;
//    private final AuditService auditService;


    public AuditInternEntity createAuditIntern(String auditId, String internId, String mentorId) {
        AuditInternEntity auditInternEntity = new AuditInternEntity();
        auditInternEntity.setAuditId(auditId);
        auditInternEntity.setResultId(IdGenerator.generateAuditResultId(internId));
        auditInternEntity.setAuditInternId(IdGenerator.generateAuditInternId(internId));
        auditInternEntity.setInternId(internId);
        auditInternEntity.setMentorId(mentorId);
        try {
            return auditInternRepository.save(auditInternEntity);
        }catch (Exception e){
            throw new IMSRuntimeException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    public List<AuditInternDto> getAllAuditInterns() {
        List<AuditInternEntity> auditInternEntities = auditInternRepository.findAll();
        return getListDtoFromListEntity(auditInternEntities);
    }

    public List<AuditInternDto> getListDtoFromListEntity(List<AuditInternEntity> auditInternEntities) {
        List<AuditInternDto> auditInternDtos = new ArrayList<>();
        for (AuditInternEntity auditInternEntity : auditInternEntities) {
            List<GradeEntity> grades = gradeRepository.findGradeEntitiesByAuditInternId(auditInternEntity.getAuditInternId());
            auditInternDtos.add(auditInternMapper.toDTO(auditInternEntity, grades));
        }
        return auditInternDtos;
    }

    public List<AuditInternDto> getAllAuditInternsByInternId(String internId) {
        return getListDtoFromListEntity(auditInternRepository.findAuditInternByInternIdOrderByCreatedTimeDesc(internId));
    }

    public List<AuditInternDto> getAllAuditInternsByResultId(String resultId) {
        return getListDtoFromListEntity(auditInternRepository.findAuditInternByResultIdOrderByCreatedTimeDesc(resultId));
    }

    public List<AuditInternEntity> getByMentorId(String mentorId) {
        return auditInternRepository.findAuditInternByMentorId(mentorId);
    }

    public AuditInternDto getAuditInternsByAuditInternId(String id) {
        List<GradeEntity> grades = gradeRepository.findGradeEntitiesByAuditInternId(id);
        return auditInternMapper
                .toDTO(
                        auditInternRepository
                                .findAuditInternEntityByAuditInternId(id)
                                .orElseThrow(() -> new IMSRuntimeException(HttpStatus.NOT_FOUND,
                                 "audit intern form not found"
                                )),grades);
    }

    public List<AuditInternEntity> getAuditInternsByAuditId(String id) {
        return auditInternRepository.findAuditInternByAuditId(id);
    }

    public AuditInternDto addAuditInternGrade(String id, List<GradeDto> columns) {
        Optional<AuditInternEntity> optionalEntity = auditInternRepository.findAuditInternEntityByAuditInternId(id);
//        AuditInternDto edited = auditInternRepository.
        if (optionalEntity.isPresent()) {
            AuditInternEntity auditInternEntity = optionalEntity.get();
            double sum=0;
            for(GradeDto grade: columns){
                    gradeRepository.save(new GradeEntity(auditInternEntity.getAuditInternId(),
                            grade.getName(), grade.getValue(), grade.getDescription()));
                    sum += grade.getValue();
                }
            auditInternEntity.setAveGrade(sum/3);
            AuditInternEntity entity = auditInternRepository.save(auditInternEntity);
            return auditInternMapper.toDTO(entity,
                    gradeRepository.findGradeEntitiesByAuditInternId(entity.getAuditInternId()));
        }else{
            throw new EntityNotFoundException("Audit Intern Form with id " + id + " not found");
        }
    }

    public AuditInternDto updateGrade(String id, List<GradeDto> columns) {
        AuditInternEntity auditIntern =
                auditInternRepository.findAuditInternEntityByAuditInternId(id)
                        .orElseThrow(() -> new IMSRuntimeException(HttpStatus.NOT_FOUND, "audit intern form not found"));
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
        AuditInternEntity auditInternEntity = auditInternRepository.save(auditIntern);
          return auditInternMapper.toDTO(auditInternEntity,
                  gradeRepository.findGradeEntitiesByAuditInternId(auditInternEntity.getAuditInternId()));

    }

    public void deleteAuditIntern(String id) {
        Optional<AuditInternEntity> optionalEntity = auditInternRepository.findAuditInternEntityByAuditInternId(id);
        if (optionalEntity.isPresent()) {
            AuditInternEntity auditInternEntity = optionalEntity.get();
            auditInternRepository.delete(auditInternEntity);
        }else{
            throw new IMSRuntimeException(HttpStatus.NOT_FOUND,
                    "Audit Intern Form with id " + id + " not found");
        }
    }

}
