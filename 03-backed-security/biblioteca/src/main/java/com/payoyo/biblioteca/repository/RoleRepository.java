package com.payoyo.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.payoyo.biblioteca.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
    
}
