package com.ims.internship_management_system.model;

import com.ims.internship_management_system.constant.InternStatus;
import com.ims.internship_management_system.constant.Role;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table
@NoArgsConstructor
//@EqualsAndHashCode(callSuper = true)
@EntityListeners(AuditingEntityListener.class)
@PrimaryKeyJoinColumn(name = "user_id")
public class InternEntity extends UserEntity {
//    @Id
//    private String id;

    private String avatar;
    private InternStatus status;
    private String mentorId;

    @CreatedDate
    @Column(updatable = false)
    private LocalDate joinDate;

    public InternEntity(String user_id, String account, String password,
                        String fullName, String phone, boolean gender,
                        LocalDate dob, String address, String socialNum, Role role,
                        String avatar, InternStatus status, String mentorId, LocalDate joinDate) {
        super(user_id,account,password,fullName,phone,gender,dob,address,socialNum,role);
        this.avatar = avatar;
        this.status = status;
        this.mentorId = mentorId;
        this.joinDate = joinDate;
    }


}
