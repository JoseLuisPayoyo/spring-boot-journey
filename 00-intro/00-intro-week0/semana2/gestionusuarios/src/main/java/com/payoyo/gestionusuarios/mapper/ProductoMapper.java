package com.payoyo.gestionusuarios.mapper;

import com.payoyo.gestionusuarios.dto.ProductoRequestDTO;
import com.payoyo.gestionusuarios.dto.ProductoResponseDTO;
import com.payoyo.gestionusuarios.entity.Producto;

public class ProductoMapper {

    public static Producto toEntity(ProductoRequestDTO dto) {
        return Producto.builder()
                .nombre(dto.getNombre())
                .descripcion(dto.getDescripcion())
                .precio(dto.getPrecio())
                .build();
    }

    public static ProductoResponseDTO toDto(Producto producto) {
        return ProductoResponseDTO.builder()
                .id(producto.getId())
                .nombre(producto.getNombre())
                .descripcion(producto.getDescripcion())
                .precio(producto.getPrecio())
                .build();
    }
}

