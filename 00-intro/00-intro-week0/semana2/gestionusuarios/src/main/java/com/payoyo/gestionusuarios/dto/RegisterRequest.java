package com.payoyo.gestionusuarios.dto;

import com.payoyo.gestionusuarios.entity.Role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {
    private String nombre;
    private String email;
    private String password;
    private Role rol;
}
