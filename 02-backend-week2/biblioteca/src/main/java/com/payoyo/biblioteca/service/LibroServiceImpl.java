package com.payoyo.biblioteca.service;

import com.payoyo.biblioteca.dto.LibroCreateDTO;
import com.payoyo.biblioteca.dto.LibroResponseDTO;
import com.payoyo.biblioteca.exception.AutorNoEncontradoException;
import com.payoyo.biblioteca.mapper.LibroMapper;
import com.payoyo.biblioteca.model.Autor;
import com.payoyo.biblioteca.model.Libro;
import com.payoyo.biblioteca.repository.AutorRepository;
import com.payoyo.biblioteca.repository.LibroRepository;

public class LibroServiceImpl implements LibroService{

    private LibroRepository libroRepository;
    private LibroMapper libroMapper;
    private AutorRepository autorRepository;

    public LibroServiceImpl(LibroRepository libroRepository, LibroMapper libroMapper, AutorRepository autorRepository){
        this.libroRepository = libroRepository;
        this.libroMapper = libroMapper;
        this.autorRepository = autorRepository;
    }

    @Override
    public LibroResponseDTO crear(LibroCreateDTO dto) {
        Autor autor = autorRepository.findById(dto.getAutorId())
            .orElseThrow(() -> new AutorNoEncontradoException(dto.getAutorId()));

        Libro libroCompleto = libroMapper.toEntity(dto, autor);

        Libro libroGuardado = libroRepository.save(libroCompleto);

        return libroMapper.toDTO(libroGuardado);
    }

    
    
}
