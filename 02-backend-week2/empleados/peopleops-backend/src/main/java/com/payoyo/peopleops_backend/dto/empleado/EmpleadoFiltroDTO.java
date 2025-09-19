package com.payoyo.peopleops_backend.dto.empleado;

import java.math.BigDecimal;

import com.payoyo.peopleops_backend.enums.EstadoEmpleado;

import lombok.Data;

@Data
public class EmpleadoFiltroDTO {

    private String nombre;
    private String apellidos;
    private Long departamentoId;
    private EstadoEmpleado estado; //enum
    private BigDecimal salarioMin;
    private BigDecimal salarioMax;
    
}
