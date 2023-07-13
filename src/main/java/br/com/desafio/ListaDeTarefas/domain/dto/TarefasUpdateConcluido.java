package br.com.desafio.ListaDeTarefas.domain.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;

@Data
public class TarefasUpdateConcluido {
    @NotNull
    @Range(min = 0, max = 1)
    private Integer Concluido;
}
