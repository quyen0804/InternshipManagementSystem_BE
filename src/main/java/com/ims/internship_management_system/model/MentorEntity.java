package com.ims.internship_management_system.model;

import com.ims.internship_management_system.constant.Role;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;

@Entity
@Data
@Table
@NoArgsConstructor
//@EqualsAndHashCode(callSuper = true)
@EntityListeners(AuditingEntityListener.class)
@PrimaryKeyJoinColumn(name = "user_id")
public class MentorEntity extends UserEntity {
    private String bu;

    public MentorEntity(String userId, String account,
                        String password, String fullName, String phone,
                        boolean gender,
                        LocalDate dob, String address, String socialNum, Role role, String bu) {
        super(userId,account,password,fullName,phone,gender,dob,address,socialNum,role);
        this.bu=bu;
    }

//    private List<InternEntity> interns;
}
