package com.payoyo.gestionusuarios.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductoRequestDTO {

    private String nombre;
    private String descripcion;
    private BigDecimal precio;
    
}
