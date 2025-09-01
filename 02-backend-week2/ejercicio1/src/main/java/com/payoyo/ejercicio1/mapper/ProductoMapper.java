package com.payoyo.ejercicio1.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.payoyo.ejercicio1.dto.ProductoCreateDTO;
import com.payoyo.ejercicio1.dto.ProductoResponseDTO;
import com.payoyo.ejercicio1.dto.ProductoUpdateDTO;
import com.payoyo.ejercicio1.entity.Producto;

@Component
public class ProductoMapper {

    //Pasar de dto creado a entidad
    public Producto toEntity(ProductoCreateDTO dto){
        Producto producto = new Producto();

        producto.setNombre(dto.getNombre());
        producto.setPrecio(dto.getPrecio());

        return producto;
    }

    //Pasar de entidad a devolver dto
    public ProductoResponseDTO toResponseDTO(Producto producto){
        return new ProductoResponseDTO(
            producto.getId(),
            producto.getNombre(),
            producto.getPrecio()
        );
    }

    // dto para actualizar
    public void updateEntityFromDTO(Producto producto, ProductoUpdateDTO dto){
        producto.setNombre(dto.getNombre());
        producto.setPrecio(dto.getPrecio());
    }

    // dto para listar los productos
    public List<ProductoResponseDTO> toDTOList(List<Producto> productos) {
        return productos.stream()
                .map(this::toResponseDTO)
                .toList();
    }

}
