package com.ims.internship_management_system.model.mapper;


import com.ims.internship_management_system.model.AuditResultEntity;
import com.ims.internship_management_system.model.dto.AuditResultDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AuditResultMapper {
    AuditResultDto toDTO(AuditResultEntity auditResultEntity);
    AuditResultEntity toEntity(AuditResultDto auditResultDto);
}
