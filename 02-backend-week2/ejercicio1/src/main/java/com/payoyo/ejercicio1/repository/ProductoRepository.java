package com.payoyo.ejercicio1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.payoyo.ejercicio1.entity.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long>{}
