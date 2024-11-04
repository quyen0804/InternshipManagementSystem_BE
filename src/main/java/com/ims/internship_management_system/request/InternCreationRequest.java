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
//    private String id;
    private String account;
//    private String password;
    private String fullName;
//    private String phone; //*
//    private boolean gender; //*
//    private LocalDate dob; //*
//    private String address; //*
    private String socialNum;
//    private String avatar;
    private String mentorAccount;
}
