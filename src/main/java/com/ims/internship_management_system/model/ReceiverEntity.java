package com.ims.internship_management_system.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReceiverEntity {
    @Id
    private String receiverId;

    private int issueId;
    private String reply;
}
