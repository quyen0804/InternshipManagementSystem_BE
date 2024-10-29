package com.ims.internship_management_system.model.mapper;

import com.ims.internship_management_system.model.TaskEntity;
import com.ims.internship_management_system.model.dto.TaskDto;
import org.mapstruct.Mapper;
import org.springframework.scheduling.config.Task;

@Mapper(componentModel = "spring")
public interface TaskMapper {
    TaskDto toDto(TaskEntity task);
    TaskEntity toEntity(TaskDto dto);
}
