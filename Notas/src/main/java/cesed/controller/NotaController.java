package cesed.controller;

import cesed.entity.Nota;
import cesed.service.NotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notas")
public class NotaController {

    @Autowired
    private NotaService service;

    @PostMapping
    public ResponseEntity<Nota> salvar(@RequestBody Nota nota) {
        return ResponseEntity.ok(service.salvar(nota));
    }

    @GetMapping
    public ResponseEntity<List<Nota>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Nota> buscar(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/aluno/{alunoId}")
    public ResponseEntity<List<Nota>> buscarPorAluno(@PathVariable Long alunoId) {
        return ResponseEntity.ok(service.buscarPorAluno(alunoId));
    }

    @GetMapping("/disciplina/{disciplinaId}")
    public ResponseEntity<List<Nota>> buscarPorDisciplina(@PathVariable Long disciplinaId) {
        return ResponseEntity.ok(service.buscarPorDisciplina(disciplinaId));
    }
}
