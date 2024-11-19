package com.ims.internship_management_system.constant;

public enum InternStatus {
    ACTIVE,
    INACTIVE,
//    CANCELLING,
    WARNING,
    DISQUALIFIED;

    private int value;

    public static InternStatus fromValue(int value) {
        for (int i = 0; i < InternStatus.values().length; i++) {
            if (i == value) {
                return InternStatus.values()[i];
            }
        }
        throw new IllegalArgumentException("Invalid value: " + value);
    }
}
