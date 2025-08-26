package com.jose.crus_dia2.exception;

public class RecursoNoEncontradoException extends RuntimeException{

    //constructor que recibe el mensaje de error
    public RecursoNoEncontradoException(String mensaje){
        super(mensaje); //llama al constructor de runtime con el mensaje
    }
}
