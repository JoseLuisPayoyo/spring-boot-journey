package com.payoyo.gestion_ferreteria.dto;

public record ProductoResponseDTO(
    Long id,
    String nombre,
    String categoria,
    Double precio,
    Integer stock,
    Boolean activo
) {}
