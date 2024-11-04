package com.ims.internship_management_system.controller.auth;


import com.ims.internship_management_system.model.InternEntity;
import com.ims.internship_management_system.model.dto.JwtResponse;
import com.ims.internship_management_system.model.dto.LoginRequest;
import com.ims.internship_management_system.request.InternCreationRequest;
import com.ims.internship_management_system.service.InternService;
import com.ims.internship_management_system.service.security.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping(path="/authentication")
public class AuthenticationController {
    private final InternService internService;
    private final AuthService authService;
    private final PasswordEncoder passwordEncoder;

    @PostMapping(path = "/intern/register")
    InternEntity internRegister(@RequestBody InternCreationRequest request) {
        return internService.addIntern(request);
    }

    @GetMapping(path="intern-login-info/{id}")
    public ResponseEntity<?> internLoginInfo(@RequestParam String id) {
        Optional<InternEntity> intern = internService.getInternByInternId(id);
            return intern.map(i -> new ResponseEntity<>(
                    "Intern ID: " + i.getUserId()
                            +"\nAccount: "+i.getAccount()
//                            +"\nPassword: "+passwordEncoder.
                            +"\nPassword: "+i.getPassword()
                    , HttpStatus.OK))
                    .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
        }

    @PostMapping(path = "/login")
    public ResponseEntity<?> internLogin(@RequestBody LoginRequest request) {
        JwtResponse jwtResponse = authService.login(request);
        return ResponseEntity.ok(jwtResponse);
    }

}



