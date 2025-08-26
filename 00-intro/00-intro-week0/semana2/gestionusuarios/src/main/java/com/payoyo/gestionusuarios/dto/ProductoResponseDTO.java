package com.payoyo.gestionusuarios.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductoResponseDTO {

    private Long id;
    private String nombre;
    private String descripcion;
    private BigDecimal precio;
    
}
