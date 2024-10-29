package com.ims.internship_management_system.model.mapper;

import com.ims.internship_management_system.model.GradeEntity;
import com.ims.internship_management_system.model.dto.GradeDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GradeMapper {
    GradeDto toDTO(GradeEntity gradeEntity);
    GradeEntity toEntity(GradeDto dto);
}
