package com.jose.pedidos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jose.pedidos.dto.ClienteDTO;
import com.jose.pedidos.service.IClienteService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/api/clientes")
@CrossOrigin(origins = "*")
public class ClienteController {

    @Autowired
    private IClienteService clienteService;

    //crear cliente
    @PostMapping
    public ResponseEntity<ClienteDTO> guardarCliente(@Valid @RequestBody ClienteDTO clienteDTO) {
        ClienteDTO guardado = clienteService.guardarCliente(clienteDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(guardado);
    }


    //listar todos los clientes
    @GetMapping
    public ResponseEntity<List<ClienteDTO>> listarClientes() {
        List<ClienteDTO> lista = clienteService.listarClientes();
        return ResponseEntity.ok(lista);
    }


    //buscar cliente por id
    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> buscarClientePorId(@PathVariable Long id){
        ClienteDTO cliente = clienteService.buscarClientePorId(id);
        return ResponseEntity.ok(cliente);
    }

    //eliminar cliente
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCliente(@PathVariable Long id){
        clienteService.eliminarCliente(id);
        return ResponseEntity.noContent().build();
    }
    
}
