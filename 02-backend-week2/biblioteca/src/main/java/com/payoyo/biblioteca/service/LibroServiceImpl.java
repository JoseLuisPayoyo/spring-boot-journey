package com.payoyo.biblioteca.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.payoyo.biblioteca.dto.LibroCreateDTO;
import com.payoyo.biblioteca.dto.LibroResponseDTO;
import com.payoyo.biblioteca.exception.AutorNoEncontradoException;
import com.payoyo.biblioteca.mapper.LibroMapper;
import com.payoyo.biblioteca.model.Autor;
import com.payoyo.biblioteca.model.Libro;
import com.payoyo.biblioteca.repository.AutorRepository;
import com.payoyo.biblioteca.repository.LibroRepository;

@Service
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

    @Override
    public Page<LibroResponseDTO> listar(Pageable pageable) {
        Page<Libro> paginaLibros = libroRepository.findAll(pageable);

        Page<LibroResponseDTO> librosDTOs = paginaLibros.map(libro -> libroMapper.toDTO(libro));

        return librosDTOs;
    }

    @Override
    public Page<LibroResponseDTO> buscar(String titulo, Long autorId, Pageable pageable) {
        Page<Libro> paginaLibros;

        if (titulo == null || titulo.isBlank()) {
            if (autorId == null) {
                // no hay filtros
                paginaLibros = libroRepository.findAll(pageable);
            } else{
                // solo con el id sel autor
                paginaLibros = libroRepository.findByAutorId(autorId, pageable);
            }
        } else{
            if (autorId == null) {
                // solo titulo
                paginaLibros = libroRepository.findByTituloContainingIgnoreCase(titulo, pageable);
            } else{
                // todo
                paginaLibros = libroRepository.findByTituloContainingIgnoreCaseAndAutorId(titulo, autorId, pageable);
            }
        }

        Page<LibroResponseDTO> librosDTOs = paginaLibros.map(libros -> libroMapper.toDTO(libros));

        return librosDTOs;
    }

    
    
}
