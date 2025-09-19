package com.payoyo.peopleops_backend.exception;

public class EmpleadoNoEncontradoException extends RuntimeException{

    public EmpleadoNoEncontradoException(Long id){
        super("Empleado no econtrado con id: " + id);
    }
    

}
