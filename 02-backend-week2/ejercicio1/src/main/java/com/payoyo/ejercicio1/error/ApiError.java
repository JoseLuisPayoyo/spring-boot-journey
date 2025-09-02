package com.payoyo.ejercicio1.error;

import java.time.Instant;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL) // Oculta campos null en la respuesta JSON
public class ApiError {

    private final int status; //404, 400, 500
    private final String error; //"Not Found", "Bad Request"
    private final String message; //Detalle legible
    private final String path; //URI solicitada
    private final Instant timestamp; //ISO-8601 en UTC

    private ApiError(int status,
                    String error,
                    String message,
                    String path,
                    Instant timestamp){

        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
        this.timestamp = timestamp;
    }

    /*Factoty para crear el error fácilmente*/
    public static ApiError of(HttpStatus status, String message, String path){
        return new ApiError(
            status.value(),
            status.getReasonPhrase(),
            message,
            path,
            Instant.now()
        );
    }

    //Getters (Necesario para que Jackson lo conveirta en JSON)
    public int getStatus() {return status;}

    public String getError() {return error;}

    public String getMessage() {return message;}

    public String getPath() {return path;}

    public Instant getTimestamp() {return timestamp;}

}
