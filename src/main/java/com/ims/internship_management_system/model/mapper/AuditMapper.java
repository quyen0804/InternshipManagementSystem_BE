package com.ims.internship_management_system.model.mapper;

import com.ims.internship_management_system.model.AuditEntity;
import com.ims.internship_management_system.model.dto.AuditDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AuditMapper {
    AuditDto toDTO(AuditEntity auditEntity);
    AuditEntity toEntity(AuditDto auditDto);
}
