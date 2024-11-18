package com.ims.internship_management_system.service;


import com.ims.internship_management_system.constant.InternStatus;
import com.ims.internship_management_system.model.AuditInternEntity;
import com.ims.internship_management_system.model.AuditResultEntity;
import com.ims.internship_management_system.model.InternEntity;
import com.ims.internship_management_system.model.MentorEntity;
import com.ims.internship_management_system.model.dto.AuditInternDto;
import com.ims.internship_management_system.repository.AuditResultRepository;
import com.ims.internship_management_system.repository.InternRepository;
import com.ims.internship_management_system.util.generator.IdGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuditResultService {

    private final AuditResultRepository auditResultRepository;
    private final InternService internService;
    private final AuditInternService auditInternService;
    private final InternRepository internRepository;

    @Autowired
    public AuditResultService(AuditResultRepository auditResultRepository, InternService internService, AuditInternService auditInternService, InternRepository internRepository) {
        this.auditResultRepository = auditResultRepository;
        this.internService = internService;
        this.auditInternService = auditInternService;
        this.internRepository = internRepository;
    }

    // Scheduled method must be no-arg
    @Scheduled(cron = "0 0 8 ? * MON#1")
//    @Scheduled(cron = "0 * * * * *")
    public void createAuditResult() {

        List<InternEntity> allActiveIntern=internService.findAllActiveInterns();
        for(InternEntity internEntity : allActiveIntern) {
            AuditResultEntity auditResultEntity = new AuditResultEntity();
            auditResultEntity.setResultId(IdGenerator.generateAuditResultId(internEntity.getUserId()));
            auditResultEntity.setInternId(internEntity.getUserId());
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

            // change status intern
            changeQualifyStatus(internEntity);
        }


        }

        public InternEntity changeQualifyStatus(InternEntity intern){
        int count = 0;
        List<AuditResultEntity> results =
                auditResultRepository.findAuditResultEntitiesByInternId(intern.getUserId());
        for(AuditResultEntity auditResultEntity : results) {
            if(auditResultEntity.isQualify()==false){
                count++;
            }
        }
        if(count>=2){
            intern.setStatus(InternStatus.DISQUALIFIED);
        }
        return internRepository.save(intern);
    }

    public List<AuditResultEntity> getAuditResultEntitiesByInternId(String id) {
        return auditResultRepository.findAuditResultEntitiesByInternId(id);
    }

    public Optional<AuditResultEntity> getAuditResultEntityByResultId(String id) {
        return auditResultRepository.findAuditResultEntityByResultId(id);
    }

    public List<AuditResultEntity> getAuditResultEntitiesByMentorId(String mentor) {
        return auditResultRepository.findAuditResultEntitiesByMentorId(mentor);
    }

    public List<AuditResultEntity> getAuditResultEntitiesByMentorIdAndCreateDate(String mentor,
                                                                                 int month, int year) {
        return auditResultRepository.findAllByMentorIdAndCreateDate(mentor, month, year);
    }

    public List<AuditResultEntity> getAllAuditResultEntities(){
        return auditResultRepository.findAll();
    }


}

