import { useEffect, useState } from "react";
import { fetchDepartamentos } from "../api/departamentos";

export default function DepartamentosPage() {
  const [departamentos, setDepartamentos] = useState([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    fetchDepartamentos()
      .then(setDepartamentos)
      .catch((err) => {
        console.error("Error al cargar departamentos:", err);
        alert("Error al cargar los departamentos");
      })
      .finally(() => setLoading(false));
  }, []);

  return (
    <div className="p-6">
      <h1 className="text-2xl font-bold mb-4">Departamentos</h1>
      {loading ? (
        <p>Cargando...</p>
      ) : (
        <table className="min-w-full border">
          <thead>
            <tr className="bg-gray-100">
              <th className="border px-4 py-2">ID</th>
              <th className="border px-4 py-2">Nombre</th>
              <th className="border px-4 py-2">Código</th>
              <th className="border px-4 py-2">Presupuesto</th>
              <th className="border px-4 py-2">Activo</th>
            </tr>
          </thead>
          <tbody>
            {departamentos.map((d) => (
              <tr key={d.id}>
                <td className="border px-4 py-2">{d.id}</td>
                <td className="border px-4 py-2">{d.nombre}</td>
                <td className="border px-4 py-2">{d.codigo}</td>
                <td className="border px-4 py-2">{d.presupuestoAnual} €</td>
                <td className="border px-4 py-2">{d.activo ? "Sí" : "No"}</td>
              </tr>
            ))}
          </tbody>
        </table>
      )}
    </div>
  );
}
