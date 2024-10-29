package com.ims.internship_management_system.model.mapper;

import com.ims.internship_management_system.model.InternEntity;
import com.ims.internship_management_system.model.dto.InternDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface InternMapper {
    InternDto toDTO(InternEntity internEntity);
    InternEntity toEntity(InternDto internDto);
}
