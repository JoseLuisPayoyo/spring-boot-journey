package com.payoyo.gestion_ferreteria.exception;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // Producto no encontrado
    @ExceptionHandler(ProductoNoEncontradoException.class)
    public ResponseEntity<ApiError> handleProductoNoEncontrado(ProductoNoEncontradoException ex) {
        ApiError error = new ApiError(
                HttpStatus.NOT_FOUND.value(),
                "Producto no encontrado",
                ex.getMessage()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    // Validaciones fallidas con @Valid
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> handleValidationErrors(MethodArgumentNotValidException ex) {
        List<String> errores = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(err -> err.getField() + ": " + err.getDefaultMessage())
                .collect(Collectors.toList());

        ApiError error = new ApiError(
                HttpStatus.BAD_REQUEST.value(),
                "Error de validación",
                "Hay campos inválidos en la solicitud",
                errores
        );
        return ResponseEntity.badRequest().body(error);
    }

    // Error genérico, esto es opcional
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> handleException(Exception ex) {
        ApiError error = new ApiError(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "Error interno",
                ex.getMessage()
        );
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }
}
