package com.payoyo.gestionusuarios.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.payoyo.gestionusuarios.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    Optional<Usuario> findByEmail(String email);
}