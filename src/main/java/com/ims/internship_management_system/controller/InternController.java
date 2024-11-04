package com.ims.internship_management_system.controller;

import com.ims.internship_management_system.model.InternEntity;
import com.ims.internship_management_system.model.dto.InternDto;
import com.ims.internship_management_system.model.mapper.InternMapper;
import com.ims.internship_management_system.request.InternCreationRequest;
import com.ims.internship_management_system.service.InternService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping(path="/intern")
public class InternController {
    private final InternService internService;
    private final InternMapper internMapper;

    @GetMapping(path = "/get-all")
    public ResponseEntity<?> findAll() {
        List<InternDto> interns = internService.getAllInterns();
        return ResponseEntity.ok().body(interns);
    }
    

    
    @GetMapping(path="/profile/{id}")
    Optional<InternDto> findInternById(@PathVariable String id) {
        return internService.getInternDtoByInternId(id);
    }

    @PutMapping(path = "/edit-profile/{id}")
    public ResponseEntity<?> updatePassenger(@PathVariable String id, @RequestBody InternDto request) {
        Optional<InternEntity> updated = internService.updateInternByInternId(id, request);
        return updated.map(intern -> new ResponseEntity<>(intern, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    
//    @GetMapping(path = "/search")
//    Optional<InternDto> findInternByInput(@RequestParam String input) {
//        return internService.searchInternEntitiesByInput(input);
//    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable String id) {
        if (internService.getInternDtoByInternId(id).isPresent()) {
            internService.deleteInternByInternId(id);
            return new ResponseEntity<>("Intern deleted!", HttpStatus.OK);
        }
        return new ResponseEntity<>("Intern not found", HttpStatus.NOT_FOUND);
    }


}

