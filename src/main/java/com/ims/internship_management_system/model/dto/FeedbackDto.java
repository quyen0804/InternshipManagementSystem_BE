package com.ims.internship_management_system.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FeedbackDto {
//    private int internId;
//    private int mentorId;

    private double value;
    private String description;

    @CreationTimestamp
    private Timestamp createdTime;
}
