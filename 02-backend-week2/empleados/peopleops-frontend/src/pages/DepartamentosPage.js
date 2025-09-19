import { useEffect, useState } from "react";
import { fetchDepartamentos } from "../api/departamentos";
import { fetchDepartamentos, crearDepartamento } from "../api/departamentos";

export default function DepartamentosPage() {
  const [departamentos, setDepartamentos] = useState([]);
  const [loading, setLoading] = useState(true);

  const [nuevoDepartamento, setNuevoDepartamento] = useState({
    nombre: "",
    codigo: "",
    presupuestoAnual: "",
  });

  useEffect(() => {
    fetchDepartamentos()
      .then(setDepartamentos)
      .catch((err) => {
        console.error("Error al cargar departamentos:", err);
        alert("Error al cargar los departamentos");
      })
      .finally(() => setLoading(false));
  }, []);

  function handleChange(e) {
    const { name, value } = e.target;
    setNuevoDepartamento((prev) => ({
      ...prev,
      [name]: value,
    }));
  }

  function handleSubmit(e) {
    e.preventDefault();

    crearDepartamento(nuevoDepartamento)
        .then((departamentoCreado) => {
        setDepartamentos((prev) => [...prev, departamentoCreado]);
        setNuevoDepartamento({ nombre: "", codigo: "", presupuestoAnual: "" });
        })
        .catch((err) => {
        console.error("Error al crear departamento:", err);
        alert("Error al crear el departamento");
        });
    }

  return (
    <div className="p-6">
      <h1 className="text-2xl font-bold mb-4">Departamentos</h1>

      {/* Formulario */}
      <form onSubmit={handleSubmit} className="mb-6 space-y-4 bg-gray-100 p-4 rounded shadow-md">
        <h2 className="text-lg font-semibold">Añadir nuevo departamento</h2>
        <div className="flex flex-col">
          <label htmlFor="nombre" className="font-medium">Nombre</label>
          <input
            type="text"
            id="nombre"
            name="nombre"
            value={nuevoDepartamento.nombre}
            onChange={handleChange}
            className="border rounded px-3 py-2"
            required
          />
        </div>
        <div className="flex flex-col">
          <label htmlFor="codigo" className="font-medium">Código</label>
          <input
            type="text"
            id="codigo"
            name="codigo"
            value={nuevoDepartamento.codigo}
            onChange={handleChange}
            className="border rounded px-3 py-2"
            required
          />
        </div>
        <div className="flex flex-col">
          <label htmlFor="presupuestoAnual" className="font-medium">Presupuesto Anual (€)</label>
          <input
            type="number"
            id="presupuestoAnual"
            name="presupuestoAnual"
            value={nuevoDepartamento.presupuestoAnual}
            onChange={handleChange}
            className="border rounded px-3 py-2"
            step="0.01"
            required
          />
        </div>
        <button
          type="submit"
          className="bg-blue-600 text-white px-4 py-2 rounded hover:bg-blue-700"
        >
          Crear Departamento
        </button>
      </form>

      {/* Tabla de departamentos */}
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
