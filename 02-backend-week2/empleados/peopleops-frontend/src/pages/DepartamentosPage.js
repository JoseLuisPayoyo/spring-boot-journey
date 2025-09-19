import { useEffect, useState } from "react";
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
    <div className="p-8 max-w-5xl mx-auto">
      <h1 className="text-3xl font-bold text-gray-800 mb-6">Gestión de Departamentos</h1>

      {/* Formulario */}
      <form
        onSubmit={handleSubmit}
        className="mb-10 bg-white p-6 rounded-xl shadow-md border space-y-6"
      >
        <h2 className="text-xl font-semibold text-gray-700">Crear nuevo departamento</h2>

        <div className="grid grid-cols-1 md:grid-cols-3 gap-4">
          <div>
            <label htmlFor="nombre" className="block font-medium text-sm text-gray-600 mb-1">
              Nombre
            </label>
            <input
              type="text"
              id="nombre"
              name="nombre"
              value={nuevoDepartamento.nombre}
              onChange={handleChange}
              required
              className="w-full border border-gray-300 rounded-lg px-4 py-2 focus:outline-none focus:ring focus:ring-blue-300"
            />
          </div>

          <div>
            <label htmlFor="codigo" className="block font-medium text-sm text-gray-600 mb-1">
              Código
            </label>
            <input
              type="text"
              id="codigo"
              name="codigo"
              value={nuevoDepartamento.codigo}
              onChange={handleChange}
              required
              className="w-full border border-gray-300 rounded-lg px-4 py-2 focus:outline-none focus:ring focus:ring-blue-300"
            />
          </div>

          <div>
            <label htmlFor="presupuestoAnual" className="block font-medium text-sm text-gray-600 mb-1">
              Presupuesto Anual (€)
            </label>
            <input
              type="number"
              id="presupuestoAnual"
              name="presupuestoAnual"
              value={nuevoDepartamento.presupuestoAnual}
              onChange={handleChange}
              required
              step="0.01"
              className="w-full border border-gray-300 rounded-lg px-4 py-2 focus:outline-none focus:ring focus:ring-blue-300"
            />
          </div>
        </div>

        <button
          type="submit"
          className="bg-blue-600 hover:bg-blue-700 text-white font-semibold px-6 py-2 rounded-lg shadow"
        >
          Crear Departamento
        </button>
      </form>

      {/* Tabla */}
      {loading ? (
        <p className="text-gray-600">Cargando departamentos...</p>
      ) : (
        <div className="overflow-x-auto rounded-lg shadow">
          <table className="min-w-full bg-white border border-gray-200">
            <thead className="bg-gray-100 text-gray-700 text-sm uppercase">
              <tr>
                <th className="px-4 py-3 border">ID</th>
                <th className="px-4 py-3 border">Nombre</th>
                <th className="px-4 py-3 border">Código</th>
                <th className="px-4 py-3 border">Presupuesto</th>
                <th className="px-4 py-3 border">Activo</th>
              </tr>
            </thead>
            <tbody>
              {departamentos.map((d) => (
                <tr key={d.id} className="text-gray-800 text-sm text-center hover:bg-gray-50">
                  <td className="border px-4 py-2">{d.id}</td>
                  <td className="border px-4 py-2">{d.nombre}</td>
                  <td className="border px-4 py-2">{d.codigo}</td>
                  <td className="border px-4 py-2">{d.presupuestoAnual} €</td>
                  <td className="border px-4 py-2">{d.activo ? "Si" : "No"}</td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      )}
    </div>
  );
}
