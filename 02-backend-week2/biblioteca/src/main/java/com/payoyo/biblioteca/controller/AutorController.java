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
import org.springframework.web.bind.annotation.RestController;

import com.payoyo.biblioteca.dto.AutorCreateDTO;
import com.payoyo.biblioteca.dto.AutorResponseDTO;
import com.payoyo.biblioteca.service.AutorService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/autor")
@CrossOrigin(origins = "*")
public class AutorController {
    
    private final AutorService autorService;
    public AutorController(AutorService autorService){
        this.autorService = autorService;
    }

    @PostMapping
    public ResponseEntity<AutorResponseDTO> crear(@Valid @RequestBody AutorCreateDTO dto){
        AutorResponseDTO autorCreado = autorService.crear(dto);

        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(autorCreado);
    }

    @GetMapping
    public ResponseEntity<Page<AutorResponseDTO>> listar(Pageable pageable){
        Page<AutorResponseDTO> pagina = autorService.listar(pageable);

        return ResponseEntity.ok(pagina);
    }
}
