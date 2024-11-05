package com.ims.internship_management_system.repository;

import com.ims.internship_management_system.model.MentorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MentorRepository extends JpaRepository<MentorEntity, Integer> {
     Optional<MentorEntity> findByAccountOrUserId(String email, String id);
     Optional<MentorEntity> findByAccount(String email);
     Optional<MentorEntity> findByUserId(String id);

     List<MentorEntity> findByBu(String bu);
//     MentorEntity findByBu(String bu);

//    Optional<MentorEntity> searchMentorEntitiesByInput(@Param("input") String input);
}
