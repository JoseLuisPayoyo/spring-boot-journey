package com.jose.pedidos.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler
    public ResponseEntity<Map<String, Object>> manejarRecursosNoEncontrado(RecursoNoEncontradoException ex){
        Map<String, Object> error = new HashMap<>();
        error.put("timestamp", LocalDateTime.now());
        error.put("mensaje", ex.getMessage());
        error.put("estado", HttpStatus.NOT_FOUND.value());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    //Capturar errores de validacion (campos vacios o incorrectos)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> manejarErroresDeValidacion(MethodArgumentNotValidException ex) {

        // 1. Creamos un mapa para guardar los errores de cada campo
        Map<String, String> errores = new HashMap<>();

        // 2. Recorremos todos los errores de validación
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            String campo = error.getField();
            String mensaje = error.getDefaultMessage();
            errores.put(campo, mensaje);
        });

        // 3. Construimos la respuesta final como un JSON estructurado
        Map<String, Object> errorResponse = new HashMap<>();
        errorResponse.put("timestamp", LocalDateTime.now());
        errorResponse.put("estado", HttpStatus.BAD_REQUEST.value());
        errorResponse.put("errores", errores);

        // 4. Devolvemos el error con código 400
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

}
