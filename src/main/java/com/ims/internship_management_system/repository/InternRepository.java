package com.ims.internship_management_system.repository;

import com.ims.internship_management_system.constant.InternStatus;
import com.ims.internship_management_system.model.InternEntity;
import com.ims.internship_management_system.model.dto.InternDto;
import jakarta.persistence.NamedNativeQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InternRepository extends JpaRepository<InternEntity, Integer> {
    List<InternEntity> findInternEntityByMentorId(String id);
    List<InternEntity> findAllByStatus(InternStatus internStatus);
    List<InternEntity> findAllByStatusAndMentorId(InternStatus internStatus, String mentorId);
//    @Query
//    Optional<InternEntity> searchInternEntitiesByInput(@Param("input") String input);
    Optional<InternEntity> findInternEntityByUserId(String internId);

    Optional<InternEntity> findInternEntityByAccount(String account);

//    List<InternEntity> findInternEntitiesByFullNameOrAccountOrPhoneOrSocialNumLikeIgnoreCase(String name,
//                                                                            String account, String phone, String socialNum);

    @Query("SELECT i FROM InternEntity i WHERE " +
            "(:name IS NULL OR LOWER(i.fullName) LIKE LOWER(:name)) AND " +
            "(:account IS NULL OR LOWER(i.account) LIKE LOWER(:account)) AND " +
            "(:phone IS NULL OR LOWER(i.phone) LIKE LOWER(:phone)) AND " +
            "(:social IS NULL OR LOWER(i.socialNum) LIKE LOWER(:social))")
    List<InternEntity> findInternByDynamicQuery(@Param("name") String name,
                                                 @Param("account") String account,
                                                 @Param("phone") String phone,
                                                 @Param("social") String social);

    @Query("SELECT i FROM InternEntity i WHERE " +
            "LOWER(i.fullName) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(i.account) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(i.phone) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(i.socialNum) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<InternEntity> searchByKeyword(@Param("keyword") String keyword);


}
