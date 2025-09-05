package com.payoyo.peopleops_backend.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.payoyo.peopleops_backend.dto.departamento.DepartamentoCreateDTO;
import com.payoyo.peopleops_backend.dto.departamento.DepartamentoResponseDTO;
import com.payoyo.peopleops_backend.dto.departamento.DepartamentoUpdateDTO;
import com.payoyo.peopleops_backend.service.DepartamentoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/departamentos")
@CrossOrigin(origins = "*")
public class DepartamentoController {
    
    private final DepartamentoService departamentoService;
    public DepartamentoController(DepartamentoService departamentoService){
        this.departamentoService = departamentoService;
    }

    // crear
    @PostMapping
    public ResponseEntity<DepartamentoResponseDTO> crear(@Valid @RequestBody DepartamentoCreateDTO dto){
        DepartamentoResponseDTO departamentoCreado = departamentoService.crear(dto);

        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(departamentoCreado);
    }

    // actualizar
    @PutMapping("/{id}")
    public ResponseEntity<DepartamentoResponseDTO> actualizar(
        @PathVariable Long id, 
        @Valid @RequestBody DepartamentoUpdateDTO dto)
    {
        DepartamentoResponseDTO departamentoActualizado = departamentoService.actualizar(id, dto);

        return ResponseEntity.ok(departamentoActualizado);
    }

    // listar todos
    @GetMapping
    public ResponseEntity<List<DepartamentoResponseDTO>> listar(){
        List<DepartamentoResponseDTO> listaDepartamentos = departamentoService.listar();

        return ResponseEntity.ok(listaDepartamentos);
    }

    // listar por id
    @GetMapping("/{id}")
    public ResponseEntity<DepartamentoResponseDTO> buscarPorId(@PathVariable Long id){
        DepartamentoResponseDTO buscarDepartamentoId = departamentoService.buscarPorId(id);

        return ResponseEntity.ok(buscarDepartamentoId);
    }

    // eliminar por id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id){
        departamentoService.eliminar(id);

        return ResponseEntity   
            .noContent()
            .build();
    }
}
