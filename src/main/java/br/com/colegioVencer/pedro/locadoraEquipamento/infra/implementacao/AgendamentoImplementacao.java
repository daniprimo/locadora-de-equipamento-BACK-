package br.com.colegioVencer.pedro.locadoraEquipamento.infra.implementacao;

import br.com.colegioVencer.pedro.locadoraEquipamento.aplicacao.service.AgendamentoService;
import br.com.colegioVencer.pedro.locadoraEquipamento.dominio.Agendamento;
import br.com.colegioVencer.pedro.locadoraEquipamento.dominio.Item;
import br.com.colegioVencer.pedro.locadoraEquipamento.dto.request.AgendamentorRequest;
import br.com.colegioVencer.pedro.locadoraEquipamento.dto.request.RetirarAgendamentoRequest;
import br.com.colegioVencer.pedro.locadoraEquipamento.dto.response.AgendamentoResponse;
import br.com.colegioVencer.pedro.locadoraEquipamento.dto.response.AgendamentoRetiradoResponse;
import br.com.colegioVencer.pedro.locadoraEquipamento.infra.AgendamentoRepository;
import br.com.colegioVencer.pedro.locadoraEquipamento.infra.AtendenteRepository;
import br.com.colegioVencer.pedro.locadoraEquipamento.infra.ItemRepository;
import br.com.colegioVencer.pedro.locadoraEquipamento.infra.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AgendamentoImplementacao implements AgendamentoService {

    @Autowired
    private ProfessorRepository professorRepository;

    @Autowired
    private AtendenteRepository atendenteRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    @Override
    public AgendamentoResponse novoAgendamento(AgendamentorRequest agendamentorRequest) {
        List<Item> listaDeItens = new ArrayList<>();

        agendamentorRequest.getListaDeItens().forEach(id -> {
            Item item = itemRepository.findById(id).get();
            listaDeItens.add(item);
        });


        Agendamento agendamento = Agendamento.builder()
                .atendente(atendenteRepository.buscarAtendentePeloCodigo(agendamentorRequest.getIdAtendenete()))
                .professor(professorRepository.buscarProfessorPorCpf(agendamentorRequest.getCpfProfessor()))
                .itens(listaDeItens)
                .status("AGENDADO")
                .agendamentoData(agendamentorRequest.getDataAgendado())
                .agendamentoDHora(agendamentorRequest.getHoraAgendado())
                .build();

        Agendamento agendamentoSalvo = agendamentoRepository.save(agendamento);

        return agendamentoSalvo.response();
    }

    @Override
    public List<AgendamentoResponse> listaDeAgendamentos() {
        List<Agendamento> agendamentos = agendamentoRepository.buscarAgendados();

        List<AgendamentoResponse> listAgendamentos = agendamentos.stream().map(agendamento -> {
            List<Item> itens = new ArrayList<>();
            List<Long> idsDosItens = agendamentoRepository.busarOsItensDoAgendamento(agendamento.getId());
            idsDosItens.forEach(id -> {
                itens.add(itemRepository.findById(id).get());
            });
            agendamento.setItens(itens);
            return agendamento;
        }).map(Agendamento::response).toList();

        return listAgendamentos;
    }

    @Override
    public AgendamentoResponse retirarAgendamento(RetirarAgendamentoRequest retirarAgendamentoRequest) {
        Agendamento agendamento = agendamentoRepository.findById(retirarAgendamentoRequest.getId()).get();
        agendamento.setRetiradaData(retirarAgendamentoRequest.getData());
        agendamento.setRetiradaHora(retirarAgendamentoRequest.getHora());
        agendamento.setStatus("EMPRESTADO");
        Agendamento agendamentoSalvo = agendamentoRepository.save(agendamento);
        return agendamentoSalvo.response();
    }

    @Override
    public List<AgendamentoRetiradoResponse> listaDeAgendamentosRetirados() {
        List<Agendamento> agendamentos = agendamentoRepository.buscarAgendadosRetirados();

        List<AgendamentoRetiradoResponse> listAgendamentos = agendamentos.stream()
                .map(agendamento -> {
            List<Item> itens = new ArrayList<>();
            List<Long> idsDosItens = agendamentoRepository.busarOsItensDoAgendamento(agendamento.getId());
            idsDosItens.forEach(id -> {
                itens.add(itemRepository.findById(id).get());
            });
            agendamento.setItens(itens);
            return agendamento;
        }).map(Agendamento::RetiradaResponse).toList();

        return listAgendamentos;
    }

    @Override
    public AgendamentoResponse devolverAgendamento(RetirarAgendamentoRequest retirarAgendamentoRequest) {
        Agendamento agendamento = agendamentoRepository.findById(retirarAgendamentoRequest.getId()).get();
        agendamento.setEntregaData(retirarAgendamentoRequest.getData());
        agendamento.setEntregaHora(retirarAgendamentoRequest.getHora());
        agendamento.setStatus("DEVOLVIDO");
        Agendamento agendamentoSalvo = agendamentoRepository.save(agendamento);
        return agendamentoSalvo.response();
    }

}
