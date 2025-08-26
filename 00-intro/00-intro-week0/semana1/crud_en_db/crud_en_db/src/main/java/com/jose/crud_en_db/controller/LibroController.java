package com.jose.crud_en_db.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jose.crud_en_db.dto.LibroDTO;
import com.jose.crud_en_db.model.Libro;
import com.jose.crud_en_db.service.LibroService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@RequestMapping("/libros")
@CrossOrigin(origins = "*")
public class LibroController {
    
    @Autowired
    private LibroService libroService;

    //listar libros
    @GetMapping()
    public List<Libro> listarLibros(){
        return libroService.listarLibros();
    }

    //crear libro
    @PostMapping()
    public Libro crearLibro(@Valid @RequestBody LibroDTO libroDTO){
        Libro libro = new Libro();
        libro.setTitulo(libroDTO.getTitulo());
        libro.setAutor(libroDTO.getAutor());
        libro.setAnioPublicacion(libroDTO.getAnioPublicacion());
        libro.setDisponible(libroDTO.getDisponible());
        return libroService.crearLibro(libro);
    }

    //eliminar libro
    @DeleteMapping("/{id}")
    public void eliminarLibro(Long id) {
        libroService.eliminarLibroPorId(id);
    }

    //buscar por id
    @GetMapping("/{id}")
    public Libro buscarLibroPorId(@PathVariable Long id) {
        return libroService.buscarLibroPorId(id);
    }
    
    //solo disponibles
    @GetMapping("/disponible")
    public List<Libro> listarSoloDisponibles(){
        return libroService.listarSoloDisponibles();
    }
    


    
    
}
