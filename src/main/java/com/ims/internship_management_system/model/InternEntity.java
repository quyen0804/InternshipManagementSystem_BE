package com.ims.internship_management_system.model;

import com.ims.internship_management_system.constant.Role;
import com.ims.internship_management_system.constant.Status;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@Table
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class InternEntity extends User {


    private String avatar;
    private Status status;
    private String mentor_id;

    public InternEntity(String user_id, String account,
                        String password, String fullName, String phone,
                        boolean gender,
                        LocalDate dob, String address, String cccd, Role role,
                        String avatar, Status status, String mentor_id) {
        super(user_id,account,password,fullName,phone,gender,dob,address,cccd,role);
        this.avatar = avatar;
        this.status = status;
        this.mentor_id = mentor_id;
    }


}
