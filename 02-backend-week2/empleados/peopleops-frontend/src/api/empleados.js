import { request } from "./http";

export function fetchEmpleadosConFiltros(filtros = {}, page = 0, size = 10) {
  return request(`/empleados/filtrar`, {
    method: "GET",
    params: { ...filtros, page, size, sort: "id,desc" },
  });
}

export function crearEmpleadoAPI(data) {
  return request("/empleados", {
    method: "POST",
    body: data,
  });
}

export function eliminarEmpleadoAPI(id) {
  return request(`/empleados/${id}`, {
    method: "DELETE",
  });
}
