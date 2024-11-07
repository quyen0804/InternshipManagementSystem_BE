package com.ims.internship_management_system.repository;

import com.ims.internship_management_system.model.GradeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GradeRepository extends JpaRepository<GradeEntity, Integer> {
    Optional<GradeEntity> findByGradeId(int gradeId);
    List<GradeEntity> findGradeEntitiesByAuditInternId(String auditInternId);
}
