package com.payoyo.ejercicio2.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.payoyo.ejercicio2.dto.CreateClasesDTO;
import com.payoyo.ejercicio2.dto.ResponseClasesDTO;
import com.payoyo.ejercicio2.service.ClasesService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/clases")
@CrossOrigin(origins = "*")
public class ClasesController {
    
    private final ClasesService clasesService;
    public ClasesController(ClasesService clasesService){
        this.clasesService = clasesService;
    }

    // crear clase
    @PostMapping
    public ResponseEntity<ResponseClasesDTO> crear(@Valid @RequestBody CreateClasesDTO dto){
        ResponseClasesDTO claseCreada = clasesService.crear(dto);

        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(claseCreada);
    }

    // listar todas
    @GetMapping
    public ResponseEntity<List<ResponseClasesDTO>> listarTodas(){
        List<ResponseClasesDTO> clases = clasesService.listarTodas();

        return ResponseEntity
                .ok(clases);
    }
}
