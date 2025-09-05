package com.payoyo.peopleops_backend.exception;

public class DepartamentoNoEncontradoException extends RuntimeException{

    public DepartamentoNoEncontradoException(Long id){
        super("Departamento no encontrado con id: " + id);
    }
    
}
