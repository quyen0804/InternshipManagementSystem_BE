package com.ims.internship_management_system.service.security;

import com.ims.internship_management_system.exception.IMSRuntimeException;
import com.ims.internship_management_system.model.dto.JwtResponse;
import com.ims.internship_management_system.model.dto.LoginRequest;
import com.ims.internship_management_system.repository.InternRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final PasswordEncoder passwordEncoder;
    private final InternRepository internRepository;
    private final JwtService jwtService;


    public boolean checkPassword(String rawPassword, String storedHashedPassword) {
        return passwordEncoder.matches(rawPassword, storedHashedPassword);
    }

    public String passwordHash(String rawPassword) {
        return passwordEncoder.encode(rawPassword);
    }

    public JwtResponse login(LoginRequest loginRequest) {
        var i = internRepository.findInternEntityByAccount(
                loginRequest.getUsername()).orElseThrow(()
                -> new IMSRuntimeException(HttpStatus.NOT_FOUND,"User not found"));
        if(!passwordEncoder.matches(loginRequest.getPassword(), i.getPassword())){
            throw new IMSRuntimeException(HttpStatus.BAD_REQUEST,"Wrong password");
        }
        String token =  jwtService.generateTokenFromUsernameAndRole(loginRequest.getUsername(), loginRequest.getRole());
        return new JwtResponse(token);
    }
}
