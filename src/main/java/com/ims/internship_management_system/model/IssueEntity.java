package com.ims.internship_management_system.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class IssueEntity {
    @Id
    private int issueId;
    private int reportId;
    private String issueContent;

    private List<ReceiverEntity> receivers;
}
