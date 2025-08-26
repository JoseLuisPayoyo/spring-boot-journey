package com.payoyo.clientes_pedidos.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payoyo.clientes_pedidos.dto.ClienteDTO;
import com.payoyo.clientes_pedidos.dto.PedidoDTO;
import com.payoyo.clientes_pedidos.exception.RecursoNoEncontradoException;
import com.payoyo.clientes_pedidos.mapper.ClienteMapper;
import com.payoyo.clientes_pedidos.mapper.PedidoMapper;
import com.payoyo.clientes_pedidos.model.Cliente;
import com.payoyo.clientes_pedidos.model.Pedido;
import com.payoyo.clientes_pedidos.repository.ClienteRepository;

@Service
public class ClienteService implements IClienteService{

    @Autowired
    private ClienteRepository clienteRepository;

    private final ClienteMapper clienteMapper = new ClienteMapper();
    private final PedidoMapper pedidoMapper = new PedidoMapper();

    @Override
    public ClienteDTO crearCliente(ClienteDTO clienteDTO) {
        //pasamos a entidad
        Cliente cliente = clienteMapper.toEntity(clienteDTO);
        //guardamos en db
        Cliente clienteGuardado = clienteRepository.save(cliente);

        //devolvemos dto
        return clienteMapper.toDTO(clienteGuardado);
    }

    @Override
    public Optional<ClienteDTO> obtenerCliente(Long id) {
        return clienteRepository.findWithPedidosById(id)
            .map(clienteMapper::toDTO);
    }

    public PedidoDTO agregarPedido(Long clienteId, PedidoDTO dto) {
        Cliente cliente = clienteRepository.findWithPedidosById(clienteId)
            .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

        Pedido pedido = pedidoMapper.toEntity(dto);
        cliente.addPedido(pedido);

        clienteRepository.save(cliente); 

        return pedidoMapper.toDTO(pedido);
    }

    @Override
    public List<PedidoDTO> obtenerPedidosDeCliente(Long clienteId) {
        Cliente cliente = clienteRepository.findWithPedidosById(clienteId)
            .orElseThrow(() -> new RecursoNoEncontradoException("Cliente no encontrado con id: " + clienteId));

        return cliente.getPedidos()
            .stream()
            .map(pedidoMapper::toDTO)
            .collect(Collectors.toList());    
    }

    @Override
    public void eliminarPedidoDeCliente(Long clienteId, Long pedidoId) {
        Cliente cliente = clienteRepository.findWithPedidosById(clienteId)
            .orElseThrow(() -> new RecursoNoEncontradoException("Cliente no encontrado con id: " + clienteId));
        
        Pedido pedidoAEliminar = cliente.getPedidos().stream()
            .filter(p -> p.getId().equals(pedidoId))
            .findFirst()
            .orElseThrow(() -> new RuntimeException("Pedido no encontrado"));

        cliente.removePedido(pedidoAEliminar); // actualiza la relación y marca el pedido como huérfano

        clienteRepository.save(cliente); // por orphanRemoval, el pedido se elimina
    }


    
    
}
