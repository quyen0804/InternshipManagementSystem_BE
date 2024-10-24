package com.ims.internship_management_system.model;

import com.ims.internship_management_system.constant.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@MappedSuperclass
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    private String userId;

    @Column(nullable = false, unique = true)
    private String account;

    private String password;
    private String fullName;
    private String phone;
    private boolean gender;
    private LocalDate dob;
    private String address;
    private String cccd;

    @Enumerated(EnumType.ORDINAL)
    private Role role;


}
