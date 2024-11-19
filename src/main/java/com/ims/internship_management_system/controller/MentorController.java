package com.ims.internship_management_system.controller;


import com.ims.internship_management_system.model.MentorEntity;
import com.ims.internship_management_system.service.MentorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/mentor")
public class MentorController {
    private final MentorService mentorService;

    @GetMapping(path = "/{id}")
    public Optional<MentorEntity> getMentorById(@PathVariable String id) {
        return mentorService.findById(id);
    }
}
