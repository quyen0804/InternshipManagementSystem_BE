package com.ims.internship_management_system.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class IssueReceiverDto {
//    private int receiverId;
//    private String issueId;
    private String receiver;
    private String reply;
}
