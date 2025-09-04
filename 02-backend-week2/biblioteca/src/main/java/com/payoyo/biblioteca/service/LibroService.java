package com.payoyo.biblioteca.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.payoyo.biblioteca.dto.LibroCreateDTO;
import com.payoyo.biblioteca.dto.LibroResponseDTO;

public interface LibroService {

    LibroResponseDTO crear(LibroCreateDTO dto);

    Page<LibroResponseDTO> listar(Pageable pageable);
    
    Page<LibroResponseDTO> buscar(String titulo, Long autorId, Pageable pageable);
} 
