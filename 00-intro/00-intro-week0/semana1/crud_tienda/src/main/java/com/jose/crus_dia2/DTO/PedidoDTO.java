package com.jose.crus_dia2.DTO;

import java.time.LocalDate;

import com.jose.crus_dia2.model.Pedido;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PedidoDTO {
    
    @NotNull(message = "El ID del cliente es obligatorio")
    private Long clienteId; //

    @NotNull(message = "La fecha no puede estar vacía")
    private LocalDate fecha;

    @Min(value = 0, message = "El total no puede ser menor a 0")
    private Double total;

    @Enumerated(EnumType.STRING)
    private Pedido.EstadoPedido estado;
}
