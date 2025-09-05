package com.payoyo.peopleops_backend.dto.empleado;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.payoyo.peopleops_backend.enums.EstadoEmpleado;
import com.payoyo.peopleops_backend.enums.Puesto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmpleadoResponseDTO {
    
    private Long id;
    private String nombre,
                apellido,
                email,
                telefono, 
                departamentoNombre;
    private LocalDate fechaContratacion;
    private BigDecimal salario;
    private Puesto puesto;
    private EstadoEmpleado estado;
}
