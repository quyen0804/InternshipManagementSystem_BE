package com.ims.internship_management_system.request;

import com.ims.internship_management_system.model.dto.GradeDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AuditInternFormCreationRequest {
    private List<GradeDto> grades;
}
