package com.ims.internship_management_system.exception;

import org.springframework.http.HttpStatus;

public interface CommonErrorCode {
    HttpStatus status();

    String message();
}