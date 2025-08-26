package com.jose.crud_en_db.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jose.crud_en_db.model.Libro;
import com.jose.crud_en_db.repository.LibroRepository;

@Service
public class LibroService {
    
    @Autowired
    private LibroRepository libroRepository;

    //listar libros
    public List<Libro> listarLibros(){
        return libroRepository.findAll();
    }

    //crear libros
    public Libro crearLibro(Libro libro){
        return libroRepository.save(libro);
    }

    //eliminar libro
    public void eliminarLibroPorId(Long id){
        libroRepository.deleteById(id);
    }

    //buscar por id
    public Libro buscarLibroPorId(Long id) {
        return libroRepository.findById(id).orElse(null);
    }

    //solo los disponibles
    public List<Libro> listarSoloDisponibles(){
        return libroRepository.findAll()
                        .stream()
                        .filter(Libro::isDisponible)
                        .collect(Collectors.toList());
    }

}
