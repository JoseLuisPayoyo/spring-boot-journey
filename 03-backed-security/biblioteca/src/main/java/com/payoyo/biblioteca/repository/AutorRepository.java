package com.payoyo.biblioteca.repository;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.payoyo.biblioteca.model.Autor;

public interface AutorRepository extends JpaRepository<Autor, Long>{

    Page<Autor> findByNombreContainingIgnoreCase(String nombre, Pageable pageable);

    Page<Autor> findByPaisIgnoreCase(String pais, Pageable pageable);

    Page<Autor> findByNombreContainingIgnoreCaseAndPaisIgnoreCase(String nombre, String pais, Pageable pageable);

}
