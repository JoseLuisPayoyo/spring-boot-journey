package com.jose.primer_crud.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.jose.primer_crud.model.Producto;

@Service
public class ProductoService {

    private List<Producto> productos = new ArrayList<>();

    //listar productos
    public List<Producto> listarProductos(){
        return productos;
    }

    //crear producto
    public Producto crearProducto(Producto p){
        productos.add(p);
        return p;
    }

    //eliminar por id
    public void eliminarProductoPorId(Long id) {
        productos.removeIf(p -> p.getId().equals(id));
    }

    //filtrar en stock
    public List<Producto> filtrarEnStock() {
        return productos.stream()
                        .filter(p -> p.isEnStock())
                        .collect(Collectors.toList());
    }
    
}
