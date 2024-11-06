package com.ims.internship_management_system.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuditResultDto {
    private String internId;
    private String mentorId;
    private double aveResult;
    private boolean result;

    @CreationTimestamp
    private Timestamp createTime;

    private List<AuditInternDto> interns;

//    private int feedbackId;
}
