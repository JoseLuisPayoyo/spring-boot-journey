package com.payoyo.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.payoyo.biblioteca.model.Autor;

public interface AutorRepository extends JpaRepository<Autor, Long>{}
