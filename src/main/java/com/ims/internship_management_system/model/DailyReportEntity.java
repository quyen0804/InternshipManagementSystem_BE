package com.ims.internship_management_system.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DailyReportEntity {
    @Id
    @Column(unique = true, nullable = false)
    private int reportId;

//    @CreatedBy
    private String internId;

    private String mentorId;

//    private Date previousDay;
//    private String previousDayContent;

    @CreatedDate
    private Date today;

    private boolean isReviewed;

    private String todoList;

    @CreationTimestamp
    private Timestamp createdTime;

    @UpdateTimestamp
    private Timestamp updatedTime;

    private List<TaskEntity> tasks;
    private List<IssueEntity> issues;
}
