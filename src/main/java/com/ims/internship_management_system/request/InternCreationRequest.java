package com.ims.internship_management_system.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InternCreationRequest {
    private String account;
    private String fullName;
    private String socialNum;
    private String mentorAccount;
}
