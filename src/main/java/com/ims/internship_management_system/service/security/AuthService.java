package com.ims.internship_management_system.service.security;

import com.ims.internship_management_system.constant.InternStatus;
import com.ims.internship_management_system.constant.LetterAndNumber;
import com.ims.internship_management_system.exception.IMSRuntimeException;
import com.ims.internship_management_system.model.InternEntity;
import com.ims.internship_management_system.model.dto.JwtResponse;
import com.ims.internship_management_system.model.dto.LoginRequest;
import com.ims.internship_management_system.repository.InternRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final PasswordEncoder passwordEncoder;
    private final InternRepository internRepository;
    private final JwtService jwtService;
    private static final SecureRandom random = new SecureRandom();
    public static final String PASSWORD_BASE = LetterAndNumber.LOWERCASE_LETTER.getValue()
            + LetterAndNumber.UPPERCASE_LETTER.getValue()
            + LetterAndNumber.NUMBER.getValue()
            + LetterAndNumber.SPECIAL_CHAR.getValue();

    public boolean checkPassword(String rawPassword, String storedHashedPassword) {
        return passwordEncoder.matches(rawPassword, storedHashedPassword);
    }

    public String generatePassword(int length) {
        if (length < 1) throw new IllegalArgumentException("Password length must be greater than zero.");

        StringBuilder password = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(PASSWORD_BASE.length());
            password.append(PASSWORD_BASE.charAt(randomIndex));
        }
        return new String(password);
    }

    public List<InternEntity> findAllActiveIntern(InternStatus status) {
        return internRepository.findAllByStatus(InternStatus.ACTIVE);
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
