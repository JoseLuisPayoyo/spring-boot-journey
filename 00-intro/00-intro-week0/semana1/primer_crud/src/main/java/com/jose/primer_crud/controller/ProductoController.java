package com.jose.primer_crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jose.primer_crud.dto.ProductoDTO;
import com.jose.primer_crud.model.Producto;
import com.jose.primer_crud.service.ProductoService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/producto")
@CrossOrigin(origins = "*")
public class ProductoController {
    
    @Autowired
    private ProductoService productoService;

    @GetMapping()
    public List<Producto> listarProductos(){
        return productoService.listarProductos();
    }

    @PostMapping()
    public Producto crearProducto(@Valid @RequestBody ProductoDTO productoDTO){
        Producto producto = new Producto();
        producto.setNombre(productoDTO.getNombre());
        producto.setPrecio(productoDTO.getPrecio());
        producto.setEnStock(productoDTO.getEnStock());
        return productoService.crearProducto(producto);
    }

    @DeleteMapping("/{id}")
    public void eliminarProductoPorId(@PathVariable Long id) {
        productoService.eliminarProductoPorId(id);
    }

    @GetMapping("/en-stock")
    public List<Producto> filtraProductosEnStock(){
        return productoService.filtrarEnStock();
    }
    
}
