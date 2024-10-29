package com.ims.internship_management_system.repository;

import com.ims.internship_management_system.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity,String> {
    Optional<UserEntity> getUserEntityByAccount(String username);
}
