package com.payoyo.gestion_ferreteria.exception;

public class ProductoNoEncontradoException extends RuntimeException{
    
    public ProductoNoEncontradoException(Long id){
        super("No se encontro ningún producto con ID: " + id);
    }
}
