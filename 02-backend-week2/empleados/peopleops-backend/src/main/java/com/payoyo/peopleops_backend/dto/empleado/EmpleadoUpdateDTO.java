package com.payoyo.peopleops_backend.dto.empleado;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.payoyo.peopleops_backend.enums.EstadoEmpleado;
import com.payoyo.peopleops_backend.enums.Puesto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmpleadoUpdateDTO {

    @NotBlank(message = "El nombre no puede ir vacio")
    @Size(min = 2, max = 40, message = "El nombre debe tener entre 2 y 40 caracteres")
    private String nombre;

    @NotBlank(message = "El apellido no puede ir vacio")
    @Size(min = 2, max = 60, message = "El apellido debe tener entre 2 y 60 caracteres")
    private String apellido;

    @NotBlank(message = "El email es obligatorio")
    @Email(message = "No es formato email")
    private String email;

    @Pattern(regexp = "^\\+?\\d{9,15}$", message = "Teléfono inválido")
    private String telefono;

    @NotNull(message = "La fecha de contratacion no puede estar vacia")
    @PastOrPresent(message = "La fecha de contratacion es incorrecta")
    private LocalDate fechaContratacion;

    @NotNull(message = "El salario es obligatorio")
    @DecimalMin(value = "0.00", message = "El presupuesto no puede ser negativo")
    @Digits(integer = 12, fraction = 2, message = "El presupuesto debe tener como máximo 2 decimales")
    private BigDecimal salario;

    @NotNull(message = "El puesto es obligatorio")
    private Puesto puesto;

    @NotNull(message = "El estado del empleado es obligatorio")
    private EstadoEmpleado estado;

    @NotBlank(message = "El departamento es obligatorio")
    private Long departamentoId;

    @NotBlank(message = "El departamento es obligatorio")
    private String departamentoNombre;

    
}
