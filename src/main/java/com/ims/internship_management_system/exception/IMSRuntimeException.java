package com.ims.internship_management_system.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Setter
@Getter
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class IMSRuntimeException extends RuntimeException {
    private String message;
    private HttpStatus status;

    public IMSRuntimeException(final CommonErrorCode code) {
        this.message = code.message();
        this.status = code.status();
    }

    public IMSRuntimeException(HttpStatus status, String message) {
        this.message = message;
        this.status = status;
    }

}