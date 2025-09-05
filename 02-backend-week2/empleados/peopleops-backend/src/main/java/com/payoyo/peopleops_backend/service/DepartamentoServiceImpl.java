package com.payoyo.peopleops_backend.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.payoyo.peopleops_backend.dto.departamento.DepartamentoCreateDTO;
import com.payoyo.peopleops_backend.dto.departamento.DepartamentoResponseDTO;
import com.payoyo.peopleops_backend.dto.departamento.DepartamentoUpdateDTO;
import com.payoyo.peopleops_backend.exception.DepartamentoNoEncontradoException;
import com.payoyo.peopleops_backend.mapper.DepartamentoMapper;
import com.payoyo.peopleops_backend.model.Departamento;
import com.payoyo.peopleops_backend.repository.DepartamentoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DepartamentoServiceImpl implements DepartamentoService{
    
    private final DepartamentoRepository departamentoRepository;
    private final DepartamentoMapper departamentoMapper;


    @Override
    public DepartamentoResponseDTO crear(DepartamentoCreateDTO dto) {
        Departamento departamento = departamentoMapper.toEntity(dto);

        Departamento departamentoGuardado = departamentoRepository.save(departamento);

        return departamentoMapper.toDTO(departamentoGuardado);
    }

    @Override
    public DepartamentoResponseDTO actualizar(Long id, DepartamentoUpdateDTO dto) {
        Departamento departamento = departamentoRepository.findById(id)
            .orElseThrow(() -> new DepartamentoNoEncontradoException(id));
        
        departamento.setNombre(dto.getNombre());
        departamento.setCodigo(dto.getCodigo());
        departamento.setPresupuestoAnual(dto.getPresupuestoAnual());
        
        Departamento deparatamentoActualizado = departamentoRepository.save(departamento);

        return departamentoMapper.toDTO(deparatamentoActualizado);
    }

    @Override
    public List<DepartamentoResponseDTO> listar() {
        return departamentoRepository.findAll()
            .stream()
            .map(departamentoMapper::toDTO)
            .collect(Collectors.toList());
    }

    @Override
    public DepartamentoResponseDTO buscarPorId(Long id) {
        Departamento departamento = departamentoRepository.findById(id)
            .orElseThrow(() -> new DepartamentoNoEncontradoException(id));
        
        return departamentoMapper.toDTO(departamento);
    }

    @Override
    public void eliminar(Long id) {
        if (!departamentoRepository.existsById(id)) {
            throw new DepartamentoNoEncontradoException(id);
        }
        departamentoRepository.deleteById(id);
    }
    
}
