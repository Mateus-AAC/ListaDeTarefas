package br.com.desafio.ListaDeTarefas.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class tarefaNaoEncontrada extends RuntimeException {
    public tarefaNaoEncontrada() {
        super("Não foi encontrado tarefa para a entrada");
    }
}
