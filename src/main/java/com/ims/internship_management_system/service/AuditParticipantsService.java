package com.ims.internship_management_system.service;


import com.ims.internship_management_system.constant.Role;
import com.ims.internship_management_system.model.AuditParticipants;
import com.ims.internship_management_system.repository.AuditParticipantsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuditParticipantsService {
    private final AuditParticipantsRepository auditParticipantsRepository;

    public List<AuditParticipants> findAllParticipantsByAuditId(String id) {
        return auditParticipantsRepository.findAllByAuditId(id);
    }

    public List<AuditParticipants> findInternParticipantsByAuditId(String id) {
        return auditParticipantsRepository.findAllByAuditIdAndRole(id, Role.INTERN);
    }

    public AuditParticipants save(AuditParticipants auditParticipants) {
        return auditParticipantsRepository.save(auditParticipants);
    }
}
