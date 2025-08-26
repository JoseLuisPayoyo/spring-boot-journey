package com.jose.crud_en_db.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LibroDTO {

    @NotBlank(message = "El titulo no puede ir vacio")
    private String titulo;

    @NotBlank(message = "El autor no puede ir vacío")
    private String autor;

    @Min(value = 0, message="El año no puede ser negativo")
    private Integer anioPublicacion;

    @NotNull(message = "Tienes que indicar si esta disponible")
    private Boolean disponible;
}
