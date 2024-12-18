package com.ims.internship_management_system.model;

import com.ims.internship_management_system.constant.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {

    @Id
    @Column(unique = true, nullable = false)
    private String userId;

    @Column(unique = true, nullable = false)
    private String account;

    private String password;
    private String fullName;
    private String phone;
    private boolean gender;
    private LocalDate dob;
    private String address;
    private String socialNum;

    @Enumerated(EnumType.ORDINAL)
    private Role role;


}
