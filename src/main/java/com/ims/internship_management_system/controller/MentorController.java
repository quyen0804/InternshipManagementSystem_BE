package com.ims.internship_management_system.controller;


import com.ims.internship_management_system.model.MentorEntity;
import com.ims.internship_management_system.service.MentorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/mentor")
public class MentorController {
    private final MentorService mentorService;

    @GetMapping
    public Optional<MentorEntity> getMentorById(@RequestParam String id) {
        return mentorService.findById(id);
    }
}
