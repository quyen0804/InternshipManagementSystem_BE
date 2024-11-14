package com.ims.internship_management_system.service;

import com.ims.internship_management_system.constant.InternStatus;
import com.ims.internship_management_system.constant.Role;
import com.ims.internship_management_system.model.InternEntity;
import com.ims.internship_management_system.model.MentorEntity;
import com.ims.internship_management_system.model.dto.InternDto;
import com.ims.internship_management_system.model.mapper.InternMapper;
import com.ims.internship_management_system.repository.InternRepository;
import com.ims.internship_management_system.request.InternCreationRequest;
import com.ims.internship_management_system.service.security.AuthService;
import com.ims.internship_management_system.util.generator.IdGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
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
    private final MentorService mentorService;
    private final PasswordEncoder passwordEncoder;

    public InternEntity addIntern(InternCreationRequest request) {
        InternEntity intern = new InternEntity();


        intern.setUserId(IdGenerator.getIdFromAccount(request.getAccount()));
        intern.setAccount(request.getAccount());
        intern.setFullName(request.getFullName());
//        intern.setPassword(authService.passwordHash(authService.generatePassword(8)));
        String pass  = authService.generatePassword(8);
        intern.setPassword(passwordEncoder.encode(pass));
        intern.setFirstPass(pass);
        intern.setRole(Role.INTERN);
        intern.setStatus(InternStatus.ACTIVE);
        intern.setSocialNum(request.getSocialNum());
        intern.setMentorId(IdGenerator.getIdFromAccount(request.getMentorAccount()));

        return internRepository.save(intern);
    }

    public List<InternDto> getAllInterns() {
        return internRepository.findAll().stream()
                .map(internMapper::toDTO)
                .toList();
    }

    public List<InternEntity> getAllInternEntities() {
        return internRepository.findAll();
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



    public List<InternEntity> findAllActiveInterns() {
        List<InternEntity> all = getAllInternEntities();
        List<InternEntity> intern = null;
        for (InternEntity internEntity : all) {
            if (internEntity.getStatus().equals(InternStatus.ACTIVE)) {
                intern.add(internEntity);
            }
        }
        return intern;
    }

    public Optional<InternEntity> changeAccountStatus(String id, InternStatus status) {
        Optional<InternEntity> intern = internRepository.findInternEntityByUserId(id);

        intern.ifPresent(internEntity -> {
            internEntity.setStatus(status);
            internRepository.save(internEntity);
        });

        return intern;
    }


    public List<InternEntity> findAllNotActiveInterns() {
        List<InternEntity> all = getAllInternEntities();
        List<InternEntity> intern = null;
        for (InternEntity internEntity : all) {
            if (internEntity.getStatus().equals(InternStatus.INACTIVE)) {
                intern.add(internEntity);
            }
        }
        return intern;
    }

    public InternEntity findAllInternByMentorId(String mentorId) {
        return internRepository.findInternEntityByMentorId(mentorId).orElse(null);
    }

    public List<InternEntity> findAllInternByMentorBu(String bu){
        List<MentorEntity> mentors = mentorService.findAllMentorByBu(bu);
        List<InternEntity> intern = null;
        for(MentorEntity mentor: mentors){
            intern.add(findAllInternByMentorId(mentor.getUserId()));
        }
        return null;
    }

//    public Optional<InternDto> searchInternEntitiesByInput(@Param("input") String input){
//        return internRepository.searchInternEntitiesByInput(input).map(internMapper::toDTO);
//    }
}
