package com.payoyo.ejercicio2.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateClasesDTO {

    @NotBlank
    private String nombre_clase;

    private int duracion;

    @NotBlank
    private String nombre_profesor;
    
}
