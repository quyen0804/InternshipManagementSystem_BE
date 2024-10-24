package com.ims.internship_management_system.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskEntity {
    @Id
    private int taskId;

    private int reportId;
    private String taskContent;
    private boolean isCompleted;
    private Timestamp createdTime;
    private Timestamp completedTime;
}
