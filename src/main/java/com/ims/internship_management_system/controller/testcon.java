package com.ims.internship_management_system.controller;

import com.ims.internship_management_system.service.tester;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
//@RequiredArgsConstructor
@RequestMapping(path = "/test")
public class testcon {
    @Autowired
    private final tester tester;

    public testcon(tester tester) {
        this.tester = tester;
    }

    @PostMapping(path = "/t")
    public ResponseEntity<Map<String, Map<Integer, Integer>>> t(@RequestBody Map<String, Map<Integer, Integer>> e) {
        return ResponseEntity.ok(tester.print(e));
    }
}
