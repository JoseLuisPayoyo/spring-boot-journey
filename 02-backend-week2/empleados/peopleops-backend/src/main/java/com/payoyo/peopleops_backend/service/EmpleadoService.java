package com.payoyo.peopleops_backend.service;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

import com.payoyo.peopleops_backend.dto.empleado.EmpleadoCreateDTO;
import com.payoyo.peopleops_backend.dto.empleado.EmpleadoFiltroDTO;
import com.payoyo.peopleops_backend.dto.empleado.EmpleadoResponseDTO;
import com.payoyo.peopleops_backend.dto.empleado.EmpleadoUpdateDTO;

public interface EmpleadoService {
    
    // metodos basicos
    EmpleadoResponseDTO crear(EmpleadoCreateDTO dto);

    List<EmpleadoResponseDTO> listar();

    EmpleadoResponseDTO buscarPorId(Long id);

    void eliminar(Long id);

    EmpleadoResponseDTO actualizar(Long id, EmpleadoUpdateDTO dto);

    // metodos de los filtros
    Page<EmpleadoResponseDTO> filtrar(EmpleadoFiltroDTO filtroDTO, Pageable pageable);

}
