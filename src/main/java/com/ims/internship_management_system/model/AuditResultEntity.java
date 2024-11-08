package com.ims.internship_management_system.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuditResultEntity {
    @Id
    private String resultId;

    private String internId;
    private String mentorId;
//    private int auditInternId;
    private double aveResult;
    private boolean isQualify;

    @CreationTimestamp
    private Timestamp createTime;

    private int feedbackId;
}
