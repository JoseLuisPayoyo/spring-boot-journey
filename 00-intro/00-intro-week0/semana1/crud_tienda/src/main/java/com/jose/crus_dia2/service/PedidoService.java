package com.jose.crus_dia2.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jose.crus_dia2.DTO.PedidoDTO;
import com.jose.crus_dia2.exception.RecursoNoEncontradoException;
import com.jose.crus_dia2.mapper.PedidoMapper;
import com.jose.crus_dia2.model.Cliente;
import com.jose.crus_dia2.model.Pedido;
import com.jose.crus_dia2.repository.PedidoRepository;


@Service
public class PedidoService implements IPedidoService{

    @Autowired
    private PedidoRepository pedidoRepository;

    @Override
    public List<Pedido> listarPedidos() {
        return pedidoRepository.findAll();
    }

    @Override
    public Pedido buscarPedidoPorId(Long id) {
        return pedidoRepository.findById(id).orElse(null);
    }

    @Override
    public Pedido crearPedido(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    @Override
    public void eliminarPedido(Long id) {
        pedidoRepository.findById(id)
                        .orElseThrow(() -> new RecursoNoEncontradoException("Pedido no encontrado con id: " + id));
        pedidoRepository.deleteById(id);
    }

    @Override
    public Pedido editarPedido(Long id, PedidoDTO pedidoDTO) {
        // 1. Verificar que el pedido existe
        Pedido pedidoExistente = pedidoRepository.findById(id)
            .orElseThrow(() -> new RecursoNoEncontradoException("Pedido no encontrado con id: " + id));

        // 2. Crear cliente con ID y actualizar campos
        Cliente cliente = new Cliente();
        cliente.setId(pedidoDTO.getClienteId());

        pedidoExistente.setCliente(cliente);
        pedidoExistente.setFecha(pedidoDTO.getFecha());
        pedidoExistente.setTotal(pedidoDTO.getTotal());
        pedidoExistente.setEstado(pedidoDTO.getEstado());

        // 3. Guardar cambios
        return pedidoRepository.save(pedidoExistente);
    }

    @Override
    public List<PedidoDTO> listarPedidosDTO() {
        return pedidoRepository.findAll()
            .stream()
            .map(PedidoMapper::toDTO)
            .collect(Collectors.toList());
    }



    
}
