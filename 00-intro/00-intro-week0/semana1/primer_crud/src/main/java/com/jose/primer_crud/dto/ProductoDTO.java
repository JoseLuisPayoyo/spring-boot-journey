package com.jose.primer_crud.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductoDTO {

    @NotBlank(message = "El nombre no puede ir vacio")
    private String nombre;

    @Min(value = 0, message = "El precio debe ser mayor o igual a 0")
    @NotNull(message = "El precio no puede ser nulo")
    private Double precio;

    @NotNull(message = "Debe indicar si esta en stock")
    private Boolean enStock;
    
}
