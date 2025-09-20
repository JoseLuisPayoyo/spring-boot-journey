package com.payoyo.biblioteca.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.payoyo.biblioteca.model.Libro;

public interface LibroRepository extends JpaRepository<Libro, Long>{

    Page<Libro> findByTituloContainingIgnoreCase(String titulo, Pageable pageable);

    Page<Libro> findByAutorId(Long autorId, Pageable pageable);

    Page<Libro> findByTituloContainingIgnoreCaseAndAutorId(String titulo, Long autorId, Pageable pageble);
}
