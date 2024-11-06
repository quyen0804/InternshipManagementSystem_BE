package com.ims.internship_management_system.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuditInternEntity {
    @Id
    private String auditInternId;

    private String internId;

    @CreationTimestamp
    private Timestamp createdTime;

    @UpdateTimestamp
    private Timestamp updatedTime;

    private String auditID;
    private String resultId;

//    private int gradeId;
    private double aveGrade;

//    public AuditInternEntity()
}
