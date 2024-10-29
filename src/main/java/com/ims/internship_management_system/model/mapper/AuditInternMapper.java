package com.ims.internship_management_system.model.mapper;

import com.ims.internship_management_system.model.AuditInternEntity;
import com.ims.internship_management_system.model.dto.AuditInternDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AuditInternMapper {
    AuditInternDto toDTO(AuditInternEntity auditInternEntity);
    AuditInternEntity toAuditInternDto(AuditInternDto auditInternDto);
}
