package com.payoyo.peopleops_backend.service;

import java.util.List;

import com.payoyo.peopleops_backend.dto.empleado.EmpleadoCreateDTO;
import com.payoyo.peopleops_backend.dto.empleado.EmpleadoResponseDTO;
import com.payoyo.peopleops_backend.dto.empleado.EmpleadoUpdateDTO;

public interface EmpleadoService {
    
    EmpleadoResponseDTO crear(EmpleadoCreateDTO dto);

    List<EmpleadoResponseDTO> listar();

    EmpleadoResponseDTO buscarPorId(Long id);

    void eliminar(Long id);

    EmpleadoResponseDTO actualizar(Long id, EmpleadoUpdateDTO dto);
}
