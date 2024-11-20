package com.ims.internship_management_system.controller;

import com.ims.internship_management_system.constant.InternStatus;
import com.ims.internship_management_system.model.InternEntity;
import com.ims.internship_management_system.model.dto.InternDto;
import com.ims.internship_management_system.model.mapper.InternMapper;
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

    @GetMapping(path="/entity-profile/{id}")
    Optional<InternEntity> findInternByEntityProfile(@PathVariable String id) {
        return internService.getInternByInternId(id);
    }


    @PutMapping(path = "/edit-profile/{id}")
    public ResponseEntity<?> updatePassenger(@PathVariable String id, @RequestBody InternDto request) {
        InternEntity updated = internService.updateInternByInternId(id, request);
//        Optional<InternEntity> updated = internService.updateInternByInternId(id, request);
        return ResponseEntity.ok(updated);
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

    //get list intern theo id mentor
    @GetMapping(path="/get-by-mentor/{mentorId}")
    public ResponseEntity<?> getInternByMentorId(@PathVariable String mentorId) {
        List<InternDto> interns =
                internService.findAllInternByMentorId(mentorId)
                        .stream().map(internMapper::toDTO).toList();
        return ResponseEntity.ok().body(interns);
    }


//    @PutMapping(path="/{id}/change-intern-account-status")
//    public ResponseEntity<InternDto> changeInternAccountStatus(@PathVariable String id,
//                                                               @RequestBody InternStatus status){
//        InternEntity intern = internService.changeAccountStatus(id, status);
//        return ResponseEntity.ok().body(internMapper.toDTO(intern));
//    }

    @PutMapping(path="/{id}/change-intern-account-status")
    public ResponseEntity<InternDto> changeInternAccountStatus(@PathVariable String id,
                                                               @RequestBody InternDto request){
        InternEntity intern = internService.changeAccountStatus(id, request);
        return ResponseEntity.ok().body(internMapper.toDTO(intern));
    }

    @GetMapping(path = "/status/get-active")
    public ResponseEntity<?> getInternActive() {
        List<InternDto> interns =
                internService.findAllByStatus(InternStatus.ACTIVE).stream().map(internMapper::toDTO).toList();
        return ResponseEntity.ok().body(interns);
    }

    @GetMapping(path = "/status/get-inactive")
    public ResponseEntity<?> getInternInactive() {
        List<InternDto> interns =
                internService.findAllByStatus(InternStatus.INACTIVE).stream().map(internMapper::toDTO).toList();
        return ResponseEntity.ok().body(interns);
    }

    @GetMapping(path = "/status/get-warning")
    public ResponseEntity<?> getInternWarning() {
        List<InternDto> interns =
                internService.findAllByStatus(InternStatus.WARNING).stream().map(internMapper::toDTO).toList();
        return ResponseEntity.ok().body(interns);
    }

    @GetMapping(path = "/status/get-disqualify")
    public ResponseEntity<?> getInternDisqualify() {
        List<InternDto> interns =
                internService.findAllByStatus(InternStatus.DISQUALIFIED).stream().map(internMapper::toDTO).toList();
        return ResponseEntity.ok().body(interns);
    }

    @GetMapping(path="/search")
    public ResponseEntity<?> searchByNameAndAccount(@RequestParam(required = false) String name,
                                                    @RequestParam(required = false) String account,
                                                    @RequestParam(required = false) String phone,
                                                    @RequestParam(required = false) String social){
        List<InternDto> interns =
                internService.findInternByDynamicQuery(name, account, phone, social).stream().map(internMapper::toDTO).toList();
        return ResponseEntity.ok().body(interns);
    }

    @GetMapping(path = "/search-keyword")
    public ResponseEntity<?> searchWithKeyword(@RequestParam String keyword) {
        List<InternDto> interns = internService
                .searchInternByKeyword(keyword)
                .stream()
                .map(internMapper::toDTO)
                .toList();
        return ResponseEntity.ok().body(interns);
    }

}

