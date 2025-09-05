package com.payoyo.peopleops_backend.dto.departamento;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DepartamentoResponseDTO {

    private Long id;
    private String nombre;
    private String codigo;
    private BigDecimal presupuestoAnual;
    private boolean activo;
    
}
