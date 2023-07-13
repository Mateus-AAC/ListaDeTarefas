package br.com.desafio.ListaDeTarefas.domain.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;

@Data
public class TarefasUpdatePrioridade {
    @NotNull
    @Range(min = 1, max = 5)
    private Integer Prioridade;
}
