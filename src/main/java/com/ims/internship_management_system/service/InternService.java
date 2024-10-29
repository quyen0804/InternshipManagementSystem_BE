package com.ims.internship_management_system.service;

import com.ims.internship_management_system.constant.InternStatus;
import com.ims.internship_management_system.constant.Role;
import com.ims.internship_management_system.model.InternEntity;
import com.ims.internship_management_system.model.dto.InternDto;
import com.ims.internship_management_system.model.mapper.InternMapper;
import com.ims.internship_management_system.repository.InternRepository;
import com.ims.internship_management_system.request.InternCreationRequest;
import com.ims.internship_management_system.service.security.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InternService {
    private final InternRepository internRepository;
    private final InternMapper internMapper;
//    private final PasswordEncoder passwordEncoder;
    private final AuthService authService;

    public InternEntity addIntern(InternCreationRequest request) {
        InternEntity intern = new InternEntity();
        String[] i = request.getAccount().split("@");
        intern.setUserId(i[0].toUpperCase());
        intern.setAccount(request.getAccount());
        intern.setFullName(request.getFullName());
        intern.setPassword(authService.passwordHash(request.getPassword()));
        intern.setDob(request.getDob());
        intern.setPhone(request.getPhone());
        intern.setGender(request.isGender());
        intern.setAddress(request.getAddress());
        intern.setRole(Role.INTERN);
        intern.setStatus(InternStatus.ACTIVE);
        intern.setAvatar(request.getAvatar());
        return internRepository.save(intern);
    }

    public List<InternDto> getAllInterns() {
        return internRepository.findAll().stream()
                .map(internMapper::toDTO)
                .toList();
    }

    public Optional<InternDto> getInternByInternId(String id) {
        return internRepository.findInternEntityByUserId(id).map(internMapper::toDTO);
    }

    public void deleteInternByInternId(String id) {
        Optional<InternEntity> intern = internRepository.findInternEntityByUserId(id);
        intern.ifPresent(internRepository::delete);
    }

//    public Optional<InternDto> searchInternEntitiesByInput(@Param("input") String input){
//        return internRepository.searchInternEntitiesByInput(input).map(internMapper::toDTO);
//    }
}
