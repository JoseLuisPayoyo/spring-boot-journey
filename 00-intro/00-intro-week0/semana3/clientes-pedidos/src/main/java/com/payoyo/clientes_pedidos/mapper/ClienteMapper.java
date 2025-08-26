package com.payoyo.clientes_pedidos.mapper;

import java.util.List;
import java.util.stream.Collectors;


import com.payoyo.clientes_pedidos.dto.ClienteDTO;
import com.payoyo.clientes_pedidos.dto.PedidoDTO;
import com.payoyo.clientes_pedidos.model.Cliente;
import com.payoyo.clientes_pedidos.model.Pedido;

public class ClienteMapper {

    private final PedidoMapper pedidoMapper = new PedidoMapper();

    public ClienteDTO toDTO(Cliente cliente){
        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setId(cliente.getId());
        clienteDTO.setNombre(cliente.getNombre());
        clienteDTO.setCorreo(cliente.getCorreo());
        clienteDTO.setTelefono(cliente.getTelefono());

        if (cliente.getPedidos() != null) {
            List<PedidoDTO> pedidosDTO = cliente.getPedidos()
                .stream()
                .map(pedidoMapper::toDTO)
                .collect(Collectors.toList());
            clienteDTO.setPedidos(pedidosDTO);    
        }

        return clienteDTO;
    }

    public Cliente toEntity(ClienteDTO clienteDTO){
        Cliente cliente = new Cliente();
        cliente.setId(clienteDTO.getId());
        cliente.setNombre(clienteDTO.getNombre());
        cliente.setCorreo(clienteDTO.getCorreo());
        cliente.setTelefono(clienteDTO.getTelefono());

        if (clienteDTO.getPedidos() != null) {
            List<Pedido> pedidos = clienteDTO.getPedidos()
                .stream()
                .map(pedidoDTO -> {
                    Pedido pedido = pedidoMapper.toEntity(pedidoDTO);
                    pedido.setCliente(cliente); 
                    return pedido;
                })
                .collect(Collectors.toList());
            cliente.setPedidos(pedidos);
        }

        return cliente;
    }
    
}
