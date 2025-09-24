package com.payoyo.inyeccion_dependencias.repositories;

import java.util.Arrays;
import java.util.List;

import com.payoyo.inyeccion_dependencias.models.Producto;

public class ProductoRepository {

    private List<Producto> data;

    public ProductoRepository() {
        this.data = Arrays.asList(
            new Producto(1L, "memoria", 300L),
            new Producto(2L, "cpu", 350L),
            new Producto(3L, "teclado", 50L),
            new Producto(4L, "ram", 100L)
        );
    }

    public List<Producto> findAll() {
        return data;
    }

    public Producto findById(Long id){
        return data.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    }

    
}
