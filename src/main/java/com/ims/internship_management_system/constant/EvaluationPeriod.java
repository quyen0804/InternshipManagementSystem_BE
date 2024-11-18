package com.ims.internship_management_system.constant;

public enum EvaluationPeriod {
    WEEKLY, FORTNIGHT, MONTHLY;

    private int value;

    public static EvaluationPeriod fromValue(int value) {
        for (int i = 0; i < EvaluationPeriod.values().length; i++) {
            if (i == value) {
                return EvaluationPeriod.values()[i];
            }
        }
        throw new IllegalArgumentException("Invalid value: " + value);
    }
}
