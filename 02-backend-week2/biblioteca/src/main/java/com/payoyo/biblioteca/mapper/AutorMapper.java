package com.payoyo.biblioteca.mapper;

import com.payoyo.biblioteca.dto.AutorCreateDTO;
import com.payoyo.biblioteca.dto.AutorResponseDTO;
import com.payoyo.biblioteca.model.Autor;

public class AutorMapper {

    public Autor toEntity(AutorCreateDTO dto){
        Autor autor = new Autor();

        autor.setNombre(dto.getNombre());
        autor.setPais(dto.getPais());

        return autor;
    }

    public AutorResponseDTO toDTO(Autor autor){
        return new AutorResponseDTO(
            autor.getId(),
            autor.getNombre(),
            autor.getPais()
        );
    }
    
}
