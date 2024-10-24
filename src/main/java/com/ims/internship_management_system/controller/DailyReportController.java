package com.ims.internship_management_system.controller;


import com.ims.internship_management_system.model.dto.DailyReportDto;
import com.ims.internship_management_system.service.DailyReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/intern/daily-report")
public class DailyReportController {
    private final DailyReportService dailyReportService;

    @GetMapping(path = "/get")
    public ResponseEntity<?> findDailyReportByInternId(@RequestParam int id) {
        List<DailyReportDto> list = dailyReportService.findAllByInternId(id);
        return ResponseEntity.ok().body(list);
    }
}
