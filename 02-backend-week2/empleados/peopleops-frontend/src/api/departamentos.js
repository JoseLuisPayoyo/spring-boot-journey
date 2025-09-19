import { request } from "./http";

export function fetchDepartamentos() {
  return request("/departamentos", { method: "GET" });
}
