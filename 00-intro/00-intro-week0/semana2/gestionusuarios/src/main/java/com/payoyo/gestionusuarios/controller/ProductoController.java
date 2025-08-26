package com.payoyo.gestionusuarios.controller;

import com.payoyo.gestionusuarios.dto.ProductoRequestDTO;
import com.payoyo.gestionusuarios.dto.ProductoResponseDTO;
import com.payoyo.gestionusuarios.service.IProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
@RequiredArgsConstructor
public class ProductoController {

    private final IProductoService productoService;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ProductoResponseDTO> crear(@RequestBody ProductoRequestDTO request) {
        return ResponseEntity.ok(productoService.crearProducto(request));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ProductoResponseDTO> actualizar(@PathVariable Long id, @RequestBody ProductoRequestDTO request) {
        return ResponseEntity.ok(productoService.actualizarProducto(id, request));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        productoService.eliminarProducto(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<ProductoResponseDTO>> listar() {
        return ResponseEntity.ok(productoService.listarProductos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductoResponseDTO> obtener(@PathVariable Long id) {
        return ResponseEntity.ok(productoService.obtenerProducto(id));
    }
}
