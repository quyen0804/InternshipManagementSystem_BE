package com.ims.internship_management_system.model.dto;

import com.ims.internship_management_system.constant.GradeColumn;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GradeDto {
//    private int auditInternId;
    private GradeColumn name;
    private double value;
    private String description;
}
