package com.ims.internship_management_system.model.dto;

import com.ims.internship_management_system.constant.Role;
import lombok.Data;

@Data
public class LoginRequest {
    String username;
    String password;
    Role role;
}
