package com.payoyo.gestion_ferreteria.mapper;

import org.springframework.stereotype.Component;

import com.payoyo.gestion_ferreteria.dto.CreateProductoDTO;
import com.payoyo.gestion_ferreteria.dto.ProductoResponseDTO;
import com.payoyo.gestion_ferreteria.model.Producto;
@Component
public class ProductoMapper {
    
    public Producto toEntity(CreateProductoDTO dto){
        Producto producto = new Producto();
        
        producto.setNombre(dto.getNombre());
        producto.setCategoria(dto.getCategoria());
        producto.setPrecio(dto.getPrecio());
        producto.setStock(dto.getStock());
        producto.setActivo(true);

        return producto;
    }

    public ProductoResponseDTO toDTO(Producto producto) {
        return new ProductoResponseDTO(
            producto.getId(),
            producto.getNombre(),
            producto.getCategoria(),
            producto.getPrecio(),
            producto.getStock(),
            producto.getActivo()
        );
    }
}
