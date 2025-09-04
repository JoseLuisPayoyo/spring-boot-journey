package com.payoyo.biblioteca.exception;

public class AutorNoEncontradoException extends RuntimeException{

    public AutorNoEncontradoException(Long id){
        super("Autor no encontrado con id: " + id);
    }
    
}
