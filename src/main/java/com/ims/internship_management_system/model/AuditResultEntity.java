package com.ims.internship_management_system.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
public class AuditResultEntity {
    @Id
    @Column
    private int resultId;

    private int auditInternId;
    private double aveResult;
    private boolean result;

    @CreationTimestamp
    private Timestamp createTime;

    private int feedbackId;
}
