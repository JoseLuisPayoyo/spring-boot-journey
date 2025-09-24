package com.payoyo.inyeccion_dependencias.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.payoyo.inyeccion_dependencias.models.Producto;
import com.payoyo.inyeccion_dependencias.services.ProductoService;

@RestController
@RequestMapping("/api")
public class ProductoController {

    private final ProductoService productoService;
    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }


    @GetMapping
    public List<Producto> listar(){
        return productoService.findAll();
    } 

    @GetMapping("/{id}")
    public Producto listarPorId(@PathVariable Long id){
        return productoService.findById(id);
    }
}
