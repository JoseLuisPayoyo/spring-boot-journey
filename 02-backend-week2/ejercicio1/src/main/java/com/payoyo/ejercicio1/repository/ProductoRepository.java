package com.payoyo.ejercicio1.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.payoyo.ejercicio1.entity.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long>{
    List<Producto> findByNombreContainingIgnoreCase(String nombre);
    Page<Producto> findByNombreContainingIgnoreCase(String nombre, Pageable pageable);
}
