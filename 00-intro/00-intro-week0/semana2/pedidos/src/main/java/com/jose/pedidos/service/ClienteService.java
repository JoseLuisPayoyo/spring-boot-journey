package com.jose.pedidos.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jose.pedidos.dto.ClienteDTO;
import com.jose.pedidos.exception.RecursoNoEncontradoException;
import com.jose.pedidos.model.Cliente;
import com.jose.pedidos.repository.ClienteRepository;
import com.jose.pedidos.util.ClienteMapper;

@Service
public class ClienteService implements IClienteService{

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public ClienteDTO guardarCliente(ClienteDTO clienteDTO) {
        Cliente cliente = ClienteMapper.toEntity(clienteDTO);
        Cliente clienteGuardado = clienteRepository.save(cliente);
        return ClienteMapper.toDTO(clienteGuardado);
    }

    @Override
    public List<ClienteDTO> listarClientes() {
        return clienteRepository.findAll()
            .stream()
            .map(ClienteMapper::toDTO)
            .collect(Collectors.toList());
    }

    @Override
    public ClienteDTO buscarClientePorId(Long id) {
        Cliente cliente = clienteRepository.findById(id)
            .orElseThrow(() -> new RecursoNoEncontradoException("Cliente no encontrado con id: " + id));
        return ClienteMapper.toDTO(cliente);
    }

    @Override
    public void eliminarCliente(Long id) {
        Cliente cliente = clienteRepository.findById(id)
            .orElseThrow(() -> new RecursoNoEncontradoException("Cliente no encontrado con id: " + id));
    
        clienteRepository.delete(cliente);
    }
    
}
