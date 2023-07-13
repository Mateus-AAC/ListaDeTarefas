package br.com.desafio.ListaDeTarefas.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table (name = "Tarefas")
public class Tarefas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @Column (name = "Titulo", length = 60)
    private String Titulo;

    @Column (name = "Descricao", length = 60)
    private String Descricao;

    @Column (name = "Concluido")
    private Integer Concluido;

    @Column (name = "Prioridade")
    private Integer Prioridade;
}