package com.ims.internship_management_system.controller;

import com.ims.internship_management_system.service.tester;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/test")
public class testcon {
    private final tester t;

    @PostMapping(path="/t")
    public ResponseEntity<tester> t(@RequestBody tester t) {
        return ResponseEntity.ok(t);
    }
}
