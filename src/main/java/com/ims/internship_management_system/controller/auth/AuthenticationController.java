package com.ims.internship_management_system.controller.auth;


import com.ims.internship_management_system.configs.security.UserPrincipal;
import com.ims.internship_management_system.constant.Auth;
import com.ims.internship_management_system.exception.IMSRuntimeException;
import com.ims.internship_management_system.model.InternEntity;
import com.ims.internship_management_system.model.MentorEntity;
import com.ims.internship_management_system.model.dto.JwtResponse;
import com.ims.internship_management_system.model.dto.LoginRequest;
import com.ims.internship_management_system.model.dto.MentorDto;
import com.ims.internship_management_system.request.InternCreationRequest;
import com.ims.internship_management_system.service.InternService;
import com.ims.internship_management_system.service.MentorService;
import com.ims.internship_management_system.service.security.AuthService;
import com.ims.internship_management_system.util.JWTSecurityUtil;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpCookie;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping(path="/authentication")
public class AuthenticationController {
    private final InternService internService;
    private final AuthService authService;
    private final MentorService mentorService;
    private final PasswordEncoder passwordEncoder;
//    private final Firebas

    @PostMapping(path = "/intern/register")
    public InternEntity internRegister(@RequestBody InternCreationRequest request) {
        return internService.addIntern(request);
    }

    @PostMapping(path="mentor/register")
    public MentorDto mentorRegister(@RequestBody MentorEntity mentor) {
        return mentorService.createMentor(mentor);
    }

    @GetMapping(path="intern-login-info/{id}")
    public ResponseEntity<?> internLoginInfo(@RequestParam String id) {
        Optional<InternEntity> intern = internService.getInternByInternId(id);
            return intern.map(i -> new ResponseEntity<>(
                    "Intern ID: " + i.getUserId()
                            +"\nAccount: "+i.getAccount()
//                            +"\nPassword: "+passwordEncoder.
                            +"\nPassword: "+i.getFirstPass()
                    , HttpStatus.OK))
                    .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
        }

    @PostMapping(path = "/login")
    public ResponseEntity<?> internLogin(@RequestBody LoginRequest request, HttpServletResponse response) {
        JwtResponse jwtResponse = authService.login(request);
        Cookie cookie = new Cookie(Auth.JWT_COOKIE.getValue(), jwtResponse.getToken());
        response.addCookie(cookie);
        return ResponseEntity.ok(jwtResponse);
    }

    @GetMapping(path="get/my-profile")
    public ResponseEntity<?> getMyProfile() {
        var user = JWTSecurityUtil.getJWTUserInfo();
        if (user.isEmpty()) {
            throw new IMSRuntimeException(HttpStatus.UNAUTHORIZED, "Unauthorized");
        }
            return ResponseEntity.ok(user.get());

    }

    @PutMapping(path = "user/change-password")
    public ResponseEntity<?> changePassword(@AuthenticationPrincipal UserPrincipal principal,
                                            @RequestParam String oldPassword,
                                            @RequestParam String newPassword) {
        String s = authService.changePassword(principal, oldPassword, newPassword);
        return ResponseEntity.ok(s);
//        return ResponseEntity.ok().build(s);
    }

    @PostMapping(path="mentor/register/email-and-password")
    public ResponseEntity<?> registerMentorEmail(@RequestBody MentorEntity register) {
        var m = authService.registerWithEmailAndPassword(register);
        return ResponseEntity.ok().body(m);
    }


}



