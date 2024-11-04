package com.ims.internship_management_system.constant;


public enum LetterAndNumber {
    LOWERCASE_LETTER("abcdefghijklmnopqrstuvwxyz"),
    UPPERCASE_LETTER("ABCDEFGHIJKLMNOPQRSTUVWXYZ"),
    NUMBER("0123456789"),
    SPECIAL_CHAR("!@#$%^&*()-_+");

    private final String value;

    // Constructor to initialize each constant with a value
    LetterAndNumber(String value) {
        this.value = value;
    }

    // Getter method to retrieve the value associated with the constant
    public String getValue() {
        return value;
    }




}

