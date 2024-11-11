package com.ims.internship_management_system.constant;

public enum Auth {
    JWT_COOKIE("jwtToken");
    private final String value;



    Auth(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }

}
