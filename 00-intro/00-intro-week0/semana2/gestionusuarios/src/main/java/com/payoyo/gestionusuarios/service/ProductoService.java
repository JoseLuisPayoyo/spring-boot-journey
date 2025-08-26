package com.payoyo.gestionusuarios.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payoyo.gestionusuarios.dto.ProductoRequestDTO;
import com.payoyo.gestionusuarios.dto.ProductoResponseDTO;
import com.payoyo.gestionusuarios.entity.Producto;
import com.payoyo.gestionusuarios.exception.RecursoNoEncontradoException;
import com.payoyo.gestionusuarios.mapper.ProductoMapper;
import com.payoyo.gestionusuarios.repository.ProductoRepository;

@Service
public class ProductoService implements IProductoService{

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public ProductoResponseDTO crearProducto(ProductoRequestDTO request) {
        //pasar a entidad
        Producto producto = ProductoMapper.toEntity(request);

        //guardamos en db
        Producto productoGuardado = productoRepository.save(producto);

        //devolvemos el dto
        return ProductoMapper.toDto(productoGuardado);
    }

    @Override
    public List<ProductoResponseDTO> listarProductos() {
        return productoRepository.findAll()
            .stream()
            .map(ProductoMapper::toDto)
            .collect(Collectors.toList());
    }

    @Override
    public ProductoResponseDTO obtenerProducto(Long id) {
        //buscamos
        Producto producto = productoRepository.findById(id)
            .orElseThrow(() -> new RecursoNoEncontradoException("Producto no encontrado con id: " + id));
        return ProductoMapper.toDto(producto);
    }

    @Override
    public ProductoResponseDTO actualizarProducto(Long id, ProductoRequestDTO request) {
        //buscamos el producto
        Producto producto = productoRepository.findById(id)
            .orElseThrow(() -> new RecursoNoEncontradoException("Producto no encontrado con id: " + id));

        producto.setNombre(request.getNombre());
        producto.setDescripcion(request.getDescripcion());
        producto.setPrecio(request.getPrecio());
        
        Producto productoActualizado = productoRepository.save(producto);

        return ProductoMapper.toDto(productoActualizado);
    }

    @Override
    public void eliminarProducto(Long id) {
        productoRepository.findById(id)
            .orElseThrow(() -> new RecursoNoEncontradoException("Producto no encontrado con id: " + id));
        productoRepository.deleteById(id);
    }
    
}
