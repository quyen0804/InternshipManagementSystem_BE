package com.ims.internship_management_system.repository;

import com.ims.internship_management_system.model.AuditInternEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AuditInternRepository extends JpaRepository<AuditInternEntity, String> {
     List<AuditInternEntity> findAuditInternByInternIdOrderByCreatedTimeDesc(String internId);
     List<AuditInternEntity> findAuditInternByResultIdOrderByCreatedTimeDesc(String resultId);
     Optional<AuditInternEntity> findAuditInternEntityByAuditInternId(String auditInternId);

    List<AuditInternEntity> findAuditInternByAuditId(String id);
}
