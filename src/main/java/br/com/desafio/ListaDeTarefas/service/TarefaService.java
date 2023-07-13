package br.com.desafio.ListaDeTarefas.service;

import br.com.desafio.ListaDeTarefas.exception.tarefaInvalidaException;
import br.com.desafio.ListaDeTarefas.repository.TarefasRepository;
import br.com.desafio.ListaDeTarefas.domain.dto.TarefasCreateRequest;
import br.com.desafio.ListaDeTarefas.domain.dto.TarefasUpdateConcluido;
import br.com.desafio.ListaDeTarefas.domain.dto.TarefasUpdatePrioridade;
import br.com.desafio.ListaDeTarefas.domain.entity.Tarefas;
import br.com.desafio.ListaDeTarefas.exception.tarefaNaoEncontrada;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TarefaService {
    private final TarefasRepository repository;

    public List<Tarefas> listar(TarefasCreateRequest filter) {
        var listaDate = repository.listarComFiltroNativo();
        return listaDate;
    }

    public Tarefas listarId(int Id) {
        var tarefaEncontrada = repository.findById(Id);

        if (tarefaEncontrada.isEmpty()) {
            throw new tarefaNaoEncontrada();
        }

        var tarefaSalva = tarefaEncontrada.get();

        return tarefaSalva;
    }

    public Tarefas cadastrarTarefa(TarefasCreateRequest tarefasCreateRequest) {

        if (tarefasCreateRequest.getTitulo() == " " || tarefasCreateRequest.getDescricao() == " ") {
            throw new tarefaInvalidaException("Dados Invalidos");
        }

        var novaTarefa = new Tarefas();
        novaTarefa.setId(tarefasCreateRequest.getId());
        novaTarefa.setTitulo(tarefasCreateRequest.getTitulo());
        novaTarefa.setDescricao(tarefasCreateRequest.getDescricao());
        novaTarefa.setConcluido(tarefasCreateRequest.getConcluido());
        novaTarefa.setPrioridade(tarefasCreateRequest.getPrioridade());

        var tarefaSalva = repository.save(novaTarefa);

        return tarefaSalva;
    }

    public Tarefas updateStatusTarefaConcluido(int Id, TarefasUpdateConcluido tarefaUpdate) {
        var TarefaEncontrada =  repository.findById(Id);

        if (TarefaEncontrada.isEmpty()) {
            throw new tarefaNaoEncontrada();
        }

        var tarefa = TarefaEncontrada.get();
        tarefa.setConcluido(tarefaUpdate.getConcluido());

        var tarefaSalva = repository.save(tarefa);

        return tarefaSalva;
    }

    public Tarefas updateStatusTarefaPrioridade(int Id, TarefasUpdatePrioridade TarefaPrioridade) {
        var TarefaEncontrada =  repository.findById(Id);

        if (TarefaEncontrada.isEmpty()) {
            throw new tarefaNaoEncontrada();
        }

        var tarefa = TarefaEncontrada.get();
        tarefa.setPrioridade(TarefaPrioridade.getPrioridade());

        var tarefaSalva = repository.save(tarefa);

        return tarefaSalva;
    }

    public Tarefas DeletarTarefa(int Id) {
        var TarefaEncontrada = repository.findById(Id);

        if (TarefaEncontrada.isEmpty()) {
            throw new tarefaNaoEncontrada();
        }

        var tarefa = TarefaEncontrada.get();

        repository.delete(tarefa);

        return tarefa;
    }
}
