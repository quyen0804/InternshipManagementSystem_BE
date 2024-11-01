package com.ims.internship_management_system.model;

import com.ims.internship_management_system.constant.EvaluationPeriod;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuditEntity {

    @Id
    private int auditId;

    @CreatedDate
    private Date date;

    private EvaluationPeriod evaluationPeriod;
    private int resultId;
}
