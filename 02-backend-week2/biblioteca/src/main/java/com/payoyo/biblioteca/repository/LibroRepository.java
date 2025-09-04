package com.payoyo.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.payoyo.biblioteca.model.Libro;

public interface LibroRepository extends JpaRepository<Libro, Long>{}
