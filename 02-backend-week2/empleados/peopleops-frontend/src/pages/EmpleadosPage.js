import { useEffect, useState } from "react";
import { fetchEmpleados } from "../api/empleados";

function EmpleadosPage() {
  const [empleados, setEmpleados] = useState([]);
  const [error, setError] = useState(null);

  useEffect(() => {
    fetchEmpleados()
      .then(setEmpleados)
      .catch((err) => setError(err.message));
  }, []);

  if (error) {
    return <div className="p-6 text-red-600">Error: {error}</div>;
  }

  return (
    <div className="p-6">
      <h1 className="text-2xl font-bold mb-4">Lista de Empleados</h1>
      <table className="min-w-full bg-white border rounded shadow text-sm">
        <thead className="bg-gray-100">
          <tr>
            <th className="p-2 text-left">ID</th>
            <th className="p-2 text-left">Nombre</th>
            <th className="p-2 text-left">Apellido</th>
            <th className="p-2 text-left">Email</th>
            <th className="p-2 text-left">Departamento</th>
          </tr>
        </thead>
        <tbody>
          {empleados.map((emp) => (
            <tr key={emp.id} className="border-t hover:bg-gray-50">
              <td className="p-2">{emp.id}</td>
              <td className="p-2">{emp.nombre}</td>
              <td className="p-2">{emp.apellido}</td>
              <td className="p-2">{emp.email}</td>
              <td className="p-2">{emp.departamentoNombre}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default EmpleadosPage;
