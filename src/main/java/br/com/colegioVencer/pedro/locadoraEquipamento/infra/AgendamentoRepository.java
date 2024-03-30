package br.com.colegioVencer.pedro.locadoraEquipamento.infra;

import br.com.colegioVencer.pedro.locadoraEquipamento.dominio.Agendamento;
import lombok.extern.java.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Repository
public interface AgendamentoRepository  extends JpaRepository<Agendamento, Long> {
    @Query(value = "select * from tb_agendamento" +
            " WHERE status = 'AGENDADO'" +
            " order by agendamentodhora ASC;", nativeQuery = true)
    List<Agendamento> buscarAgendados();

    @Query(value = "select item_id from agendamento_realizados" +
            " where agendamento_realizados.agendamento_id = :id", nativeQuery = true)
    List<Long> busarOsItensDoAgendamento(@Param("id") Long id);

    @Query(value = "select * from tb_agendamento" +
            " WHERE status = 'EMPRESTADO'" +
            " order by agendamentodhora ASC;", nativeQuery = true)
    List<Agendamento> buscarAgendadosRetirados();
}
