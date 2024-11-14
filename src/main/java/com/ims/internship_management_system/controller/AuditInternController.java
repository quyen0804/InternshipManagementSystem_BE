package com.ims.internship_management_system.controller;


import com.ims.internship_management_system.model.AuditInternEntity;
import com.ims.internship_management_system.model.dto.AuditInternDto;
import com.ims.internship_management_system.model.mapper.AuditInternMapper;
import com.ims.internship_management_system.service.AuditInternService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.method.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path="/audit-form/{auditId}/audit-intern-form")
public class AuditInternController {
    private final AuditInternService auditInternService;
    private final AuditInternMapper auditInternMapper;

    @GetMapping(path = "/my-audit/{id}")
    public List<AuditInternDto> getMyAudit(@PathVariable String id) {
        return auditInternService.getAllAuditInternsByInternId(id);
    }

    @GetMapping(path = "/create")
    public ResponseEntity<AuditInternDto> createAuditIntern(@PathVariable String auditId,
                                                            @RequestParam String internId) {
        AuditInternEntity auditInternEntity = auditInternService.createAuditIntern(auditId, internId);
        if (auditInternEntity != null) {
            AuditInternDto dto = auditInternMapper.toDTO(auditInternEntity);
            return new ResponseEntity<>(dto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
