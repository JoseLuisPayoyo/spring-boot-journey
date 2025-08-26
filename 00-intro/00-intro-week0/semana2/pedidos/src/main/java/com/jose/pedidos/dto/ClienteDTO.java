package com.jose.pedidos.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteDTO {

    private Long id;

    @NotBlank(message = "El nombre no puede ir vacio")
    private String nombre;

    @NotBlank(message = "El email no puede ir vacio")
    private String email;

    @Min(value = 600000000, message = "Numero de telefono inocrrecto")
    @Max(value = 699999999)
    private int telefono;
    
}
