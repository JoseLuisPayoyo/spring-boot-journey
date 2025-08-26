package com.payoyo.clientes_pedidos.mapper;

import com.payoyo.clientes_pedidos.dto.PedidoDTO;
import com.payoyo.clientes_pedidos.model.Pedido;

public class PedidoMapper {

    public PedidoDTO toDTO(Pedido pedido){
        PedidoDTO pedidoDTO = new PedidoDTO();

        pedidoDTO.setId(pedido.getId());
        pedidoDTO.setDescripcion(pedido.getDescripcion());
        pedidoDTO.setFecha(pedido.getFecha());
        pedidoDTO.setTotal(pedido.getTotal());
        
        return pedidoDTO;
    }

    public Pedido toEntity(PedidoDTO pedidoDTO){
        Pedido pedido = new Pedido();
        
        pedido.setId(pedidoDTO.getId());
        pedido.setDescripcion(pedidoDTO.getDescripcion());
        pedido.setFecha(pedidoDTO.getFecha());
        pedido.setTotal(pedidoDTO.getTotal());

        return pedido;
    }
    
}
