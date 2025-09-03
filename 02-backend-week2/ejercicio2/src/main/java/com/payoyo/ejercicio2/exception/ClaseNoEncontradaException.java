package com.payoyo.ejercicio2.exception;

public class ClaseNoEncontradaException extends RuntimeException{
    public ClaseNoEncontradaException(Long id){
        super("Clase no encontrada con id: " + id);
    }
}
