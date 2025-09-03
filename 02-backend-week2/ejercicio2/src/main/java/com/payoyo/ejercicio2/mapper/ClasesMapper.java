package com.payoyo.ejercicio2.mapper;

import org.springframework.stereotype.Component;

import com.payoyo.ejercicio2.dto.CreateClasesDTO;
import com.payoyo.ejercicio2.dto.ResponseClasesDTO;
import com.payoyo.ejercicio2.model.Clases;


@Component
public class ClasesMapper {


    // pasar de dto a entidad
    public Clases toEntity(CreateClasesDTO dto){
        Clases clase = new Clases();

        clase.setNombre_clase(dto.getNombre_clase());
        clase.setDuracion(dto.getDuracion());
        clase.setNombre_profesor(dto.getNombre_profesor());

        return clase;
    }


    // pasar de entidad a dto
    public ResponseClasesDTO toDTO(Clases clase){
        return new ResponseClasesDTO(
            clase.getId(),
            clase.getNombre_clase(),
            clase.getDuracion(),
            clase.getNombre_profesor()
        );
    }
    
}
