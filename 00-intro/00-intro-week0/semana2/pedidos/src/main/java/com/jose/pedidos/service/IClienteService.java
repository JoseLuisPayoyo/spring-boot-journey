package com.jose.pedidos.service;

import java.util.List;

import com.jose.pedidos.dto.ClienteDTO;

public interface IClienteService {

    ClienteDTO guardarCliente(ClienteDTO clienteDTO);

    List<ClienteDTO> listarClientes();

    ClienteDTO buscarClientePorId(Long id);

    void eliminarCliente(Long id);
}
