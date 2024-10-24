package com.ims.internship_management_system.model.mapper;

import com.ims.internship_management_system.model.DailyReportEntity;
import com.ims.internship_management_system.model.dto.DailyReportDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DailyReportMapper {
    DailyReportDto toDTO(DailyReportEntity dailyReport);
    DailyReportEntity toEntity(DailyReportDto dailyReportDto);
}
