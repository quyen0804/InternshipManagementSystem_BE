package com.ims.internship_management_system.model.dto;


import com.ims.internship_management_system.model.TaskEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DailyReportDto {
    private String internName;
//    private Date previousDay;
//    private String previousDayContent;

    @CreatedDate
    private Date today;

//    private String todayContent;
//    private String problems;
    private boolean isChecked;

    @CreationTimestamp
    private Timestamp createdTime;

    @UpdateTimestamp
    private Timestamp updatedTime;

    private List<TaskDto> tasks;

}
