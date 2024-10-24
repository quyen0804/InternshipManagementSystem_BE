package com.ims.internship_management_system.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class IssueReceiverEntity {
    @Id
    private int receiverId;
    private String issueId;
    private String reply;
}
