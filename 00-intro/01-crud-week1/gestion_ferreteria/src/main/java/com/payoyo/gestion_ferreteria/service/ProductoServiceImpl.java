package com.payoyo.gestion_ferreteria.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.payoyo.gestion_ferreteria.dto.CreateProductoDTO;
import com.payoyo.gestion_ferreteria.dto.ProductoResponseDTO;
import com.payoyo.gestion_ferreteria.exception.ProductoNoEncontradoException;
import com.payoyo.gestion_ferreteria.mapper.ProductoMapper;
import com.payoyo.gestion_ferreteria.model.Producto;
import com.payoyo.gestion_ferreteria.repository.ProductoRepository;

@Service
public class ProductoServiceImpl implements IProductoService{

    private final ProductoRepository productoRepository;
    private final ProductoMapper productoMapper;

    public ProductoServiceImpl(ProductoRepository productoRepository, ProductoMapper productoMapper) {
        this.productoRepository = productoRepository;
        this.productoMapper = productoMapper;
    }

    //Crear producto
    @Override
    public ProductoResponseDTO crear(CreateProductoDTO dto) {
        // cambiamos a entidad
        Producto producto = productoMapper.toEntity(dto);

        //guardamos en la db
        Producto guardado = productoRepository.save(producto);

        //devolvemos entidad
        return productoMapper.toDTO(guardado);

    }

    //Listar todos los productos
    @Override
    public List<ProductoResponseDTO> buscarTodos() {
        return productoRepository.findAll()
            .stream()
            .map(productoMapper::toDTO)
            .collect(Collectors.toList());
    }

    //Listar producto por ID
    @Override
    public ProductoResponseDTO obtenerPorId(Long id) {
        Producto producto = productoRepository.findById(id)
            .orElseThrow(() -> new ProductoNoEncontradoException(id));
        
        return productoMapper.toDTO(producto);
    }

    public ProductoResponseDTO eliminar(Long id) {
        Producto producto = productoRepository.findById(id)
            .orElseThrow(() -> new ProductoNoEncontradoException(id));

        producto.setActivo(false);
        Producto actualizado = productoRepository.save(producto);
        return productoMapper.toDTO(actualizado);
    }


    @Override
    public ProductoResponseDTO actualizar(Long id, CreateProductoDTO dto) {
        Producto productoExistente = productoRepository.findById(id)
            .orElseThrow(() -> new ProductoNoEncontradoException(id));

        productoExistente.setNombre(dto.getNombre());
        productoExistente.setCategoria(dto.getCategoria());
        productoExistente.setPrecio(dto.getPrecio());
        productoExistente.setStock(dto.getStock());

        Producto actualizado = productoRepository.save(productoExistente);
        return productoMapper.toDTO(actualizado);
    }
    
}
