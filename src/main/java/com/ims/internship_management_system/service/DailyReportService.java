package com.ims.internship_management_system.service;

import com.ims.internship_management_system.model.DailyReportEntity;
import com.ims.internship_management_system.model.dto.DailyReportDto;
import com.ims.internship_management_system.model.mapper.DailyReportMapper;
import com.ims.internship_management_system.repository.DailyReportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class DailyReportService {

    @Autowired
    private final DailyReportRepository dailyReportRepository;

    @Autowired
    private final DailyReportMapper dailyReportMapper;

    public List<DailyReportDto> findAllByInternId(String id) {
        try {
            var drs= dailyReportRepository.findDailyReportEntitiesByInternId(id);
//            return dailyReportMapper.toDTO(dr);
            return drs.stream().map(dailyReportMapper::toDTO).toList();
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
