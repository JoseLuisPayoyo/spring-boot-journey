package com.payoyo.peopleops_backend.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "departamentos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Departamento {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    @NotNull(message = "El nombre no puede ser nulo")
    private String nombre;

    @Column(nullable = false, unique = true)
    @NotNull(message = "El codigo no puede ser nulo")
    private String codigo;

    @Column(nullable = false, unique = true)
    @NotNull(message = "El presupuesto anual es obligatorio")
    @DecimalMin(value = "0.00", message = "El presupuesto no puede ser negativo")
    private BigDecimal presupuestoAnual;

    @Column(nullable = false)
    private boolean activo = true;

    @OneToMany(mappedBy = "departamento", fetch = FetchType.LAZY)
    private List<Empleado> empleados = new ArrayList<>();


}
