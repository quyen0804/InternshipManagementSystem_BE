package com.ims.internship_management_system.model.mapper;

import com.ims.internship_management_system.model.AuditInternEntity;
import com.ims.internship_management_system.model.GradeEntity;
import com.ims.internship_management_system.model.dto.AuditInternDto;
import com.ims.internship_management_system.model.dto.InternDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AuditInternMapper {
    AuditInternDto toDTO(AuditInternEntity auditInternEntity, List<GradeEntity> grades);
    AuditInternEntity toAuditInternDto(AuditInternDto auditInternDto);
}
