package com.ims.internship_management_system.model;

import com.ims.internship_management_system.constant.InternStatus;
import com.ims.internship_management_system.constant.Role;
import com.ims.internship_management_system.constant.InternStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@Table
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class InternEntity extends User {


    private String avatar;
    private InternStatus status;
    private String mentorId;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime joinDate;

    public InternEntity(String user_id, String account, String password,
                        String fullName, String phone, boolean gender,
                        LocalDate dob, String address, String cccd, Role role,
                        String avatar, InternStatus status, String mentorId, LocalDateTime joinDate) {
        super(user_id,account,password,fullName,phone,gender,dob,address,cccd,role);
        this.avatar = avatar;
        this.status = status;
        this.mentorId = mentorId;
        this.joinDate = joinDate;
    }


}
