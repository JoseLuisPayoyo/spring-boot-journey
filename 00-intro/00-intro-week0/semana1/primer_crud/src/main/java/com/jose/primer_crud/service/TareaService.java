package com.jose.primer_crud.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.jose.primer_crud.model.Tarea;

@Service
public class TareaService {

    private List<Tarea> tareas = new ArrayList<>();

    public List<Tarea> listarTareas() {
        return tareas;
    }

    public Tarea crearTarea(Tarea tarea) {
        tareas.add(tarea);
        return tarea;
    }

    public void eliminarTareaPorId(Long id) {
        tareas.removeIf(t -> t.getId().equals(id));
    }

    public Tarea buscarPorId(Long id) {
        return tareas.stream()
            .filter(t -> t.getId().equals(id))
            .findFirst()
            .orElse(null);
    }

}
