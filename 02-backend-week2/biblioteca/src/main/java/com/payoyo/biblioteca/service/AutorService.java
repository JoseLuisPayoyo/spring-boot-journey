package com.payoyo.biblioteca.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.payoyo.biblioteca.dto.AutorCreateDTO;
import com.payoyo.biblioteca.dto.AutorResponseDTO;

public interface AutorService {
    
    AutorResponseDTO crear(AutorCreateDTO dto);

    Page<AutorResponseDTO> listar(Pageable pageable);

    Page<AutorResponseDTO> buscar(String nombre, String pais, Pageable pageable);
}
