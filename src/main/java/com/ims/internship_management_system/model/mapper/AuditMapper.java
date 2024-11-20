package com.ims.internship_management_system.model.mapper;

import com.ims.internship_management_system.model.AuditEntity;
import com.ims.internship_management_system.model.dto.AuditDto;
import com.ims.internship_management_system.model.dto.AuditInternDto;
import com.ims.internship_management_system.model.dto.InternDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AuditMapper {
    AuditDto toDTO(AuditEntity auditEntity, List<InternDto> interns,
                   List<AuditInternDto> auditInterns);
    AuditEntity toEntity(AuditDto auditDto);
//
//    @Mapping(target = "")
//    AuditEntity formToEntity(AuditFormCreationRequest auditDto);
}
