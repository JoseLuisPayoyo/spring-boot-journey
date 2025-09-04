package com.payoyo.biblioteca.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LibroCreateDTO {
    
    @NotBlank(message = "El titulo es obligatorio")
    @Size(max = 150)
    private String titulo;

    @NotBlank(message = "El isbn es obligatorio")
    @Size(max = 20)
    private String isbn;

    @NotNull(message = "El precio es obligatorio")
    @Positive
    private BigDecimal precio;

    @Min(1900)
    private Integer anioPublicacion;

    @NotNull(message = "El autor es obligatorio")
    private Long autorId;
}
