package com.payoyo.gestion_ferreteria.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.payoyo.gestion_ferreteria.dto.CreateProductoDTO;
import com.payoyo.gestion_ferreteria.dto.ProductoResponseDTO;
import com.payoyo.gestion_ferreteria.service.IProductoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/productos")
@CrossOrigin(origins = "*")
public class ProductoController {

    private final IProductoService productoService;
    public ProductoController(IProductoService productoService) {
        this.productoService = productoService;
    }

    //crear
    @PostMapping
    public ResponseEntity<ProductoResponseDTO> crear(@Valid @RequestBody CreateProductoDTO dto){
        ProductoResponseDTO productoCreado = productoService.crear(dto);
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(productoCreado);
    }

    //listar todos
    @GetMapping
    public ResponseEntity<List<ProductoResponseDTO>> buscarTodos() {
        List<ProductoResponseDTO> productos = productoService.buscarTodos();
        return ResponseEntity
                .ok(productos);
    }

    //listar por id
    @GetMapping("/{id}")
    public ResponseEntity<ProductoResponseDTO> obtenerPorId(@PathVariable Long id) {
        ProductoResponseDTO producto = productoService.obtenerPorId(id);
        return ResponseEntity
                .ok(producto);
    }
    //eliminar
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        productoService.eliminar(id);
        return ResponseEntity
                .noContent()
                .build(); // 204 No Content
    }

    //actualizar
     @PutMapping("/{id}")
    public ResponseEntity<ProductoResponseDTO> actualizar(
            @PathVariable Long id,
            @Valid @RequestBody CreateProductoDTO dto) {

        ProductoResponseDTO actualizado = productoService.actualizar(id, dto);
        return ResponseEntity
                .ok(actualizado);
    }

    
}
