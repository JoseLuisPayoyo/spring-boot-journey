package com.jose.crus_dia2.mapper;


import com.jose.crus_dia2.DTO.PedidoDTO;
import com.jose.crus_dia2.model.Cliente;
import com.jose.crus_dia2.model.Pedido;

public class PedidoMapper {

    //convertir DTO a entidad
    public static Pedido toEntity(PedidoDTO dto){
        Pedido pedido = new Pedido();
        pedido.setFecha(dto.getFecha());
        pedido.setEstado(dto.getEstado());
        pedido.setTotal(dto.getTotal());

        Cliente cliente = new Cliente();
        cliente.setId(dto.getClienteId()); 
        pedido.setCliente(cliente);  

        return pedido;
    }
    
    //convertir de entidad a dto
    public static PedidoDTO toDTO(Pedido pedido) {
        PedidoDTO dto = new PedidoDTO();
        dto.setClienteId(pedido.getCliente().getId());
        dto.setFecha(pedido.getFecha());
        dto.setTotal(pedido.getTotal());
        dto.setEstado(pedido.getEstado());
        return dto;
    }


    
}
