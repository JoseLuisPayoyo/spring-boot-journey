import { BrowserRouter as Router, Routes, Route, Navigate } from "react-router-dom";
import EmpleadosPage from "./pages/EmpleadosPage";
import DepartamentosPage from "./pages/DepartamentosPage";
import Navbar from "./components/Navbar";

function App() {
  return (
    <Router>
      <Navbar />
      <Routes>
        <Route path="/" element={<Navigate to="/empleados" />} />
        <Route path="/empleados" element={<EmpleadosPage />} />
        <Route path="/departamentos" element={<DepartamentosPage />} />
      </Routes>
    </Router>
  );
}

export default App;
