package com.payoyo.ejercicio1.service;

import java.util.List;

import com.payoyo.ejercicio1.dto.ProductoCreateDTO;
import com.payoyo.ejercicio1.dto.ProductoResponseDTO;
import com.payoyo.ejercicio1.dto.ProductoUpdateDTO;

public interface ProductoService {

    ProductoResponseDTO crear(ProductoCreateDTO dto);

    List<ProductoResponseDTO> buscarTodos();

    ProductoResponseDTO buscarPorId(Long id);

    void eliminar(Long id);

    ProductoResponseDTO actualizar(Long id, ProductoUpdateDTO dto);

} 
