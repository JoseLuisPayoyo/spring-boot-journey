package payoyo.dia1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import payoyo.dia1.model.Tarea;
import payoyo.dia1.repository.TareaRepository;

@Service
public class TareaService implements ITareaService{

    @Autowired
    private TareaRepository tareaRepository;

    @Override
    public Tarea guardar(Tarea tarea) {
        return tareaRepository.save(tarea);
    }

    @Override
    public List<Tarea> listarTodas() {
        return tareaRepository.findAll();
    }

    @Override
    public Optional<Tarea> buscarPorId(Long id) {
        return tareaRepository.findById(id);
    }
    
}
