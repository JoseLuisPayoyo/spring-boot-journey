package com.jose.crus_dia2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jose.crus_dia2.DTO.PedidoDTO;
import com.jose.crus_dia2.mapper.PedidoMapper;
import com.jose.crus_dia2.model.Pedido;
import com.jose.crus_dia2.service.IPedidoService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/api/pedidos")
@CrossOrigin(origins = "*")
public class PedidoController {

    @Autowired
    IPedidoService pedidoService;
    

    //listar
    @GetMapping()
    public List<PedidoDTO> listarPedidos(){
        return pedidoService.listarPedidosDTO();
    }
    
    //buscar por id
    @GetMapping("/{id}")
    public Pedido buscarPedidoPorId(@PathVariable Long id){
        return pedidoService.buscarPedidoPorId(id);
    }
    
    //crear
    @PostMapping
    public Pedido crearPedido(@Valid @RequestBody PedidoDTO pedidoDTO) {
        Pedido pedido = PedidoMapper.toEntity(pedidoDTO);
        return pedidoService.crearPedido(pedido);
    }
    
    //borrar
    @DeleteMapping("/{id}")
    public void eliminarPedido(@PathVariable Long id){
        pedidoService.eliminarPedido(id);
    }

    //editar
    @PutMapping("/editar/{id}")
    public Pedido editPedido(@PathVariable Long id, @Valid @RequestBody PedidoDTO pedidoDTO){
        return pedidoService.editarPedido(id, pedidoDTO);
    }

    
}
