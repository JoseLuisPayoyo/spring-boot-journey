package com.jose.primer_crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jose.primer_crud.model.Nota;
import com.jose.primer_crud.service.NotaService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/notas")
public class NotaController {

    @Autowired
    private NotaService notaService;

    @GetMapping()
    public List<Nota> listarNotas(){
        return notaService.listarNotas();
    }

    @PostMapping()
    public Nota crearNota(@RequestBody Nota nota) {
        return notaService.crearNota(nota);
    }

    @DeleteMapping("/{id}")
    public void eliminarNota(@PathVariable Long id){
        notaService.eliminarNotaPorId(id);
    }
    
}
