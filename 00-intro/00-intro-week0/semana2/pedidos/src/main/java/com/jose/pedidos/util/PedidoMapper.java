package com.jose.pedidos.util;

import com.jose.pedidos.dto.PedidoDTO;
import com.jose.pedidos.model.Cliente;
import com.jose.pedidos.model.Pedido;

public class PedidoMapper {

    //dto a entidad
    public static Pedido toEntity(PedidoDTO pedidoDTO, Cliente cliente){
        Pedido pedido = new Pedido();
        pedido.setId(pedidoDTO.getId());
        pedido.setFecha(pedidoDTO.getFecha());
        pedido.setEnviado(pedidoDTO.isEnviado());
        pedido.setCliente(cliente);

        return pedido;
    }

    //entidad a dto
    public static PedidoDTO toDTO(Pedido pedido){
        PedidoDTO pedidoDTO = new PedidoDTO();
        pedidoDTO.setId(pedido.getId());
        pedidoDTO.setFecha(pedido.getFecha());
        pedidoDTO.setEnviado(pedido.isEnviado());
        pedidoDTO.setClienteId(pedido.getCliente().getId());

        return pedidoDTO;
    }
    
}
