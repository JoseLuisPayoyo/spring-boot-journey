package com.payoyo.peopleops_backend.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.payoyo.peopleops_backend.enums.EstadoEmpleado;
import com.payoyo.peopleops_backend.enums.Puesto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "empleados")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Empleado {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotNull(message = "El nombre no puede ser nulo")
    private String nombre;

    @Column(nullable = false)
    @NotNull(message = "El apellido no puede ser nulo")
    private String apellido;

    @Column(nullable = false, unique = true)
    @NotNull(message = "El email no puede ser nulo")
    @Email
    private String email;

    private String telefono;

    @Column(nullable = false)
    @NotNull(message = "La fecha de contratacion no puede ser nula")
    @PastOrPresent(message = "La fecha de contratacion no puede ser futura")
    private LocalDate fechaContratacion;

    @Column(nullable = false)
    @NotNull(message = "El salario no puede ser nulo")
    @DecimalMin(value = "0.00", message = "El presupuesto no puede ser negativo")
    private BigDecimal salario;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    @NotNull(message = "El puesto es obligatorio")
    private Puesto puesto;


    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    @NotNull(message = "El estado del empleado es obligatorio")
    private EstadoEmpleado estado = EstadoEmpleado.ACTIVE;

    @ManyToOne(optional = false)
    @JoinColumn(name = "departamento_id", nullable = false)
    private Departamento departamento;



}
