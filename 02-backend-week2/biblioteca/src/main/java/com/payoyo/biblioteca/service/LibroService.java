package com.payoyo.biblioteca.service;

import com.payoyo.biblioteca.dto.LibroCreateDTO;
import com.payoyo.biblioteca.dto.LibroResponseDTO;

public interface LibroService {

    LibroResponseDTO crear(LibroCreateDTO dto);
    
} 
