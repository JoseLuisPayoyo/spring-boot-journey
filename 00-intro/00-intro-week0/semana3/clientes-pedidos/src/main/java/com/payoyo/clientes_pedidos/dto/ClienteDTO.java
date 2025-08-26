package com.payoyo.clientes_pedidos.dto;

import java.util.List;

import lombok.Data;

@Data
public class ClienteDTO {
    private Long id;
    private String nombre;
    private String correo;
    private String telefono;
    private List<PedidoDTO> pedidos;
}
