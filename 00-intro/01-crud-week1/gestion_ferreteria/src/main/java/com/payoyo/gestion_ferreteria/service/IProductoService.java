package com.payoyo.gestion_ferreteria.service;

import java.util.List;

import com.payoyo.gestion_ferreteria.dto.CreateProductoDTO;
import com.payoyo.gestion_ferreteria.dto.ProductoResponseDTO;

public interface IProductoService {

    ProductoResponseDTO crear(CreateProductoDTO dto);

    List<ProductoResponseDTO> buscarTodos();

    ProductoResponseDTO obtenerPorId(Long id);

    ProductoResponseDTO eliminar(Long id);

    ProductoResponseDTO actualizar(Long id, CreateProductoDTO dto);
    
} 
