package com.ims.internship_management_system.model.dto;

import com.ims.internship_management_system.model.GradeEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuditInternDto {
    private String auditInternId;
    private String internId;
    private String mentorId;

    @CreationTimestamp
    private Timestamp createdTime;

    @UpdateTimestamp
    private Timestamp updatedTime;

//    private int gradeId;
    private double aveGrade;


    private List<GradeEntity> grades;
}
