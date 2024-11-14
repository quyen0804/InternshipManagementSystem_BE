package com.ims.internship_management_system.model.dto;

import com.ims.internship_management_system.constant.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MentorDto {
    private String userId;
    private String account;
//    private String password;
    private String fullName;
    private String phone;
    private boolean gender;
    private LocalDate dob;
    private String address;
    private String socialNum;
    private Role role;
    private String bu;

    public void setRole(Role role) {
        this.role = Role.MENTOR;
    }
}
