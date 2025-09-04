package com.payoyo.biblioteca.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.payoyo.biblioteca.dto.AutorCreateDTO;
import com.payoyo.biblioteca.dto.AutorResponseDTO;
import com.payoyo.biblioteca.mapper.AutorMapper;
import com.payoyo.biblioteca.model.Autor;
import com.payoyo.biblioteca.repository.AutorRepository;

@Service
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


    // lista paginada de autores, con posibilidad de ordenar por nombre o país.
    @Override
    public Page<AutorResponseDTO> listar(Pageable pageable) {
        Page<Autor> paginaAutores = autorRepository.findAll(pageable);

        Page<AutorResponseDTO> paginaDTOs = paginaAutores.map(autor -> autorMapper.toDTO(autor));

        return paginaDTOs;
    }

    
    
}
