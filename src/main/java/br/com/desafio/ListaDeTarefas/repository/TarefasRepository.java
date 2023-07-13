package br.com.desafio.ListaDeTarefas.repository;

import br.com.desafio.ListaDeTarefas.domain.entity.Tarefas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TarefasRepository extends JpaRepository<Tarefas, Integer> {
    @Query(
            nativeQuery = true,
            value = "SELECT * FROM Tarefas"
    )
    List<Tarefas> listarComFiltroNativo();
}
