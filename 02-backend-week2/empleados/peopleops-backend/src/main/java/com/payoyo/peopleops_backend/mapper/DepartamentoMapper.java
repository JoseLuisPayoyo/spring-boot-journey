package com.payoyo.peopleops_backend.mapper;


import com.payoyo.peopleops_backend.dto.departamento.DepartamentoCreateDTO;
import com.payoyo.peopleops_backend.dto.departamento.DepartamentoResponseDTO;
import com.payoyo.peopleops_backend.dto.departamento.DepartamentoUpdateDTO;
import com.payoyo.peopleops_backend.model.Departamento;


public class DepartamentoMapper {

    // de entidad a dto
    public static Departamento toEntity(DepartamentoCreateDTO dto){
        Departamento departamento = new Departamento();

        departamento.setNombre(dto.getNombre());
        departamento.setCodigo(dto.getCodigo());
        departamento.setPresupuestoAnual(dto.getPresupuestoAnual());
        departamento.setActivo(true); // por defecto al crear

        return departamento;
    }

    // actualizar dto
    public static void updateEntity(Departamento entity, DepartamentoUpdateDTO dto){
        entity.setNombre(dto.getNombre());
        entity.setCodigo(dto.getCodigo());
        entity.setPresupuestoAnual(dto.getPresupuestoAnual());
    }

    // de dto a entidad
    public static DepartamentoResponseDTO toDTO(Departamento departamento){
        DepartamentoResponseDTO dto = new DepartamentoResponseDTO();
        dto.setId(departamento.getId());
        dto.setNombre(departamento.getNombre());
        dto.setCodigo(departamento.getCodigo());
        dto.setPresupuestoAnual(departamento.getPresupuestoAnual());
        dto.setActivo(departamento.isActivo());
        return dto;
    }
    
}
