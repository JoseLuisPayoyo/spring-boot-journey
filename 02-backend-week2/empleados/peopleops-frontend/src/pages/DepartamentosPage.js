import { useEffect, useState } from "react";
import {
  fetchDepartamentos,
  crearDepartamento,
  actualizarDepartamento,
  eliminarDepartamento,
} from "../api/departamentos";

export default function DepartamentoPage() {
  const [departamentos, setDepartamentos] = useState([]);
  const [nombre, setNombre] = useState("");
  const [codigo, setCodigo] = useState("");
  const [presupuesto, setPresupuesto] = useState("");
  const [editando, setEditando] = useState(false);
  const [departamentoEditando, setDepartamentoEditando] = useState(null);

  useEffect(() => {
    fetchDepartamentos().then(setDepartamentos).catch(console.error);
  }, []);

  async function handleSubmit(e) {
    e.preventDefault();
    try {
      const nuevo = await crearDepartamento({
        nombre,
        codigo,
        presupuestoAnual: presupuesto,
      });

      setDepartamentos((prev) => [...prev, nuevo]);
      limpiarFormulario();
    } catch (err) {
      console.error("Error creando:", err.message);
    }
  }

  async function handleUpdate(e) {
    e.preventDefault();
    try {
      const actualizado = await actualizarDepartamento(departamentoEditando.id, {
        nombre,
        codigo,
        presupuestoAnual: presupuesto,
      });

      setDepartamentos((prev) =>
        prev.map((d) => (d.id === actualizado.id ? actualizado : d))
      );

      limpiarFormulario();
    } catch (err) {
      console.error("Error actualizando:", err.message);
    }
  }

  function handleEdit(depto) {
    setEditando(true);
    setDepartamentoEditando(depto);
    setNombre(depto.nombre);
    setCodigo(depto.codigo);
    setPresupuesto(depto.presupuestoAnual);
  }

  async function handleDelete(id) {
    const confirmar = window.confirm("¿Estás seguro de que quieres eliminar este departamento?");
    if (!confirmar) return;

    try {
      await eliminarDepartamento(id);
      setDepartamentos((prev) => prev.filter((d) => d.id !== id));
    } catch (err) {
      console.error("Error eliminando:", err.message);
    }
  }

  function limpiarFormulario() {
    setNombre("");
    setCodigo("");
    setPresupuesto("");
    setEditando(false);
    setDepartamentoEditando(null);
  }

  return (
    <div className="p-6 max-w-4xl mx-auto">
      <h1 className="text-2xl font-bold mb-4">
        {editando ? "Editar Departamento" : "Nuevo Departamento"}
      </h1>

      <form onSubmit={editando ? handleUpdate : handleSubmit} className="space-y-4 mb-8">
        <div>
          <label className="block text-sm font-medium">Nombre</label>
          <input
            type="text"
            value={nombre}
            onChange={(e) => setNombre(e.target.value)}
            className="w-full p-2 border rounded"
            required
          />
        </div>
        <div>
          <label className="block text-sm font-medium">Código</label>
          <input
            type="text"
            value={codigo}
            onChange={(e) => setCodigo(e.target.value)}
            className="w-full p-2 border rounded"
            required
          />
        </div>
        <div>
          <label className="block text-sm font-medium">Presupuesto Anual</label>
          <input
            type="number"
            value={presupuesto}
            onChange={(e) => setPresupuesto(e.target.value)}
            className="w-full p-2 border rounded"
            required
          />
        </div>

        <div className="flex gap-4">
          <button
            type="submit"
            className="bg-blue-600 hover:bg-blue-700 text-white px-4 py-2 rounded"
          >
            {editando ? "Actualizar" : "Crear"}
          </button>

          {editando && (
            <button
              type="button"
              onClick={limpiarFormulario}
              className="bg-gray-500 hover:bg-gray-600 text-white px-4 py-2 rounded"
            >
              Cancelar
            </button>
          )}
        </div>
      </form>

      <h2 className="text-xl font-semibold mb-2">Listado de Departamentos</h2>
      <table className="min-w-full bg-white border rounded shadow-md">
        <thead>
          <tr className="bg-gray-100">
            <th className="px-4 py-2 border">ID</th>
            <th className="px-4 py-2 border">Nombre</th>
            <th className="px-4 py-2 border">Código</th>
            <th className="px-4 py-2 border">Presupuesto</th>
            <th className="px-4 py-2 border">Acciones</th>
          </tr>
        </thead>
        <tbody>
          {departamentos.map((d) => (
            <tr key={d.id}>
              <td className="px-4 py-2 border">{d.id}</td>
              <td className="px-4 py-2 border">{d.nombre}</td>
              <td className="px-4 py-2 border">{d.codigo}</td>
              <td className="px-4 py-2 border">{d.presupuestoAnual} €</td>
              <td className="px-4 py-2 border space-x-2">
                <button
                  onClick={() => handleEdit(d)}
                  className="bg-yellow-500 hover:bg-yellow-600 text-white px-2 py-1 rounded"
                >
                  Editar
                </button>
                <button
                  onClick={() => handleDelete(d.id)}
                  className="bg-red-600 hover:bg-red-700 text-white px-2 py-1 rounded"
                >
                  Eliminar
                </button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}
