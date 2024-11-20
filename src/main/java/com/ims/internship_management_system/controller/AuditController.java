package com.ims.internship_management_system.controller;

import com.ims.internship_management_system.exception.IMSRuntimeException;
import com.ims.internship_management_system.model.AuditEntity;
import com.ims.internship_management_system.model.dto.AuditDto;
import com.ims.internship_management_system.model.mapper.AuditMapper;
import com.ims.internship_management_system.request.AuditFormCreationRequest;
import com.ims.internship_management_system.service.AuditService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping(path="/audit")
public class AuditController {
    private final AuditService auditService;
    private final AuditMapper auditMapper;

    @PostMapping(path="/create-new-form")
    public ResponseEntity<?> createAudit(@RequestBody AuditFormCreationRequest request) {
        AuditEntity audit = auditService.createAudit(request);
        return ResponseEntity.ok().body(audit);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getAuditByAuditId(@PathVariable String id) {
        Optional<AuditEntity> audit = auditService.getAuditById(id);
        return ResponseEntity.ok().body(audit);
    }

    @GetMapping(path = "/get-by-month")
    public ResponseEntity<?> getAuditsByMonth(@RequestParam int month, @RequestParam int year) {
            List<AuditDto> list =
                auditService.findAuditByMonth(month, year)
                        .stream().map(audit -> auditMapper.toDTO(audit,
                            auditService.getParticipants(audit),
                            auditService.getAuditInterns(audit))).toList();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(path = "/get-by-mentor/{mentorId}")
    public ResponseEntity<?> getAuditsByMentor(@PathVariable String mentorId) {
        List<AuditDto> list =
                auditService.getAuditByMentorID(mentorId).stream()
                        .map(audit -> auditMapper.toDTO(audit,
                                auditService.getParticipants(audit),
                                auditService.getAuditInterns(audit))).toList();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(path = "/get-all")
    public ResponseEntity<?> getAllAudits() {
        List<AuditDto> audit = auditService.findAll().stream()
                .map(entity ->  auditMapper.toDTO(entity, auditService.getParticipants(entity),
                    auditService.getAuditInterns(entity))
                ).toList();
        return ResponseEntity.ok().body(audit);
    }


}
