package cesed.service;

import cesed.entity.Nota;
import cesed.repository.NotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotaService {

    @Autowired
    private NotaRepository repository;

    public Nota salvar(Nota nota) {
        return repository.save(nota);
    }

    public List<Nota> listar() {
        return repository.findAll();
    }

    public Optional<Nota> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public void excluir(Long id) {
        repository.deleteById(id);
    }

    public List<Nota> buscarPorAluno(Long alunoId) {
        return repository.findByAlunoId(alunoId);
    }

    public List<Nota> buscarPorDisciplina(Long disciplinaId) {
        return repository.findByDisciplinaId(disciplinaId);
    }
}

