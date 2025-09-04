package com.payoyo.biblioteca.service;

import com.payoyo.biblioteca.dto.AutorCreateDTO;
import com.payoyo.biblioteca.dto.AutorResponseDTO;

public interface AutorService {
    
    AutorResponseDTO crear(AutorCreateDTO dto);
}
