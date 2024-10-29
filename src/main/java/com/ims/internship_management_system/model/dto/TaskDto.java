package com.ims.internship_management_system.model.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TaskDto {
//    private int taskId;
//    private int reportId;
    private String taskContent;
//    private boolean isCompleted;
    private Timestamp createdTime;
    private Timestamp completedTime;
}
