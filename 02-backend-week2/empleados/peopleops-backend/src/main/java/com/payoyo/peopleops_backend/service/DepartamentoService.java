package com.payoyo.peopleops_backend.service;

import java.util.List;

import com.payoyo.peopleops_backend.dto.departamento.DepartamentoCreateDTO;
import com.payoyo.peopleops_backend.dto.departamento.DepartamentoResponseDTO;
import com.payoyo.peopleops_backend.dto.departamento.DepartamentoUpdateDTO;

public interface DepartamentoService {

    DepartamentoResponseDTO crear(DepartamentoCreateDTO dto);

    DepartamentoResponseDTO actualizar(Long id, DepartamentoUpdateDTO dto);

    List<DepartamentoResponseDTO> listar();

    DepartamentoResponseDTO buscarPorId(Long id);

    void eliminar(Long id);
}
