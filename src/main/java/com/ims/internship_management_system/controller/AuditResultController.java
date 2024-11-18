package com.ims.internship_management_system.controller;


import com.ims.internship_management_system.model.AuditResultEntity;
import com.ims.internship_management_system.model.dto.AuditResultDto;
import com.ims.internship_management_system.model.mapper.AuditResultMapper;
import com.ims.internship_management_system.service.AuditResultService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping(path="/audit-result")
public class AuditResultController {
    private final AuditResultService auditResultService;
    private final AuditResultMapper auditResultMapper;


    @GetMapping(path="intern/find-by-intern/{id}")
    public List<AuditResultDto> findByInternId(@PathVariable String id) {
        return auditResultService.getAuditResultEntitiesByInternId(id).stream().map(auditResultMapper::toDTO).toList();
    }

    @GetMapping(path = "intern/{id}")
    public Optional<AuditResultDto> findById(@PathVariable String id) {
        return auditResultService.getAuditResultEntityByResultId(id).map(auditResultMapper::toDTO);
    }

    @GetMapping(path = "mentor/{id}")
    public List<AuditResultDto> findByMentorId(@PathVariable String id) {
        return auditResultService.getAuditResultEntitiesByMentorId(id).stream().map(auditResultMapper::toDTO).toList();
    }

    @GetMapping(path = "mentor/{id}/get-by-date")
    public List<AuditResultDto> findByMentorAndDate(@PathVariable String id,
                                                    @RequestParam int month,
                                                    @RequestParam int year) {
        return auditResultService.getAuditResultEntitiesByMentorIdAndCreateDate(id, month, year).stream().map(auditResultMapper::toDTO).toList();
    }

    @GetMapping(path="/find-all")
    public List<AuditResultEntity> findAll() {
        return auditResultService.getAllAuditResultEntities();
    }

}
