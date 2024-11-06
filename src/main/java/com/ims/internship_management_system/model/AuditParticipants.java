package com.ims.internship_management_system.model;

import com.ims.internship_management_system.constant.Role;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuditParticipants {
    @Id
    private String auditInternId;
    private String userId;
    private Role role;

}
