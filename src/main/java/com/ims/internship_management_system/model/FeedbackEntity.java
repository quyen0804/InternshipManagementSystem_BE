package com.ims.internship_management_system.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
public class FeedbackEntity {
    @Id
    private int feedbackId;

    private int internId;
    private int mentorId;

    private double value;
    private String description;

    @CreationTimestamp
    private Timestamp createdTime;


}
