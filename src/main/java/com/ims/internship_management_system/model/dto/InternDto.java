package com.ims.internship_management_system.model.dto;

import com.ims.internship_management_system.constant.InternStatus;
import com.ims.internship_management_system.constant.Role;
import com.ims.internship_management_system.constant.InternStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InternDto {
//    String user_id;
    private String account;
//    private String password;
    private String fullName;
    private String phone;
    private boolean gender;
    private LocalDate dob;
    private String address;
    private String cccd;
    private Role role;
    private String avatar;
    private InternStatus status;
    private String mentorName;
}