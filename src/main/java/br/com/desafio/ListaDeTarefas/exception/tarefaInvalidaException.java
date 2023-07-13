package br.com.desafio.ListaDeTarefas.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class tarefaInvalidaException extends RuntimeException {
    public tarefaInvalidaException(String message) {
        super(message);
    }
}
