package com.payoyo.biblioteca.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    public ResponseEntity<LibroResponseDTO> crear(@Valid @RequestBody LibroCreateDTO dto){
        LibroResponseDTO libroCeado = libroService.crear(dto);

        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(libroCeado);
    }

    @GetMapping
    public ResponseEntity<Page<LibroResponseDTO>> listar(Pageable pageable){
        Page<LibroResponseDTO> pagina = libroService.listar(pageable);

        return ResponseEntity.ok(pagina);
    }

    @GetMapping("/buscar")
    public ResponseEntity<Page<LibroResponseDTO>> buscar(
        @RequestParam(required = false) String titulo,
        @RequestParam(required = false) Long autorId,
        Pageable pageable)
    {
        Page<LibroResponseDTO> resultado = libroService.buscar(titulo, autorId, pageable);

        return ResponseEntity.ok(resultado);
    }
}
