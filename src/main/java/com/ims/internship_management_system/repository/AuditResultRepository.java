package com.ims.internship_management_system.repository;

import com.ims.internship_management_system.model.AuditEntity;
import com.ims.internship_management_system.model.AuditResultEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AuditResultRepository extends JpaRepository<AuditResultEntity, Integer> {
    Optional<AuditResultEntity> findAuditResultEntityByResultId(String resultId);
    List<AuditResultEntity> findAuditResultEntitiesByInternId(String internId);

    List<AuditResultEntity> findAuditResultEntitiesByMentorId(String mentor);

    @Query("SELECT a FROM AuditResultEntity a WHERE MONTH(a.createTime) = :month AND YEAR(a.createTime) = :year AND a.mentorId = :mentorId")
    List<AuditResultEntity> findAllByMentorIdAndCreateDate(@Param("mentorId") String mentorId,
                                                        @Param("month") int month,
                                                        @Param("year") int year);

}
