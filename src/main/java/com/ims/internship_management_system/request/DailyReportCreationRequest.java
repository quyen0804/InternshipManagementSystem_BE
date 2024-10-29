package com.ims.internship_management_system.request;

import com.ims.internship_management_system.model.IssueEntity;
import com.ims.internship_management_system.model.TaskEntity;
import lombok.Data;

import java.util.List;

@Data
public class DailyReportCreationRequest {
    private List<TaskEntity> tasks;
    private List<IssueEntity> issues;
}
