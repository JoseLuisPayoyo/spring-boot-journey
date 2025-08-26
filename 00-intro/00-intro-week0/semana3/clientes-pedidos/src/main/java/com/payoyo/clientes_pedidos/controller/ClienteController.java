package com.payoyo.clientes_pedidos.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.payoyo.clientes_pedidos.dto.ClienteDTO;
import com.payoyo.clientes_pedidos.dto.PedidoDTO;
import com.payoyo.clientes_pedidos.service.IClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    
    @Autowired
    private IClienteService clienteService;

    @PostMapping
    public ResponseEntity<ClienteDTO> crear(@RequestBody ClienteDTO clienteDTO){
        ClienteDTO creado = clienteService.crearCliente(clienteDTO);
        return ResponseEntity.ok(creado);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> obtener(@PathVariable Long id) {
        Optional<ClienteDTO> cliente = clienteService.obtenerCliente(id);
        return cliente.map(ResponseEntity::ok)
                      .orElse(ResponseEntity.notFound().build());
    }

    //agregar pedidos a un cliente existente
    @PostMapping("/{id}/pedidos")
    public ResponseEntity<PedidoDTO> agregarPedidos(@PathVariable Long id, @RequestBody PedidoDTO pedidoDTO){
        PedidoDTO creado = clienteService.agregarPedido(id, pedidoDTO);
        return ResponseEntity.ok(creado);
    }

    //listar pedidos de un cliente
    @GetMapping("/{id}/pedidos")
    public ResponseEntity<List<PedidoDTO>> obtenerPedidos(@PathVariable Long id) {
        List<PedidoDTO> pedidos = clienteService.obtenerPedidosDeCliente(id);
        return ResponseEntity.ok(pedidos);
    }

    //eliminar pedido por cliente
    @DeleteMapping("/{clienteId}/pedidos/{pedidoId}")
    public ResponseEntity<Void> eliminarPedido(
        @PathVariable Long clienteId,
        @PathVariable Long pedidoId
    ){
        clienteService.eliminarPedidoDeCliente(clienteId, pedidoId);
        return ResponseEntity.noContent().build();
    }

}
