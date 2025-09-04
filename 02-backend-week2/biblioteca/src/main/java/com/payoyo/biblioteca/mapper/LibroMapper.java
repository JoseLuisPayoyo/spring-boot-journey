package com.payoyo.biblioteca.mapper;

import org.springframework.stereotype.Component;

import com.payoyo.biblioteca.dto.LibroCreateDTO;
import com.payoyo.biblioteca.dto.LibroResponseDTO;
import com.payoyo.biblioteca.model.Autor;
import com.payoyo.biblioteca.model.Libro;

@Component
public class LibroMapper {

    public Libro toEntity(LibroCreateDTO dto, Autor autor){
        Libro libro = new Libro();

        libro.setTitulo(dto.getTitulo());
        libro.setIsbn(dto.getIsbn());
        libro.setPrecio(dto.getPrecio());
        libro.setAnioPublicacion(dto.getAnioPublicacion());
        libro.setAutor(autor);

        return libro;
    }

    public LibroResponseDTO toDTO(Libro libro) {
        return new LibroResponseDTO(
            libro.getId(),
            libro.getTitulo(),
            libro.getIsbn(),
            libro.getPrecio(),
            libro.getAnioPublicacion(),
            libro.getAutor().getId(),
            libro.getAutor().getNombre()
        );
    }
    
}
