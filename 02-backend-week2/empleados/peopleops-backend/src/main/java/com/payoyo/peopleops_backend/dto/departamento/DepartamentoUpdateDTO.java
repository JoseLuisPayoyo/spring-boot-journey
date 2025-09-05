package com.payoyo.peopleops_backend.dto.departamento;

import java.math.BigDecimal;


import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DepartamentoUpdateDTO {

    @NotBlank(message = "El nombre no puede estar vacio")
    @Size(min = 3, max = 60, message = "El nombre debe tener entre 3 y 60 caracteres")
    private String nombre;

    @NotBlank(message = "El codigo no pude estar vacio")
    @Pattern(regexp = "^[A-Z]{3,8}$", message = "El código debe estar en mayúsculas y tener entre 3 y 8 letras")
    private String codigo;

    @NotNull(message = "El presupuesto anual no puede estar vacio")
    @DecimalMin(value = "0.00", message = "El presupuesto no puede ser negativo")
    @Digits(integer = 12, fraction = 2, message = "El presupuesto debe tener como máximo 2 decimales")
    private BigDecimal presupuestoAnual;
    
}
