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
import org.springframework.stereotype.Service;

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


        intern.setUserId(getIdFromAccount(request.getAccount()));
        intern.setAccount(request.getAccount());
        intern.setFullName(request.getFullName());
//        intern.setPassword(authService.passwordHash(authService.generatePassword(8)));
        intern.setPassword(authService.generatePassword(8));
//        intern.setDob(request.getDob());
//        intern.setPhone(request.getPhone());
//        intern.setGender(request.isGender());
//        intern.setAddress(request.getAddress());
        intern.setRole(Role.INTERN);
        intern.setStatus(InternStatus.ACTIVE);
        intern.setSocialNum(request.getSocialNum());
        intern.setMentorId(getIdFromAccount(request.getMentorAccount()));
//        intern.setAvatar(request.getAvatar());

        return internRepository.save(intern);
    }

    public List<InternDto> getAllInterns() {
        return internRepository.findAll().stream()
                .map(internMapper::toDTO)
                .toList();
    }

    public Optional<InternEntity> getInternByInternId(String id) {
        return internRepository.findInternEntityByUserId(id);
    }

    public InternEntity save(InternEntity intern){
        return internRepository.save(intern);
    }

    public Optional<InternDto> getInternDtoByInternId(String id) {
        return internRepository.findInternEntityByUserId(id).map(internMapper::toDTO);
    }

    public Optional<InternEntity> updateInternByInternId(String id, InternDto request) {
        Optional<InternEntity> exist = getInternDtoByInternId(id).map(internMapper::toEntity);
        exist.ifPresent(intern -> {
        intern.setPhone(request.getPhone());
        intern.setDob(request.getDob());
        intern.setGender(request.isGender());
        intern.setAddress(request.getAddress());
        } );
        return exist;
    }


    public boolean checkExist(String id) {
        return internRepository.findInternEntityByUserId(id).isPresent();
    }

    public void deleteInternByInternId(String id) {
        Optional<InternEntity> intern = internRepository.findInternEntityByUserId(id);
        intern.ifPresent(internRepository::delete);
    }

    public String getIdFromAccount(String account) {
        String[] i = account.split("@");
        return i[0];
//        return i[0].toUpperCase();
    }

//    public Optional<InternDto> searchInternEntitiesByInput(@Param("input") String input){
//        return internRepository.searchInternEntitiesByInput(input).map(internMapper::toDTO);
//    }
}
