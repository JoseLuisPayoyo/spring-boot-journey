package payoyo.dia1.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import payoyo.dia1.model.Tarea;
import payoyo.dia1.service.ITareaService;

import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("api/tareas")
@CrossOrigin(origins = "*")
public class TareaController {

    private ITareaService tareaService;

    @PostMapping()
    public Tarea guardar(@Valid @RequestBody Tarea tarea){
        return tareaService.guardar(tarea);
    }

    @GetMapping
    public List<Tarea> listarTodas(){
        return tareaService.listarTodas();
    }

    @GetMapping("/{id}")
    public Optional<Tarea> buscarPorId(@PathVariable Long id) {
        return tareaService.buscarPorId(id);
    }
    
    

}
