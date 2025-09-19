import { request } from "./http";

// Obtener todos los departamentos
export function fetchDepartamentos() {
  return request("/departamentos", { method: "GET" });
}

// Crear nuevo departamento
export function crearDepartamento(departamento) {
  return request("/departamentos", {
    method: "POST",
    body: departamento,
  });
}
