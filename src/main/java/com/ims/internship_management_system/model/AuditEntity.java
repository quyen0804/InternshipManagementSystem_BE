package com.ims.internship_management_system.model;

import com.ims.internship_management_system.constant.EvaluationPeriod;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class AuditEntity {

    @Id
    private String auditId;

    private String mentorId;

    @CreatedDate
    private LocalDateTime date;

    private EvaluationPeriod evaluationPeriod;

//    private String resultId;
}
