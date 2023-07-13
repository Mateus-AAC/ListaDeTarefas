package br.com.desafio.ListaDeTarefas.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.Range;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
public class TarefasCreateRequest {
    private Integer Id;

    @NotEmpty (message = "Titulo Necessario")
    private String Titulo;

    @NotEmpty (message = "Descricao Necessario")
    private String Descricao;

    @Range (min = 0, max = 1)
    private Integer Concluido;

    @Range (min = 1, max = 5)
    private Integer Prioridade;
}