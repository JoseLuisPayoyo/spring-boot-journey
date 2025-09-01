package com.payoyo.ejercicio1.service;

import java.util.List;

import com.payoyo.ejercicio1.dto.ProductoCreateDTO;
import com.payoyo.ejercicio1.dto.ProductoResponseDTO;
import com.payoyo.ejercicio1.dto.ProductoUpdateDTO;

public interface IProductoService {

    ProductoResponseDTO crear(ProductoCreateDTO dto);

    List<ProductoResponseDTO> buscarTodos();

    ProductoResponseDTO obtenerPorId(Long id);

    ProductoResponseDTO eliminar(Long id);

    ProductoResponseDTO actualizar(Long id, ProductoUpdateDTO dto);

} 
