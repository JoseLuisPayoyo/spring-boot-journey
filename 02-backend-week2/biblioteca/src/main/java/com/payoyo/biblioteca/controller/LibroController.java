package com.payoyo.biblioteca.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.payoyo.biblioteca.dto.LibroCreateDTO;
import com.payoyo.biblioteca.dto.LibroResponseDTO;
import com.payoyo.biblioteca.service.LibroService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/libros")
@CrossOrigin(origins = "*")
public class LibroController {
    
    private final LibroService libroService;
    public LibroController(LibroService libroService){
        this.libroService = libroService;
    }

    @PostMapping
    public ResponseEntity<LibroResponseDTO> crear(@Valid @RequestParam LibroCreateDTO dto){
        LibroResponseDTO libroCeado = libroService.crear(dto);

        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(libroCeado);
    }
}
