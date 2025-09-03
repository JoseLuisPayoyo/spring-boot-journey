package com.payoyo.ejercicio2.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.payoyo.ejercicio2.exception.ClaseNoEncontradaException;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // 404 - Recurso no encontrado
    @ExceptionHandler(ClaseNoEncontradaException.class)
    public ResponseEntity<ApiError> handleNombre(
        ClaseNoEncontradaException ex, 
        HttpServletRequest request)
    {
        ApiError error = ApiError.of(
            HttpStatus.NOT_FOUND,
            ex.getMessage(),
            request.getRequestURI());

        return ResponseEntity
            .status(HttpStatus.NOT_FOUND)
            .body(error);    
    }

    // 400 - Error de Validacion (@Valid falló)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> handleValidacionFallida(
        MethodArgumentNotValidException ex, 
        HttpServletRequest request)
    {
        String mensaje = "Error de validacion en los campos del formulario";
        ApiError error = ApiError.of(
            HttpStatus.BAD_REQUEST,
            mensaje,
            request.getRequestURI());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);    
    }

    // 400 - JSON mal formado
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ApiError> handleJsonMalFormado(
        HttpMessageNotReadableException ex,
        HttpServletRequest request)
    {
        String mensaje = "JSON mal formado o tipos de datos incorrectos";
        ApiError error = ApiError.of(
            HttpStatus.INTERNAL_SERVER_ERROR,
            mensaje, 
            request.getRequestURI());

        return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(error);
    }

    // 500 - Cualquier otro error no controlado
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> handleExceptionGenerica(
        Exception ex, 
        HttpServletRequest request)
    {
        String mensaje = "Ha ocurrido un error inesperado en el servidor";
        ApiError error = ApiError.of(
            HttpStatus.INTERNAL_SERVER_ERROR,
            mensaje,
            request.getRequestURI());

        return ResponseEntity
            .status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body(error);
    }

    
}
