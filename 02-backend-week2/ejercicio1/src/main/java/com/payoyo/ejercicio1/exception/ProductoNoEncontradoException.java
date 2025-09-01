package com.payoyo.ejercicio1.exception;

public class ProductoNoEncontradoException extends RuntimeException{

    public ProductoNoEncontradoException(Long id){
        super("No se encontro ningun producto con ID: " + id);
    }
    
}
