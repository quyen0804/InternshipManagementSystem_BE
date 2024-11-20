package com.ims.internship_management_system.repository;


import com.ims.internship_management_system.constant.Role;
import com.ims.internship_management_system.model.AuditEntity;
import com.ims.internship_management_system.model.AuditInternEntity;
import com.ims.internship_management_system.model.AuditParticipants;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuditParticipantsRepository extends JpaRepository<AuditParticipants, String> {
    List<AuditParticipants> findAllByAuditId(String id);
    List<AuditParticipants> findAllByAuditIdAndRole(String id, Role role);
}
