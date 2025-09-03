package com.payoyo.ejercicio2.error;

import java.time.Instant;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiError {

    private final int status;
    private final String error;
    private final String message;
    private final String path;
    private final Instant timestamp;


    private ApiError(int status, String error, String message, String path, Instant timestamp) {
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
        this.timestamp = timestamp;
    }

    public static ApiError of(HttpStatus status, String message, String path){
        return new ApiError(status.value(),
                            status.getReasonPhrase(), 
                            message, 
                            path,
                            Instant.now());
    }

    public int getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }

    public String getMessage() {
        return message;
    }

    public String getPath() {
        return path;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    

    

    
}
