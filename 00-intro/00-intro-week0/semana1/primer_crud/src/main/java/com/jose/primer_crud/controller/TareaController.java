package com.jose.primer_crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jose.primer_crud.model.Tarea;
import com.jose.primer_crud.service.TareaService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;





@RestController
@RequestMapping("/tareas")
@CrossOrigin(origins = "*")
public class TareaController {
    
    @Autowired
    private TareaService tareaService;

    @GetMapping()
    public List<Tarea> obtenerTareas() {
        return tareaService.listarTareas();
    }

    @PostMapping()
    public Tarea crearTarea(@RequestBody Tarea tarea) {
        return tareaService.crearTarea(tarea);
    }

    @DeleteMapping("/{id}")
    public void eliminarTarea(@PathVariable Long id){
        tareaService.eliminarTareaPorId(id);
    }
    
}
