package com.ims.internship_management_system.controller;

import com.ims.internship_management_system.model.AuditEntity;
import com.ims.internship_management_system.model.dto.AuditDto;
import com.ims.internship_management_system.request.AuditFormCreationRequest;
import com.ims.internship_management_system.service.AuditService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(path="/audit")
public class AuditController {
    private final AuditService auditService;

//    @PostMapping(path="/create-new-form")
//    public ResponseEntity<?> addAudit(@RequestBody AuditFormCreationRequest request) {
//        AuditEntity audit = auditService.createAudit(request);
//        return ResponseEntity.ok().body(audit);
//    }


}
