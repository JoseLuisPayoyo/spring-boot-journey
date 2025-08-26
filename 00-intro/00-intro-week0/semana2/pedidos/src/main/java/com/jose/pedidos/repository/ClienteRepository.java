package com.jose.pedidos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jose.pedidos.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{}
