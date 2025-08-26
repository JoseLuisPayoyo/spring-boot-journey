package payoyo.dia1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import payoyo.dia1.model.Tarea;

public interface TareaRepository extends JpaRepository<Tarea, Long>{}
