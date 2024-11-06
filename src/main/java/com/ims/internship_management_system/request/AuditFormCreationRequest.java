package com.ims.internship_management_system.request;

import com.ims.internship_management_system.constant.EvaluationPeriod;
import com.ims.internship_management_system.model.InternEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AuditFormCreationRequest {
    private String mentorId;
    private int evaluationPeriod;
    private List<InternEntity> interns;


}
