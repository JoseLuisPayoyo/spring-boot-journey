package com.payoyo.ejercicio2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseClasesDTO {

    private Long id;
    private String nombre_clase;
    private int duracion;
    private String nombre_profesor;
    
}
