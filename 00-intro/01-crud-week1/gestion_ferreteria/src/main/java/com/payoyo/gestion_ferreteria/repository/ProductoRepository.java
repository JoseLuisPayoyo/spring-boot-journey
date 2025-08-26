package com.payoyo.gestion_ferreteria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.payoyo.gestion_ferreteria.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long>{}
