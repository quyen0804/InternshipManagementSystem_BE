package com.ims.internship_management_system.model.dto;


import com.ims.internship_management_system.constant.EvaluationPeriod;
import com.ims.internship_management_system.model.InternEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuditDto {
//    private int auditId;
    @CreatedDate
    private Date date;

    private EvaluationPeriod evaluationPeriod;
//    private int resultId;
    private List<InternEntity> interns;
}
