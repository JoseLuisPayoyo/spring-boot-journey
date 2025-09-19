import { request } from "./http";

export function fetchDepartamentos() {
  return request("/departamentos", { method: "GET" });
}

export function crearDepartamento(body) {
  return request("/departamentos", {
    method: "POST",
    body,
  });
}

export function actualizarDepartamento(id, body) {
  return request(`/departamentos/${id}`, {
    method: "PUT",
    body,
  });
}

export function eliminarDepartamento(id) {
  return request(`/departamentos/${id}`, {
    method: "DELETE",
  });
}
