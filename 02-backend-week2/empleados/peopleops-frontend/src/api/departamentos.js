import { request } from "./http";

export function fetchDepartamentos() {
  return request("/departamentos", { method: "GET" });
}

export function crearDepartamento(data) {
  return request("/departamentos", {
    method: "POST",
    body: data,
  });
}

