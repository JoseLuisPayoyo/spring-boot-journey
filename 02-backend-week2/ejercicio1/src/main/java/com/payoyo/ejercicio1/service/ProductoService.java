package com.payoyo.ejercicio1.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import com.payoyo.ejercicio1.dto.ProductoCreateDTO;
import com.payoyo.ejercicio1.dto.ProductoResponseDTO;
import com.payoyo.ejercicio1.dto.ProductoUpdateDTO;

public interface ProductoService {

    ProductoResponseDTO crear(ProductoCreateDTO dto);

    List<ProductoResponseDTO> buscarTodos();

    ProductoResponseDTO buscarPorId(Long id);

    void eliminar(Long id);

    ProductoResponseDTO actualizar(Long id, ProductoUpdateDTO dto);
    
    Page<ProductoResponseDTO> findAll(Pageable pageable);

} 
