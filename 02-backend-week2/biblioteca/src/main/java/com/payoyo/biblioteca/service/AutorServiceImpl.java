package com.payoyo.biblioteca.service;

import com.payoyo.biblioteca.dto.AutorCreateDTO;
import com.payoyo.biblioteca.dto.AutorResponseDTO;
import com.payoyo.biblioteca.mapper.AutorMapper;
import com.payoyo.biblioteca.model.Autor;
import com.payoyo.biblioteca.repository.AutorRepository;

public class AutorServiceImpl implements AutorService{

    private AutorRepository autorRepository;
    private AutorMapper autorMapper;
    public AutorServiceImpl(AutorRepository autorRepository, AutorMapper autorMapper) {
        this.autorRepository = autorRepository;
        this.autorMapper = autorMapper;
    }

    // crear autor
    @Override
    public AutorResponseDTO crear(AutorCreateDTO dto) {
        Autor autor = autorMapper.toEntity(dto);

        Autor autorGuardado = autorRepository.save(autor);

        return autorMapper.toDTO(autorGuardado);
    }

    
    
}
