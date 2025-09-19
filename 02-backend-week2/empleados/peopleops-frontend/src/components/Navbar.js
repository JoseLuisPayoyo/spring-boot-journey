import { Link, useLocation } from "react-router-dom";

function Navbar() {
  const { pathname } = useLocation();

  const linkClasses = (path) =>
    `px-4 py-2 rounded hover:bg-blue-200 ${
      pathname === path ? "bg-blue-100 font-semibold" : "text-gray-700"
    }`;

  return (
    <nav className="bg-white border-b shadow px-6 py-3 flex gap-4 items-center">
      <Link to="/empleados" className={linkClasses("/empleados")}>
        Empleados
      </Link>
      <Link to="/departamentos" className={linkClasses("/departamentos")}>
        Departamentos
      </Link>
    </nav>
  );
}

export default Navbar;
