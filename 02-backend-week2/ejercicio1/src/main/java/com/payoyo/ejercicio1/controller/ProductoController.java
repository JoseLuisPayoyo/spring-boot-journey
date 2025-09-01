package com.payoyo.ejercicio1.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.payoyo.ejercicio1.dto.ProductoCreateDTO;
import com.payoyo.ejercicio1.dto.ProductoResponseDTO;
import com.payoyo.ejercicio1.dto.ProductoUpdateDTO;
import com.payoyo.ejercicio1.service.ProductoService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/productos")
@CrossOrigin(origins = "*")
public class ProductoController {

    private final ProductoService productoService;
    public ProductoController(ProductoService productoService){
        this.productoService = productoService;
    }

    // crear
    @PostMapping
    public ResponseEntity<ProductoResponseDTO> crear(@Valid @RequestBody ProductoCreateDTO dto){
        ProductoResponseDTO productoCreado = productoService.crear(dto);

        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(productoCreado);
    }

    // listar todos los productos
    @GetMapping
    public ResponseEntity<List<ProductoResponseDTO>> buscarTodos() {
        List<ProductoResponseDTO> productos = productoService.buscarTodos();

        return ResponseEntity
            .ok(productos);
    }

    // listar por id
    @GetMapping("/{id}")
    public ResponseEntity<ProductoResponseDTO> buscarPorId(@PathVariable Long id){
        ProductoResponseDTO dto = productoService.buscarPorId(id);

        return ResponseEntity 
            .ok(dto);
    }

    // actualizar
    @PutMapping("/{id}")
    public ResponseEntity<ProductoResponseDTO> actualizar(
        @PathVariable Long id, 
        @Valid @RequestBody ProductoUpdateDTO dto)
    {
        ProductoResponseDTO actualizado = productoService.actualizar(id, dto);
        return ResponseEntity
                .ok(actualizado);
    }

    // eliminar
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id){
        productoService.eliminar(id);
        return ResponseEntity
                .noContent()
                .build();
    }
    
}
