package com.ims.internship_management_system.model;

import com.ims.internship_management_system.constant.Role;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Table
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class MentorEntity extends User{
    private String bu;

    public MentorEntity(String userId, String account,
                        String password, String fullName, String phone,
                        boolean gender,
                        LocalDate dob, String address, String cccd, Role role, String bu) {
        super(userId,account,password,fullName,phone,gender,dob,address,cccd,role);
        this.bu=bu;
    }

//    private List<InternEntity> interns;
}
