import { request } from "./http";

export function fetchEmpleados() {
  return request("/empleados", { method: "GET" });
}
