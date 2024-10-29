package com.ims.internship_management_system.repository;

import com.ims.internship_management_system.model.AuditInternEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditInternRepository extends JpaRepository<AuditInternEntity, Integer> {
}
