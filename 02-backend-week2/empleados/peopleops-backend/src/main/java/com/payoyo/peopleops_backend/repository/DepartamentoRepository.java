package com.payoyo.peopleops_backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.payoyo.peopleops_backend.model.Departamento;

public interface DepartamentoRepository extends JpaRepository<Departamento, Long>{
    Optional<Departamento> findByNombre(String nombre);
}
