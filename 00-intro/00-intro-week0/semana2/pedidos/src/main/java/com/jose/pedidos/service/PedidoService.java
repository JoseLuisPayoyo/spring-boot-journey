package com.jose.pedidos.service;

import java.util.List;
import java.util.stream.Collectors;

import com.jose.pedidos.repository.PedidoRepository;
import com.jose.pedidos.util.PedidoMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jose.pedidos.dto.PedidoDTO;
import com.jose.pedidos.exception.RecursoNoEncontradoException;
import com.jose.pedidos.model.Cliente;
import com.jose.pedidos.model.Pedido;
import com.jose.pedidos.repository.ClienteRepository;

@Service
public class PedidoService implements IPedidoService{

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public PedidoDTO guardarPedido(PedidoDTO pedidoDTO) {
        Cliente cliente = clienteRepository.findById(pedidoDTO.getClienteId())
            .orElseThrow(() -> new RecursoNoEncontradoException("Cliente no encontrado con id: " + pedidoDTO.getClienteId()));
        Pedido pedido = PedidoMapper.toEntity(pedidoDTO, cliente);
        Pedido pedidoGuardado = pedidoRepository.save(pedido);

        return PedidoMapper.toDTO(pedidoGuardado);
    }

    @Override
    public List<PedidoDTO> listarPedido() {
        return pedidoRepository.findAll()
            .stream()
            .map(PedidoMapper::toDTO)
            .collect(Collectors.toList());
    }

    @Override
    public PedidoDTO buscarPedidoPorId(Long id) {
        Pedido pedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Pedido no encontrado con id: " + id));
        return PedidoMapper.toDTO(pedido);
    }

    @Override
    public void eliminarPedido(Long id) {
        Pedido pedido = pedidoRepository.findById(id)
            .orElseThrow(() -> new RecursoNoEncontradoException("Pedido no encontrado con id: " + id));
        pedidoRepository.delete(pedido);
    }

    @Override
    public List<PedidoDTO> listarPedidosPorCliente(Long clienteId) {
        return pedidoRepository.findByClienteId(clienteId)
            .stream()
            .map(PedidoMapper::toDTO)
            .collect(Collectors.toList());
    }

    @Override
    public List<PedidoDTO> listarPedidosPorClienteYEstado(Long clienteId, boolean enviado) {
        return pedidoRepository.findByClienteIdAndEnviado(clienteId, enviado)
            .stream()
            .map(PedidoMapper::toDTO)
            .collect(Collectors.toList());
    }

    
}
