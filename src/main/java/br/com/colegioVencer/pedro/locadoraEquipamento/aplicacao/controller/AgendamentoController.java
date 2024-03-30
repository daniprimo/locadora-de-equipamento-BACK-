package br.com.colegioVencer.pedro.locadoraEquipamento.aplicacao.controller;

import br.com.colegioVencer.pedro.locadoraEquipamento.aplicacao.service.AgendamentoService;
import br.com.colegioVencer.pedro.locadoraEquipamento.dto.request.AgendamentorRequest;
import br.com.colegioVencer.pedro.locadoraEquipamento.dto.request.RetirarAgendamentoRequest;
import br.com.colegioVencer.pedro.locadoraEquipamento.dto.response.AgendamentoResponse;
import br.com.colegioVencer.pedro.locadoraEquipamento.dto.response.AgendamentoRetiradoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agendamento")
public class AgendamentoController {

   @Autowired
    private AgendamentoService agendamentoService;

    @PostMapping
    public ResponseEntity<AgendamentoResponse> criarNovoAgendamento(@RequestBody AgendamentorRequest agendamentorRequest) {
        return ResponseEntity.ok(agendamentoService.novoAgendamento(agendamentorRequest));
    }

    @GetMapping
    public ResponseEntity<List<AgendamentoResponse>> buscarAgendamentos(){
        return ResponseEntity.ok(agendamentoService.listaDeAgendamentos());
    }

    @PostMapping("/retirarAgendamento")
    public ResponseEntity<AgendamentoResponse> retirarAgendamento(@RequestBody RetirarAgendamentoRequest retirarAgendamentoRequest){
        return ResponseEntity.ok(agendamentoService.retirarAgendamento(retirarAgendamentoRequest));
    }

    @PostMapping("/devolver")
    public ResponseEntity<AgendamentoResponse> devolvidoAgendamento(@RequestBody RetirarAgendamentoRequest retirarAgendamentoRequest){
        return ResponseEntity.ok(agendamentoService.devolverAgendamento(retirarAgendamentoRequest));
    }

    @GetMapping("/emprestados")
    public ResponseEntity<List<AgendamentoRetiradoResponse>> buscarAgendamentosRetirados(){
        return ResponseEntity.ok(agendamentoService.listaDeAgendamentosRetirados());
    }
}
