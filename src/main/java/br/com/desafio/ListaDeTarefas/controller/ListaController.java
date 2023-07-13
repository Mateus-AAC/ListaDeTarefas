package br.com.desafio.ListaDeTarefas.controller;

import br.com.desafio.ListaDeTarefas.domain.dto.TarefasCreateRequest;
import br.com.desafio.ListaDeTarefas.domain.dto.TarefasUpdateConcluido;
import br.com.desafio.ListaDeTarefas.domain.dto.TarefasUpdatePrioridade;
import br.com.desafio.ListaDeTarefas.domain.entity.Tarefas;
import br.com.desafio.ListaDeTarefas.service.TarefaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ListaController {

    private final TarefaService service;

    @GetMapping(value = "api/tarefas")
    public ResponseEntity<List<Tarefas>> listar(TarefasCreateRequest filter) {
        var listaDeTarefas = service.listar(filter);
        return ResponseEntity.ok(listaDeTarefas);
    }


    @GetMapping(value = "api/tarefas/{id}")
    public ResponseEntity<Tarefas> listarId(@PathVariable Integer id) {
        var TarefaId = service.listarId(id);
        return ResponseEntity.ok(TarefaId);
    }

    @PostMapping(value = "api/tarefasCadastrar")
    public ResponseEntity<Tarefas> cadastrarTarefa(@RequestBody @Valid TarefasCreateRequest tarefa) {
        var TarefaResponse = service.cadastrarTarefa(tarefa);
        return ResponseEntity.ok(TarefaResponse);
    }

    @PutMapping(value = "api/tarefasConcluidos/{id}")
    public ResponseEntity<Tarefas> atualizarTarefaConcluido(@PathVariable Integer id, @RequestBody @Valid TarefasUpdateConcluido tarefasUpdateConcluido) {
        var tarefa = service.updateStatusTarefaConcluido(id, tarefasUpdateConcluido);
        return ResponseEntity.ok(tarefa);
    }

    @PutMapping(value = "api/tarefasPrioridades/{id}")
    public ResponseEntity<Tarefas> atualizarTarefaPrioridade(@PathVariable Integer id, @RequestBody @Valid TarefasUpdatePrioridade tarefasUpdatePrioridade) {
        var tarefa = service.updateStatusTarefaPrioridade(id, tarefasUpdatePrioridade);
        return ResponseEntity.ok(tarefa);
    }

    @DeleteMapping(value = "api/tarefasDelete/{id}")
    public ResponseEntity<Tarefas> deletarPrioridade(@PathVariable Integer id) {
        var Tarefa = service.DeletarTarefa(id);
        return ResponseEntity.ok(Tarefa);
    }
}
