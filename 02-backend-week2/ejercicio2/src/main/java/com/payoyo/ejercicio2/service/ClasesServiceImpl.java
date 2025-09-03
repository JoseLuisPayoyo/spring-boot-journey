package com.payoyo.ejercicio2.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.payoyo.ejercicio2.dto.CreateClasesDTO;
import com.payoyo.ejercicio2.dto.ResponseClasesDTO;
import com.payoyo.ejercicio2.exception.ClaseNoEncontradaException;
import com.payoyo.ejercicio2.mapper.ClasesMapper;
import com.payoyo.ejercicio2.model.Clases;
import com.payoyo.ejercicio2.repository.ClasesRepository;

@Service
public class ClasesServiceImpl implements ClasesService{

    // constructor para inyectar dependencias
    private ClasesRepository clasesRepository;
    private ClasesMapper clasesMapper;
    public ClasesServiceImpl(ClasesRepository clasesRepository, ClasesMapper clasesMapper) {
        this.clasesRepository = clasesRepository;
        this.clasesMapper = clasesMapper;
    }

    // crear clase
    @Override
    public ResponseClasesDTO crear(CreateClasesDTO dto) {
        Clases clase = clasesMapper.toEntity(dto);

        Clases claseGuardada = clasesRepository.save(clase);

        return clasesMapper.toDTO(claseGuardada);
    }

    // listar todas las clases
    @Override
    public List<ResponseClasesDTO> listarTodas() {
        return clasesRepository.findAll()
                .stream()
                .map(clasesMapper::toDTO)
                .collect(Collectors.toList());
    }

    // listar clase por id
    @Override
    public ResponseClasesDTO listarPorId(Long id) {
        Clases clase = clasesRepository.findById(id)
            .orElseThrow(() -> new ClaseNoEncontradaException(id));

        return clasesMapper.toDTO(clase);    
    }

    // actualizar clase
    @Override
    public ResponseClasesDTO actualizar(Long id, CreateClasesDTO dto) {
        Clases clase = clasesRepository.findById(id)
            .orElseThrow(() -> new ClaseNoEncontradaException(id));
        
        // si existe la modificamos
        clase.setNombre_clase(dto.getNombre_clase());
        clase.setDuracion(dto.getDuracion());
        clase.setNombre_profesor(dto.getNombre_profesor());

        // guardamos en la db
        Clases claseActualizada = clasesRepository.save(clase);

        return clasesMapper.toDTO(claseActualizada);
    }

    @Override
    public void eliminar(Long id) {
        if (!clasesRepository.existsById(id)) {
            throw new ClaseNoEncontradaException(id);
        }
        clasesRepository.deleteById(id);
    }
    
}
