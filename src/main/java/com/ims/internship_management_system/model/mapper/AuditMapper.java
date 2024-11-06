package com.ims.internship_management_system.model.mapper;

import com.ims.internship_management_system.model.AuditEntity;
import com.ims.internship_management_system.model.dto.AuditDto;
import com.ims.internship_management_system.request.AuditFormCreationRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AuditMapper {
    AuditDto toDTO(AuditEntity auditEntity);
    AuditEntity toEntity(AuditDto auditDto);
//
//    @Mapping(target = "")
//    AuditEntity formToEntity(AuditFormCreationRequest auditDto);
}
