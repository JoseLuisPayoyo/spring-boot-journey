package com.payoyo.peopleops_backend.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.payoyo.peopleops_backend.dto.empleado.EmpleadoCreateDTO;
import com.payoyo.peopleops_backend.dto.empleado.EmpleadoFiltroDTO;
import com.payoyo.peopleops_backend.dto.empleado.EmpleadoResponseDTO;
import com.payoyo.peopleops_backend.dto.empleado.EmpleadoUpdateDTO;
import com.payoyo.peopleops_backend.exception.DepartamentoNoEncontradoException;
import com.payoyo.peopleops_backend.exception.EmpleadoNoEncontradoException;
import com.payoyo.peopleops_backend.mapper.EmpleadoMapper;
import com.payoyo.peopleops_backend.model.Departamento;
import com.payoyo.peopleops_backend.model.Empleado;
import com.payoyo.peopleops_backend.repository.DepartamentoRepository;
import com.payoyo.peopleops_backend.repository.EmpleadoRepository;
import com.payoyo.peopleops_backend.specification.EmpleadoSpecification;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmpleadoServiceImpl implements EmpleadoService{

    private final EmpleadoRepository empleadoRepository; 
    private final EmpleadoMapper empleadoMapper;
    private final DepartamentoRepository departamentoRepository;

    /* --- MÉTODOS DEL CRUD BÁSICO --- */
    @Override
    public EmpleadoResponseDTO crear(EmpleadoCreateDTO dto) {
        Departamento departamento = departamentoRepository.findById(dto.getDepartamentoId())
            .orElseThrow(() -> new DepartamentoNoEncontradoException(dto.getDepartamentoId()));

        Empleado empleado = empleadoMapper.toEntity(dto, departamento);
        
        Empleado empleadoGuardado = empleadoRepository.save(empleado);

        return empleadoMapper.toDTO(empleadoGuardado);
    }

    @Override
    public List<EmpleadoResponseDTO> listar() {
        return empleadoRepository.findAll()
            .stream()
            .map(empleadoMapper::toDTO)
            .collect(Collectors.toList());
    }

    @Override
    public EmpleadoResponseDTO buscarPorId(Long id) {
        Empleado empleado = empleadoRepository.findById(id)
            .orElseThrow(() -> new EmpleadoNoEncontradoException(id));
        
        return empleadoMapper.toDTO(empleado);
    }

    @Override
    public void eliminar(Long id) {
        if (!empleadoRepository.existsById(id)) {
            throw new EmpleadoNoEncontradoException(id);
        }  
        empleadoRepository.deleteById(id);
    }

    @Override
    public EmpleadoResponseDTO actualizar(Long id, EmpleadoUpdateDTO dto) {
        Empleado empleado = empleadoRepository.findById(id)
            .orElseThrow(() -> new EmpleadoNoEncontradoException(id));
        
        Departamento departamento = departamentoRepository.findByNombre(dto.getDepartamentoNombre())
            .orElseThrow(() -> new DepartamentoNoEncontradoException(dto.getDepartamentoNombre()));
        
        empleadoMapper.updateEntity(empleado, dto, departamento);
        Empleado empleadoGuardado = empleadoRepository.save(empleado);
        
        return empleadoMapper.toDTO(empleadoGuardado);
    }

    /* --- METODOS DEL FILTRO --- */
    @Override
    public Page<EmpleadoResponseDTO> filtrar(EmpleadoFiltroDTO filtroDTO, Pageable pageable) {
        Specification<Empleado> spec = EmpleadoSpecification.filtrar(filtroDTO);

        Page<Empleado> paginaEmpleados = empleadoRepository.findAll(spec, pageable);

        return paginaEmpleados.map(empleadoMapper::toDTO);
    }

}
