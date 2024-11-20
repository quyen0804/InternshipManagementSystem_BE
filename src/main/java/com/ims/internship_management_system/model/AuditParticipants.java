package com.ims.internship_management_system.model;

import com.ims.internship_management_system.constant.Role;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuditParticipants {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; // Ensure this is the primary key

    private String auditId;
    private String userId;
    private Role role;

    public AuditParticipants(String auditId, String userId, Role role) {
        this.auditId = auditId;
        this.userId = userId;
        this.role = role;
    }
}
