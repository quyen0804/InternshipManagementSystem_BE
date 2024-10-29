package com.ims.internship_management_system.controller.auth;


import com.ims.internship_management_system.model.InternEntity;
import com.ims.internship_management_system.model.dto.JwtResponse;
import com.ims.internship_management_system.model.dto.LoginRequest;
import com.ims.internship_management_system.request.InternCreationRequest;
import com.ims.internship_management_system.service.InternService;
import com.ims.internship_management_system.service.security.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(path="/authentication")
public class AuthenticationController {
    private final InternService internService;
    private final AuthService authService;

    @PostMapping(path = "/intern/register")
    InternEntity internRegister(@RequestBody InternCreationRequest request) {
        return internService.addIntern(request);
    }

    @PostMapping(path = "/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        JwtResponse jwtResponse = authService.login(request);
        return ResponseEntity.ok(jwtResponse);
    }
}
