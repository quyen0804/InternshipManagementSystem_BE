package com.ims.internship_management_system.service;

import com.ims.internship_management_system.constant.Role;
import com.ims.internship_management_system.exception.IMSRuntimeException;
import com.ims.internship_management_system.model.MentorEntity;
import com.ims.internship_management_system.model.dto.MentorDto;
import com.ims.internship_management_system.model.mapper.MentorMapper;
import com.ims.internship_management_system.repository.MentorRepository;
import com.ims.internship_management_system.util.generator.IdGenerator;
import lombok.RequiredArgsConstructor;
//import lombok.var;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MentorService {
    private final MentorRepository mentorRepository;
    private final MentorMapper mentorMapper;
    private final PasswordEncoder passwordEncoder;

    public Optional<MentorEntity> findById(String id) {
        return mentorRepository.findByUserId(id);
    }

    public List<MentorEntity> findAll() {
        return mentorRepository.findAll();
    }

    public Optional<MentorEntity> findByAccount(String account) {
        return mentorRepository.findByAccount(account);
    }

    public Optional<MentorDto> findMentorDtoById(String id) {
        return findById(id).map(mentorMapper::toDTO);
    }

    public List<MentorDto> findAllMentorDto() {
        return findAll().stream().map(mentorMapper::toDTO).toList();
    }

    public MentorDto updateMentorDto(String id, MentorDto mentorDto) {
        var m= findMentorDtoById(id).orElseThrow(() -> new NoSuchElementException("Mentor not found with id: " + id));
        m.setDob(mentorDto.getDob());
        m.setAddress(mentorDto.getAddress());
        m.setDob(mentorDto.getDob());
        m.setGender(mentorDto.isGender());
        return mentorMapper.toDTO(mentorRepository.save(mentorMapper.toEntity(m)));
    }

    public void deleteMentor(String id) {
        findById(id).ifPresent(mentorRepository::delete);
    }

    public MentorDto createMentor(MentorEntity mentor) {
//        MentorEntity mentorEntity = mentorMapper.toEntity(mentorDto);
        String id = IdGenerator.getIdFromAccount(mentor.getAccount());
        if(mentorRepository.findByAccount(mentor.getAccount()).isPresent()) {
            throw new IMSRuntimeException(HttpStatus.BAD_REQUEST, "This account already exists.");
        }
        mentor.setUserId(id);
        mentor.setPassword(passwordEncoder.encode(mentor.getPassword()));
        mentor.setRole(Role.MENTOR);
        return mentorMapper.toDTO(mentorRepository.save(mentor));
    }

    public List<MentorEntity> findAllMentorByBu(String bu) {
        return mentorRepository.findByBu(bu);
    }
}
