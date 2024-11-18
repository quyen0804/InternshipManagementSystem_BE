package com.ims.internship_management_system.controller;


import com.ims.internship_management_system.exception.IMSRuntimeException;
import com.ims.internship_management_system.model.AuditInternEntity;
import com.ims.internship_management_system.model.dto.AuditInternDto;
import com.ims.internship_management_system.model.dto.GradeDto;
import com.ims.internship_management_system.model.mapper.AuditInternMapper;
import com.ims.internship_management_system.service.AuditInternService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.method.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping(path="/audit-form/audit-intern-form")
public class AuditInternController {
    private final AuditInternService auditInternService;
    private final AuditInternMapper auditInternMapper;

    @GetMapping(path = "/my-audit/{id}")
    public List<AuditInternDto> getMyAudit(@PathVariable String id) {
        return auditInternService.getAllAuditInternsByInternId(id);
    }

//    @PostMapping(path = "/create")
//    public ResponseEntity<AuditInternDto> createAuditIntern(@PathVariable String auditId,
//                                                            @RequestParam String internId) {
//        AuditInternEntity auditInternEntity = auditInternService.createAuditIntern(auditId, internId);
//        if (auditInternEntity != null) {
//            AuditInternDto dto = auditInternMapper.toDTO(auditInternEntity);
//            return new ResponseEntity<>(dto, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<AuditInternDto> getAuditInternById(@PathVariable String id) {
        Optional<AuditInternDto> dto = auditInternService.getAuditInternsByAuditInternId(id);
        return new ResponseEntity<>(
                dto.orElseThrow(() -> new IMSRuntimeException(HttpStatus.NOT_FOUND,
                        "Internal error. Try again.")), HttpStatus.OK);
    }

    @PutMapping(path="{id}/evaluation")
    public ResponseEntity<AuditInternDto> evaluation(@PathVariable String id,
                                                     @RequestBody List<GradeDto> columns){
        AuditInternDto edited = auditInternService.addAuditInternGrade(id, columns);
        return ResponseEntity.ok().body(edited);


    }

    @DeleteMapping(path = "{id}/delete")
    public ResponseEntity<?> deleteAuditIntern(@PathVariable String id) {
        auditInternService.deleteAuditIntern(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping(path="{id}/edit")
    public ResponseEntity<?> editGrade(@PathVariable String id, List<GradeDto> columns){
        auditInternService.updateGrade(id, columns);
        return new ResponseEntity<>("Edit successful.", HttpStatus.OK);
    }



}
