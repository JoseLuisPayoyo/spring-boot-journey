package com.payoyo.peopleops_backend.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.payoyo.peopleops_backend.dto.empleado.EmpleadoCreateDTO;
import com.payoyo.peopleops_backend.dto.empleado.EmpleadoFiltroDTO;
import com.payoyo.peopleops_backend.dto.empleado.EmpleadoResponseDTO;
import com.payoyo.peopleops_backend.dto.empleado.EmpleadoUpdateDTO;
import com.payoyo.peopleops_backend.service.EmpleadoService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/empleados")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class EmpleadoController {

    private final EmpleadoService empleadoService;
    
    // crear empleado
    @PostMapping
    public ResponseEntity<EmpleadoResponseDTO> crear(@Valid @RequestBody EmpleadoCreateDTO dto){
        EmpleadoResponseDTO empleadoCreado = empleadoService.crear(dto);

        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(empleadoCreado);
    }

    // listar todos los empleados
    @GetMapping
    public ResponseEntity<List<EmpleadoResponseDTO>> listar(){
        List<EmpleadoResponseDTO> listaEmpleados = empleadoService.listar();

        return ResponseEntity.ok(listaEmpleados);
    }

    // listar empleados por id
    @GetMapping("/{id}")
    public ResponseEntity<EmpleadoResponseDTO> buscarPorId(@PathVariable Long id){
        EmpleadoResponseDTO empleado = empleadoService.buscarPorId(id);

        return ResponseEntity.ok(empleado);
    }

    // eliminar empleado por id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id){
        empleadoService.eliminar(id);

        return ResponseEntity
                .noContent()
                .build();
    }

    // actualizar empleado con su departamento
    @PutMapping("/{id}")
    public ResponseEntity<EmpleadoResponseDTO> actualizar(
        @PathVariable Long id,
        @Valid @RequestBody EmpleadoUpdateDTO dto
    ){
        EmpleadoResponseDTO empleadoActualizado = empleadoService.actualizar(id, dto);

        return ResponseEntity.ok(empleadoActualizado);
    }

    // metodo para filtrar
    @GetMapping("/filtrar")
    public ResponseEntity<Page<EmpleadoResponseDTO>> filtrar(
        EmpleadoFiltroDTO filtroDTO,
        Pageable pageable) {
        
        Page<EmpleadoResponseDTO> resultado = empleadoService.filtrar(filtroDTO, pageable);
        return ResponseEntity.ok(resultado);
    }

    
}
