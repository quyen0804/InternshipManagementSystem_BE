package com.ims.internship_management_system.repository;

import com.ims.internship_management_system.model.AuditEntity;
//import com.ims.internship_management_system.repository.impl.AuditRepositoryImpl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface AuditRepository extends JpaRepository<AuditEntity, String> {
    Optional<AuditEntity> findByAuditId(String id);

    List<AuditEntity> findByMentorId(String id);

    @Query("SELECT a FROM AuditEntity a WHERE MONTH(a.date) = :month AND YEAR(a.date) = :year")
    List<AuditEntity> findByMonthAndYear(@Param("month") int month,
                                                  @Param("year") int year);
}
