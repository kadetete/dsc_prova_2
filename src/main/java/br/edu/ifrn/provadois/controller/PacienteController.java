package br.edu.ifrn.provadois.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.edu.ifrn.provadois.domain.paciente.Paciente;
import br.edu.ifrn.provadois.repository.PacienteRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("paciente")
public class PacienteController {
    
    @Autowired
    private PacienteRepository repository;

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> detalhar(@PathVariable Long id) {
        Paciente paciente = repository.getReferenceById(id);
        return ResponseEntity.ok(paciente);
    }

    @GetMapping
    public ResponseEntity<Page<Paciente>> listar(@PageableDefault(size = 30, sort = { "nome" }) Pageable paginacao) {
        var pacientes = repository.findAll(paginacao);
        return ResponseEntity.ok(pacientes);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Object> cadastrar(@RequestBody @Valid Paciente paciente,
            UriComponentsBuilder uriBuilder) {
        Paciente pacienteLocal = repository.save(paciente);
        var uri = uriBuilder.path("/paciente/{id}").buildAndExpand(pacienteLocal.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Object> excluir(@PathVariable Long id) {
        var paciente = repository.getReferenceById(id);
        repository.delete(paciente);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    @Transactional
    public ResponseEntity<Paciente> atualizar(@RequestBody @Valid Paciente paciente) {
        Paciente pacienteLocal = repository.findById(
                paciente.getId()).get();

        pacienteLocal.setNome(paciente.getNome());
        pacienteLocal.setCpf(paciente.getCpf());
        pacienteLocal.setHistoricoMedico(paciente.getHistoricoMedico());

        return ResponseEntity.ok(pacienteLocal);
    }

}
