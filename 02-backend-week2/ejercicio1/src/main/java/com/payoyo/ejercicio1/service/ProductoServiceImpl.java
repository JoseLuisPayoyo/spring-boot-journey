package com.payoyo.ejercicio1.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.payoyo.ejercicio1.dto.ProductoCreateDTO;
import com.payoyo.ejercicio1.dto.ProductoResponseDTO;
import com.payoyo.ejercicio1.dto.ProductoUpdateDTO;
import com.payoyo.ejercicio1.entity.Producto;
import com.payoyo.ejercicio1.exception.ProductoNoEncontradoException;
import com.payoyo.ejercicio1.mapper.ProductoMapper;
import com.payoyo.ejercicio1.repository.ProductoRepository;

@Service
@Transactional
public class ProductoServiceImpl implements ProductoService{

    private final ProductoRepository productoRepository;
    private final ProductoMapper productoMapper;

    public ProductoServiceImpl(ProductoRepository productoRepository, ProductoMapper productoMapper) {
        this.productoRepository = productoRepository;
        this.productoMapper = productoMapper;
    }

    @Override
    public ProductoResponseDTO crear(ProductoCreateDTO dto) {

        //Cambiamos a entidad
        Producto producto = productoMapper.toEntity(dto);

        //guardamos en la db
        Producto productoGuardado = productoRepository.save(producto);

        //devolvemos entidad
        return productoMapper.toResponseDTO(productoGuardado);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductoResponseDTO> buscarTodos() {
        
        return productoRepository.findAll()
                .stream()
                .map(productoMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public ProductoResponseDTO buscarPorId(Long id) {
        
        Producto producto = productoRepository.findById(id)
            .orElseThrow(() -> new ProductoNoEncontradoException(id));

        return productoMapper.toResponseDTO(producto);
    }

    @Override
    public void eliminar(Long id) {
        if (!productoRepository.existsById(id)) {
            throw new ProductoNoEncontradoException(id);
        }
        productoRepository.deleteById(id);
    }

    @Override
    public ProductoResponseDTO actualizar(Long id, ProductoUpdateDTO dto) {
        Producto productoExistente = productoRepository.findById(id)
            .orElseThrow(() -> new ProductoNoEncontradoException(id));

        productoExistente.setNombre(dto.getNombre());
        productoExistente.setPrecio(dto.getPrecio());

        Producto actualizado = productoRepository.save(productoExistente);
        return productoMapper.toResponseDTO(actualizado);
    }

    @Override
    public Page<ProductoResponseDTO> findAll(Pageable pageable) {
        return productoRepository.findAll(pageable)
                .map(productoMapper::toResponseDTO);
    }
    
}
