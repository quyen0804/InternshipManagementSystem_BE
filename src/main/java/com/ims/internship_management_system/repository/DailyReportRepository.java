package com.ims.internship_management_system.repository;


import com.ims.internship_management_system.model.DailyReportEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DailyReportRepository extends JpaRepository<DailyReportEntity, Integer> {


    Optional<DailyReportEntity> findDailyReportEntitiesByDailyReportId(int id);
    Optional<DailyReportEntity> findDailyReportEntitiesByInternId(int id);
    Optional<DailyReportEntity> findDailyReportEntitiesByMentorId(int id);

}
