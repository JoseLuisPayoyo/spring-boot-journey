import { useEffect, useState } from "react";
import { fetchDepartamentos } from "../api/departamentos";
import {
  fetchEmpleadosConFiltros,
  crearEmpleadoAPI,
  eliminarEmpleadoAPI,
} from "../api/empleados";

export default function EmpleadosPage() {
  const [empleados, setEmpleados] = useState([]);
  const [filtros, setFiltros] = useState({
    nombre: "",
    email: "",
    puesto: "",
    estado: "",
    departamentoId: "",
  });
  const [departamentos, setDepartamentos] = useState([]);
  const [mostrarFormulario, setMostrarFormulario] = useState(false);
  const [nuevoEmpleado, setNuevoEmpleado] = useState({
    nombre: "",
    apellido: "",
    email: "",
    telefono: "",
    fechaContratacion: "",
    salario: "",
    puesto: "DEV",
    estado: "ACTIVE",
    departamentoId: "",
  });

  // Cargar empleados
  const cargarEmpleados = async () => {
    const data = await fetchEmpleadosConFiltros(filtros);
    setEmpleados(data.content);
  };

  // Cargar departamentos
  const cargarDepartamentos = async () => {
    const data = await fetchDepartamentos();
    setDepartamentos(data);
  };

  useEffect(() => {
    cargarDepartamentos();
    cargarEmpleados();
  }, []);

  // Handlers
  const handleInputChange = (e) => {
    setFiltros({ ...filtros, [e.target.name]: e.target.value });
  };

  const handleNuevoEmpleadoChange = (e) => {
    setNuevoEmpleado({ ...nuevoEmpleado, [e.target.name]: e.target.value });
  };

  const handleBuscar = () => {
    cargarEmpleados();
  };

  const handleCrear = async () => {
    try {
      const payload = {
        ...nuevoEmpleado,
        salario: parseFloat(nuevoEmpleado.salario),
        departamentoId: parseInt(nuevoEmpleado.departamentoId),
      };
      await crearEmpleadoAPI(payload);
      setMostrarFormulario(false);
      cargarEmpleados();
    } catch (err) {
      alert("Error al crear empleado: " + err.message);
    }
  };

  const handleEliminar = async (id) => {
    if (!window.confirm("¿Estás seguro de que deseas eliminar este empleado?")) return;
    await eliminarEmpleadoAPI(id);
    cargarEmpleados();
  };

  return (
    <div className="p-6">
      <h1 className="text-3xl font-bold mb-6">Gestión de Empleados</h1>

      {/* Filtros */}
      <div className="flex flex-wrap gap-4 items-end mb-6">
        <input type="text" name="nombre" placeholder="Nombre" value={filtros.nombre} onChange={handleInputChange} className="border p-2 rounded w-36" />
        <input type="text" name="email" placeholder="Email" value={filtros.email} onChange={handleInputChange} className="border p-2 rounded w-44" />
        <select name="puesto" value={filtros.puesto} onChange={handleInputChange} className="border p-2 rounded">
          <option value="">Puesto</option>
          <option value="DEV">Desarrollador</option>
          <option value="QA">QA</option>
          <option value="DEVOPS">DevOps</option>
          <option value="DATA">Data</option>
          <option value="PM">PM</option>
          <option value="HR">RRHH</option>
          <option value="SALES">Ventas</option>
          <option value="SUPPORT">Soporte</option>
        </select>
        <select name="estado" value={filtros.estado} onChange={handleInputChange} className="border p-2 rounded">
          <option value="">Estado</option>
          <option value="ACTIVE">Activo</option>
          <option value="INACTIVE">Inactivo</option>
          <option value="ON_LEAVE">Baja temporal</option>
        </select>
        <select name="departamentoId" value={filtros.departamentoId} onChange={handleInputChange} className="border p-2 rounded">
          <option value="">Departamento</option>
          {departamentos.map((d) => (
            <option key={d.id} value={d.id}>{d.nombre}</option>
          ))}
        </select>

        {/* Botones */}
        <div className="ml-auto flex gap-2">
          <button onClick={handleBuscar} className="bg-blue-600 text-white px-4 py-2 rounded hover:bg-blue-700">Buscar</button>
          <button onClick={() => setMostrarFormulario(true)} className="bg-green-600 text-white px-4 py-2 rounded hover:bg-green-700">Crear empleado</button>
        </div>
      </div>

      {/* Tabla */}
      <table className="w-full border">
        <thead>
          <tr className="bg-gray-100">
            <th className="border px-2 py-1">ID</th>
            <th className="border px-2 py-1">Nombre</th>
            <th className="border px-2 py-1">Email</th>
            <th className="border px-2 py-1">Puesto</th>
            <th className="border px-2 py-1">Estado</th>
            <th className="border px-2 py-1">Departamento</th>
            <th className="border px-2 py-1">Acciones</th>
          </tr>
        </thead>
        <tbody>
          {empleados.map((emp) => (
            <tr key={emp.id}>
              <td className="border px-2 py-1">{emp.id}</td>
              <td className="border px-2 py-1">{emp.nombre} {emp.apellido}</td>
              <td className="border px-2 py-1">{emp.email}</td>
              <td className="border px-2 py-1">{emp.puesto}</td>
              <td className="border px-2 py-1">{emp.estado}</td>
              <td className="border px-2 py-1">{emp.departamento?.nombre || "Sin depto"}</td>
              <td className="border px-2 py-1">
                <button onClick={() => handleEliminar(emp.id)} className="bg-red-500 text-white px-2 py-1 rounded hover:bg-red-600">Eliminar</button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>

      {/* Formulario creación */}
      {mostrarFormulario && (
        <div className="mt-6 p-4 border rounded bg-gray-50">
          <h2 className="text-xl font-bold mb-4">Nuevo empleado</h2>
          <div className="grid grid-cols-2 gap-4">
            <input name="nombre" value={nuevoEmpleado.nombre} onChange={handleNuevoEmpleadoChange} placeholder="Nombre" className="border p-2 rounded" />
            <input name="apellido" value={nuevoEmpleado.apellido} onChange={handleNuevoEmpleadoChange} placeholder="Apellido" className="border p-2 rounded" />
            <input name="email" value={nuevoEmpleado.email} onChange={handleNuevoEmpleadoChange} placeholder="Email" className="border p-2 rounded" />
            <input name="telefono" value={nuevoEmpleado.telefono} onChange={handleNuevoEmpleadoChange} placeholder="Teléfono" className="border p-2 rounded" />
            <input type="date" name="fechaContratacion" value={nuevoEmpleado.fechaContratacion} onChange={handleNuevoEmpleadoChange} className="border p-2 rounded" />
            <input type="number" name="salario" value={nuevoEmpleado.salario} onChange={handleNuevoEmpleadoChange} placeholder="Salario" className="border p-2 rounded" />
            <select name="puesto" value={nuevoEmpleado.puesto} onChange={handleNuevoEmpleadoChange} className="border p-2 rounded">
              <option value="DEV">Desarrollador</option>
              <option value="QA">QA</option>
              <option value="DEVOPS">DevOps</option>
              <option value="DATA">Data</option>
              <option value="PM">PM</option>
              <option value="HR">RRHH</option>
              <option value="SALES">Ventas</option>
              <option value="SUPPORT">Soporte</option>
            </select>
            <select name="estado" value={nuevoEmpleado.estado} onChange={handleNuevoEmpleadoChange} className="border p-2 rounded">
              <option value="ACTIVE">Activo</option>
              <option value="INACTIVE">Inactivo</option>
              <option value="ON_LEAVE">Baja temporal</option>
            </select>
            <select name="departamentoId" value={nuevoEmpleado.departamentoId} onChange={handleNuevoEmpleadoChange} className="border p-2 rounded col-span-2">
              <option value="">Selecciona un departamento</option>
              {departamentos.map((d) => (
                <option key={d.id} value={d.id}>{d.nombre}</option>
              ))}
            </select>
          </div>
          <div className="mt-4 flex gap-2">
            <button onClick={handleCrear} className="bg-green-600 text-white px-4 py-2 rounded hover:bg-green-700">Guardar</button>
            <button onClick={() => setMostrarFormulario(false)} className="bg-gray-400 text-white px-4 py-2 rounded hover:bg-gray-500">Cancelar</button>
          </div>
        </div>
      )}
    </div>
  );
}
