package com.ims.internship_management_system.model.mapper;

import com.ims.internship_management_system.model.MentorEntity;
import com.ims.internship_management_system.model.dto.MentorDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MentorMapper {
    MentorDto toDTO(MentorEntity entity);
    MentorEntity toEntity(MentorDto dto);
}
