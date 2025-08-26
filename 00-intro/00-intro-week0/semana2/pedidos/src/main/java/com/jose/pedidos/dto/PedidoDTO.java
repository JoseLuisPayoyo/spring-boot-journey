package com.jose.pedidos.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PedidoDTO {

    private Long id;

    @NotNull(message = "Fecha incorrecta")
    private LocalDate fecha;

    @NotNull(message = "El pedido tiene que tener un estado de envio")
    private boolean enviado;
    
    @NotNull(message = "El ID de cliente es obligatorio")
    private Long clienteId;
}
