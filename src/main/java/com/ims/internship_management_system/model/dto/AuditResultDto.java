package com.ims.internship_management_system.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuditResultDto {
//    private int auditInternId;
    private double aveResult;
    private boolean result;

    @CreationTimestamp
    private Timestamp createTime;

//    private int feedbackId;
}
