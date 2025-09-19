package com.payoyo.peopleops_backend.specification;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.criteria.Predicate;

import org.springframework.data.jpa.domain.Specification;

import com.payoyo.peopleops_backend.dto.empleado.EmpleadoFiltroDTO;
import com.payoyo.peopleops_backend.model.Empleado;

public class EmpleadoSpecification {

    public static Specification<Empleado> filtrar(EmpleadoFiltroDTO filtro){
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            // nombre (LIKE)
            if (filtro.getNombre() != null && !filtro.getNombre().isBlank()) {
                predicates.add(
                    criteriaBuilder.like(
                        criteriaBuilder.lower(root.get("nombre")),
                        "%" + filtro.getNombre().toLowerCase() + "%"
                    )
                );
            }

            // Apellidos (LIKE)
            if (filtro.getApellidos() != null && !filtro.getApellidos().isBlank()) {
                predicates.add(
                    criteriaBuilder.like(
                        criteriaBuilder.lower(root.get("apellidos")),
                        "%" + filtro.getApellidos().toLowerCase() + "%"
                    )
                );
            }

            // Departamento
            if (filtro.getDepartamentoId() != null) {
                predicates.add(
                    criteriaBuilder.equal(root.get("departamento").get("id"), filtro.getDepartamentoId())
                );
            }

            // Estado
            if (filtro.getEstado() != null) {
                predicates.add(
                    criteriaBuilder.equal(root.get("estado"), filtro.getEstado())
                );
            }

            // Salario mínimo
            if (filtro.getSalarioMin() != null) {
                predicates.add(
                    criteriaBuilder.greaterThanOrEqualTo(root.get("salario"), filtro.getSalarioMin())
                );
            }

            // Salario máximo
            if (filtro.getSalarioMax() != null) {
                predicates.add(
                    criteriaBuilder.lessThanOrEqualTo(root.get("salario"), filtro.getSalarioMax())
                );
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
    
}
