package com.payoyo.peopleops_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.payoyo.peopleops_backend.model.Empleado;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long>{}
