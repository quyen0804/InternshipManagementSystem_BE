package com.ims.internship_management_system.model;

import com.ims.internship_management_system.constant.GradeColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GradeEntity {
    @Id
    @GeneratedValue
    private int gradeId;

    private String auditInternId;
    private GradeColumn name;
    private double value;
    private String description;

    public GradeEntity(String auditInternId, GradeColumn name, double value, String description) {
        this.auditInternId = auditInternId;
        this.name = name;
        this.value = value;
        this.description = description;

    }
}
