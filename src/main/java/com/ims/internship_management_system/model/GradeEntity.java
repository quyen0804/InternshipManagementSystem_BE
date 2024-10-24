package com.ims.internship_management_system.model;

import com.ims.internship_management_system.constant.GradeColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
public class GradeEntity {
    @Id
    private int gradeId;
    private int auditInternId;
    private GradeColumn name;
    private double value;
    private String description;
}
