package com.ims.internship_management_system.service;

import com.ims.internship_management_system.constant.InternStatus;
import com.ims.internship_management_system.constant.Role;
import com.ims.internship_management_system.exception.IMSRuntimeException;
import com.ims.internship_management_system.model.InternEntity;
import com.ims.internship_management_system.model.MentorEntity;
import com.ims.internship_management_system.model.dto.InternDto;
import com.ims.internship_management_system.model.mapper.InternMapper;
import com.ims.internship_management_system.repository.InternRepository;
import com.ims.internship_management_system.request.InternCreationRequest;
import com.ims.internship_management_system.service.security.AuthService;
import com.ims.internship_management_system.util.generator.IdGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InternService {
    private final InternRepository internRepository;
    private final InternMapper internMapper;
    private final AuthService authService;
    private final MentorService mentorService;
    private final PasswordEncoder passwordEncoder;

    public InternEntity addIntern(InternCreationRequest request) {
        InternEntity intern = new InternEntity();
        String id = IdGenerator.getIdFromAccount(request.getAccount());
        if(internRepository.findInternEntityByUserId(id).isPresent()){
            throw new IMSRuntimeException(HttpStatus.I_AM_A_TEAPOT,"This account existed.");
        }
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

    public List<InternEntity> findAllByStatus(InternStatus status) {
        return internRepository.findAllByStatus(status);
    }

    public List<InternEntity> findAllByStatusAndMentorId(InternStatus status, String mentor){
        return internRepository.findAllByStatusAndMentorId(status, mentor);
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

    public InternEntity updateInternByInternId(String id, InternDto request) {
        InternEntity intern =
                getInternByInternId(id).orElseThrow(() -> new IMSRuntimeException(HttpStatus.NOT_FOUND
                        , "user not found"));
        intern.setPhone(request.getPhone());
        intern.setDob(request.getDob());
        intern.setGender(request.isGender());
        intern.setAddress(request.getAddress());
        internRepository.save(intern);

        return intern;
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
        List<InternEntity> intern = new ArrayList<>();
        for (InternEntity internEntity : all) {
            if (internEntity.getStatus().equals(InternStatus.ACTIVE)) {
                intern.add(internEntity);
            }
        }
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

    public List<InternEntity> findAllInternByMentorId(String mentorId) {
        return internRepository.findInternEntityByMentorId(mentorId);
    }

    public List<InternEntity> findAllInternByMentorBu(String bu){
        List<MentorEntity> mentors = mentorService.findAllMentorByBu(bu);
        List<InternEntity> intern = null;
        for(MentorEntity mentor: mentors){
            List<InternEntity> internList = findAllInternByMentorId(mentor.getUserId());
            for(InternEntity interns: internList){
                intern.add(interns);
            }
        }
        return null;
    }

//    public InternEntity changeAccountStatus(String id, int status){
//        InternEntity intern =
//                internRepository.findInternEntityByUserId(id)
//                        .orElseThrow(() -> new IMSRuntimeException(HttpStatus.NOT_FOUND, "Intern not found"));
//        intern.setStatus(InternStatus.fromValue(status));
//        internRepository.save(intern);
//        return intern;
//    }

//    public InternEntity changeAccountStatus(String id, InternStatus status){
//        InternEntity intern =
//                internRepository.findInternEntityByUserId(id)
//                        .orElseThrow(() -> new IMSRuntimeException(HttpStatus.NOT_FOUND, "Intern not found"));
//        intern.setStatus(status);
//        internRepository.save(intern);
//        return intern;
//    }

    public InternEntity changeAccountStatus(String id, InternDto request){
        InternEntity intern =
                internRepository.findInternEntityByUserId(id)
                        .orElseThrow(() -> new IMSRuntimeException(HttpStatus.NOT_FOUND, "Intern not found"));
        intern.setStatus(request.getStatus());
        internRepository.save(intern);
        return intern;
    }


//    public List<InternEntity> findInternByNameAndAccount(String nameInput, String accountInput,
//                                                         String phoneInput, String socialInput){
//        String name = (nameInput != null) ? "%" + nameInput + "%" : "%";
//        String account = (accountInput != null) ? "%" + accountInput + "%" : "%";
//        String phone = (phoneInput != null) ? "%" + phoneInput + "%" : "%";
//        String social = (socialInput != null) ? "%" + socialInput + "%" : "%";
//        return internRepository.findInternEntitiesByFullNameOrAccountOrPhoneOrSocialNumLikeIgnoreCase(name,
//                account, phone, social);
//    }

    public List<InternEntity> findInternByDynamicQuery(String nameInput, String accountInput,
                                                       String phoneInput, String socialInput) {
        String name = (nameInput != null) ? "%" + nameInput + "%" : null;
        String account = (accountInput != null) ? "%" + accountInput + "%" : null;
        String phone = (phoneInput != null) ? "%" + phoneInput + "%" : null;
        String social = (socialInput != null) ? "%" + socialInput + "%" : null;

        return internRepository.findInternByDynamicQuery(name, account, phone, social);
    }

    public List<InternEntity> searchInternByKeyword(String keywordInput) {
        String keyword = (keywordInput != null) ? keywordInput.trim() : "";
        return internRepository.searchByKeyword(keyword);
    }

}
