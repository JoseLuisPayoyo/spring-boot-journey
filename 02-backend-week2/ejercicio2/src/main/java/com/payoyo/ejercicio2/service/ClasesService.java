package com.payoyo.ejercicio2.service;

import java.util.List;

import com.payoyo.ejercicio2.dto.CreateClasesDTO;
import com.payoyo.ejercicio2.dto.ResponseClasesDTO;

public interface ClasesService {
    
    // crear clase
    ResponseClasesDTO crear(CreateClasesDTO dto);

    // listar todas las clases
    List<ResponseClasesDTO> listarTodas();

    // listar por id
    ResponseClasesDTO listarPorId(Long id);

    // actualizar clase
    ResponseClasesDTO actualizar(Long id, CreateClasesDTO dto);

    // eliminar clase
    void eliminar(Long id);

}
