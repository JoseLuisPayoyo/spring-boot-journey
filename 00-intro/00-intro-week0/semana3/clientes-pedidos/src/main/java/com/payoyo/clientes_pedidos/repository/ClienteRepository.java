package com.payoyo.clientes_pedidos.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import com.payoyo.clientes_pedidos.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{
    @EntityGraph(attributePaths = "pedidos")
    Optional<Cliente> findWithPedidosById(Long id);
} 
