package com.payoyo.gestion_cursos.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.payoyo.gestion_cursos.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    Optional<Usuario> findByEmail(String email);
}
