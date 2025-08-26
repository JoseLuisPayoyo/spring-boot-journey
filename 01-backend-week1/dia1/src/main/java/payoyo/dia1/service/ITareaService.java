package payoyo.dia1.service;

import java.util.List;
import java.util.Optional;

import payoyo.dia1.model.Tarea;

public interface ITareaService {

    Tarea guardar(Tarea tarea);

    List<Tarea> listarTodas();

    Optional<Tarea> buscarPorId(Long id);
}
