package com.ims.internship_management_system.service.security;

import com.ims.internship_management_system.configs.security.UserPrincipal;
import com.ims.internship_management_system.constant.InternStatus;
import com.ims.internship_management_system.constant.LetterAndNumber;
import com.ims.internship_management_system.constant.Role;
import com.ims.internship_management_system.exception.IMSRuntimeException;
import com.ims.internship_management_system.model.InternEntity;
import com.ims.internship_management_system.model.UserEntity;
import com.ims.internship_management_system.model.dto.JwtResponse;
import com.ims.internship_management_system.model.dto.LoginRequest;
import com.ims.internship_management_system.repository.InternRepository;
import com.ims.internship_management_system.repository.UserRepository;
import lombok.RequiredArgsConstructor;
//import lombok.var;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final PasswordEncoder passwordEncoder;
    private final InternRepository internRepository;
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private static final SecureRandom random = new SecureRandom();
    public static final String PASSWORD_BASE = LetterAndNumber.LOWERCASE_LETTER.getValue()
            + LetterAndNumber.UPPERCASE_LETTER.getValue()
            + LetterAndNumber.NUMBER.getValue()
            + LetterAndNumber.SPECIAL_CHAR.getValue();


    public String generatePassword(int length) {
        if (length < 1) throw new IllegalArgumentException("Password length must be greater than zero.");

        StringBuilder password = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(PASSWORD_BASE.length());
            password.append(PASSWORD_BASE.charAt(randomIndex));
        }
        return new String(password);
    }



//    public String passwordHash(String rawPassword) {
//        return passwordEncoder.encode(rawPassword);
//    }

    public String changePassword(UserPrincipal user, String oldPassword, String newPassword) {
        if(passwordEncoder.matches(oldPassword, user.getPassword())) {
            var u =
                    userRepository.findById(user.getId()).orElseThrow(()->
                            new IMSRuntimeException(HttpStatus.INTERNAL_SERVER_ERROR,"User not found"));
            u.setPassword(passwordEncoder.encode(newPassword));
            userRepository.save(u);
            return "Set password successful";
        }else{
            throw new IMSRuntimeException(HttpStatus.NOT_FOUND,"Wrong password");
        }
    }


    public JwtResponse login(LoginRequest loginRequest) {
        var i = userRepository.getUserEntityByAccount(
                loginRequest.getUsername()).orElseThrow(()
                -> new IMSRuntimeException(HttpStatus.NOT_FOUND,"User not found"));
            if(!passwordEncoder.matches(loginRequest.getPassword(), i.getPassword())){
                throw new IMSRuntimeException(HttpStatus.BAD_REQUEST,"Wrong password");
            }
        String token =  jwtService.generateTokenFromUsernameAndRole(loginRequest.getUsername(), i.getRole());
        return new JwtResponse(token);
    }
}
