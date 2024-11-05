package com.ims.internship_management_system.service;

import com.ims.internship_management_system.constant.Role;
import com.ims.internship_management_system.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final InternService internService;
    private final MentorService mentorService;

    public <T> Optional<?> findUserByUserId(String id, T role) {
        if(role == Role.INTERN
                || Integer.parseInt((String) role) == Role.INTERN.ordinal()
                || ((String) role).equalsIgnoreCase(Role.INTERN.name())) {
            return internService.getInternByInternId(id);
        } else if(role == Role.MENTOR
                || Integer.parseInt((String) role) == Role.MENTOR.ordinal()
                || ((String) role).equalsIgnoreCase(Role.MENTOR.name())){
            return mentorService.findById(id);
        }
        return Optional.empty();
    }

    public boolean checkExist(String id){
        return userRepository.existsById(id);
    }
}
