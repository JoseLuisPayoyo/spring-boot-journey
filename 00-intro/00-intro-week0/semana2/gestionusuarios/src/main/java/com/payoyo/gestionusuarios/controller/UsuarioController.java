package com.payoyo.gestionusuarios.controller;

import com.payoyo.gestionusuarios.dto.UsuarioResponseDTO;
import com.payoyo.gestionusuarios.entity.Usuario;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @GetMapping("/me")
    public UsuarioResponseDTO verPerfil(@AuthenticationPrincipal Usuario usuario) {
        return UsuarioResponseDTO.builder()
                .id(usuario.getId())
                .nombre(usuario.getNombre())
                .email(usuario.getEmail())
                .rol(usuario.getRol())
                .build();
    }

}
