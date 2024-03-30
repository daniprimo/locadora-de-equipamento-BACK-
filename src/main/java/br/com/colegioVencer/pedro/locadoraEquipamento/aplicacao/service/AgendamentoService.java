package br.com.colegioVencer.pedro.locadoraEquipamento.aplicacao.service;

import br.com.colegioVencer.pedro.locadoraEquipamento.dominio.Agendamento;
import br.com.colegioVencer.pedro.locadoraEquipamento.dto.request.AgendamentorRequest;
import br.com.colegioVencer.pedro.locadoraEquipamento.dto.request.RetirarAgendamentoRequest;
import br.com.colegioVencer.pedro.locadoraEquipamento.dto.response.AgendamentoResponse;
import br.com.colegioVencer.pedro.locadoraEquipamento.dto.response.AgendamentoRetiradoResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AgendamentoService {

    AgendamentoResponse novoAgendamento(AgendamentorRequest agendamentorRequest);

    List<AgendamentoResponse> listaDeAgendamentos();

    AgendamentoResponse retirarAgendamento (RetirarAgendamentoRequest retirarAgendamentoRequest);

    List<AgendamentoRetiradoResponse> listaDeAgendamentosRetirados();

    AgendamentoResponse devolverAgendamento (RetirarAgendamentoRequest retirarAgendamentoRequest);

}
