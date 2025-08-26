package com.payoyo.gestionusuarios.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.payoyo.gestionusuarios.entity.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long>{}
