package com.jose.crud_en_db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jose.crud_en_db.model.Libro;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Long>{
    
}
