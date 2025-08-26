package com.payoyo.clientes_pedidos.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.Data;

@Data
public class PedidoDTO {
    private Long id;
    private String descripcion;
    private LocalDate fecha;
    private BigDecimal total;
}
