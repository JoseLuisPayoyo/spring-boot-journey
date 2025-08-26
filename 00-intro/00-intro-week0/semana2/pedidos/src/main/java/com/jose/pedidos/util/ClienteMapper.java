package com.jose.pedidos.util;

import com.jose.pedidos.dto.ClienteDTO;
import com.jose.pedidos.model.Cliente;

public class ClienteMapper {

    //dto a entidad
    public static Cliente toEntity(ClienteDTO clienteDTO){
        Cliente cliente = new Cliente();
        cliente.setId(clienteDTO.getId());
        cliente.setNombre(clienteDTO.getNombre());
        cliente.setEmail(clienteDTO.getEmail());
        cliente.setTelefono(clienteDTO.getTelefono());

        return cliente;
    }

    //entidad a dto
    public static ClienteDTO toDTO(Cliente cliente){
        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setId(cliente.getId());
        clienteDTO.setNombre(cliente.getNombre());
        clienteDTO.setEmail(cliente.getEmail());
        clienteDTO.setTelefono(cliente.getTelefono());

        return clienteDTO;
    }
    
}
