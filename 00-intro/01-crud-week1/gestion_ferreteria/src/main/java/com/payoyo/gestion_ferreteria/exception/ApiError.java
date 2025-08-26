package com.payoyo.gestion_ferreteria.exception;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiError {

    private int status;
    private String error;
    private String message;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime timestamp;

    private List<String> errors;

    public ApiError(int status, String error, String message) {
        this.status = status;
        this.error = error;
        this.message = message;
        this.timestamp = LocalDateTime.now();
    }

    public ApiError(int status, String error, String message, List<String> errors) {
        this.status = status;
        this.error = error;
        this.message = message;
        this.errors = errors;
        this.timestamp = LocalDateTime.now();
    }



    
    
}
