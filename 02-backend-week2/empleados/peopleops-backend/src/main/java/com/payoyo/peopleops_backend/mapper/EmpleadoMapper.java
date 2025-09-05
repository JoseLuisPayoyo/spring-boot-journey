package com.payoyo.peopleops_backend.mapper;

import org.springframework.stereotype.Component;

import com.payoyo.peopleops_backend.dto.empleado.EmpleadoCreateDTO;
import com.payoyo.peopleops_backend.dto.empleado.EmpleadoResponseDTO;
import com.payoyo.peopleops_backend.dto.empleado.EmpleadoUpdateDTO;
import com.payoyo.peopleops_backend.model.Departamento;
import com.payoyo.peopleops_backend.model.Empleado;

@Component
public class EmpleadoMapper {
    
    // de entidad a dto
    public Empleado toEntity(EmpleadoCreateDTO dto, Departamento departamento){
        Empleado empleado = new Empleado();

        empleado.setNombre(dto.getNombre());
        empleado.setApellido(dto.getApellido());
        empleado.setEmail(dto.getEmail());
        empleado.setTelefono(dto.getTelefono());
        empleado.setEstado(dto.getEstado());
        empleado.setPuesto(dto.getPuesto());
        empleado.setSalario(dto.getSalario());
        empleado.setFechaContratacion(dto.getFechaContratacion());
        empleado.setDepartamento(departamento);

        return empleado;
    }

    // update entity
    public void updateEntity(Empleado empleado, EmpleadoUpdateDTO dto, Departamento departamento){
        empleado.setNombre(dto.getNombre());
        empleado.setApellido(dto.getApellido());
        empleado.setEmail(dto.getEmail());
        empleado.setTelefono(dto.getTelefono());
        empleado.setEstado(dto.getEstado());
        empleado.setPuesto(dto.getPuesto());
        empleado.setSalario(dto.getSalario());
        empleado.setFechaContratacion(dto.getFechaContratacion());
        empleado.setDepartamento(departamento);
    }

    // toDTO
    public EmpleadoResponseDTO toDTO(Empleado empleado){
        EmpleadoResponseDTO dto = new EmpleadoResponseDTO();

        dto.setId(empleado.getId());
        dto.setNombre(empleado.getNombre());
        dto.setApellido(empleado.getApellido());
        dto.setEmail(empleado.getEmail());
        dto.setTelefono(empleado.getTelefono());
        dto.setEstado(empleado.getEstado());
        dto.setPuesto(empleado.getPuesto());
        dto.setSalario(empleado.getSalario());
        dto.setFechaContratacion(empleado.getFechaContratacion());

        if (empleado.getDepartamento() != null) {
            dto.setDepartamentoNombre(empleado.getDepartamento().getNombre());
        }

        return dto;
    }


}
