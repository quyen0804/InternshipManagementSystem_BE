package com.ims.internship_management_system.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class IssueDto {
//    private int reportId;
    private String issueContent;
    private List<IssueReceiverDto> receivers;
}
