package com.ims.internship_management_system.repository;

import com.ims.internship_management_system.model.InternEntity;
import jakarta.persistence.NamedNativeQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InternRepository extends JpaRepository<InternEntity, Integer> {
    Optional<InternEntity> findInternEntityByMentorId(String id);

//    @Query
//    Optional<InternEntity> searchInternEntitiesByInput(@Param("input") String input);
    Optional<InternEntity> findInternEntityByUserId(String internId);

    Optional<InternEntity> findInternEntityByAccount(String account);


}
