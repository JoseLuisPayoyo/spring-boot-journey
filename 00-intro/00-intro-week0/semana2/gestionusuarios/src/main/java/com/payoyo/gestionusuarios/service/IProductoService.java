package com.payoyo.gestionusuarios.service;

import java.util.List;

import com.payoyo.gestionusuarios.dto.ProductoRequestDTO;
import com.payoyo.gestionusuarios.dto.ProductoResponseDTO;

public interface IProductoService {

    ProductoResponseDTO crearProducto(ProductoRequestDTO request);

    List<ProductoResponseDTO> listarProductos();

    ProductoResponseDTO obtenerProducto(Long id);

    ProductoResponseDTO actualizarProducto(Long id, ProductoRequestDTO request);

    void eliminarProducto(Long id);
    
}
