package com.ims.internship_management_system.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginRequest {
    String email;
    String password;
//    Role role;
}
