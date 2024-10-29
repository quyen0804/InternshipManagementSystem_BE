package com.ims.internship_management_system.constant;

public enum EvaluationPeriod {
    WEEKLY, FORTNIGHT, MONTHLY;

    private int value;

    public static EvaluationPeriod fromValue(int value) {
        for (EvaluationPeriod period : values()) {
            if (period.value == value) {
                return period;
            }
        }
        throw new IllegalArgumentException("Invalid value: " + value);
    }
}
