package com.jose.pedidos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jose.pedidos.dto.PedidoDTO;
import com.jose.pedidos.service.PedidoService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;





@RestController
@RequestMapping("/api/pedidos")
@CrossOrigin(origins = "*")
public class PedidoController {
    
    @Autowired
    private PedidoService pedidoService;

    @PostMapping
    public ResponseEntity<PedidoDTO> guardarPedido(@Valid @RequestBody PedidoDTO pedidoDTO){
        PedidoDTO guardado = pedidoService.guardarPedido(pedidoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(guardado);
    }

    @GetMapping
    public ResponseEntity<List<PedidoDTO>> listarPedidos(){
        List<PedidoDTO> lista = pedidoService.listarPedido();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoDTO> buscarPedidoPorId(@PathVariable Long id){
        PedidoDTO pedido = pedidoService.buscarPedidoPorId(id);
        return ResponseEntity.ok(pedido);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPedido(@PathVariable Long id){
        pedidoService.eliminarPedido(id);
        return ResponseEntity.noContent().build();
    }

    //listar pedidos de cada cliente con filtro opcional por estado "enviado"
    @GetMapping("/cliente/{id}")
    public ResponseEntity<List<PedidoDTO>> listarPedidosPorCliente(
        @PathVariable Long id,
        @RequestParam(required = false) Boolean enviado){
        if (enviado != null) {
            List<PedidoDTO> listarPedidosPorEstado = pedidoService.listarPedidosPorClienteYEstado(id, enviado);
            return ResponseEntity.ok(listarPedidosPorEstado);
        }else{
            List<PedidoDTO> listaPedidos = pedidoService.listarPedidosPorCliente(id);
            return ResponseEntity.ok(listaPedidos);
        }
    
    }
    
}
