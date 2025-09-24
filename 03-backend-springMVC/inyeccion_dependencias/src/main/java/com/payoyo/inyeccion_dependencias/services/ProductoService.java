package com.payoyo.inyeccion_dependencias.services;

import java.util.List;


import com.payoyo.inyeccion_dependencias.models.Producto;
import com.payoyo.inyeccion_dependencias.repositories.ProductoRepository;

public class ProductoService {

    private ProductoRepository productoRepository;
    public ProductoService(ProductoRepository productoRepository){
        this.productoRepository = productoRepository;
    }

    public List<Producto> findAll(){
        return productoRepository.findAll();
    }

    public Producto findById(Long id){
        return productoRepository.findById(id);
    }
    
}
