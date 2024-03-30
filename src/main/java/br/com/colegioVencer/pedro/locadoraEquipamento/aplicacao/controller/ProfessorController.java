package br.com.colegioVencer.pedro.locadoraEquipamento.aplicacao.controller;

import br.com.colegioVencer.pedro.locadoraEquipamento.aplicacao.service.ProfessorService;
import br.com.colegioVencer.pedro.locadoraEquipamento.dto.request.ProfessorRequest;
import br.com.colegioVencer.pedro.locadoraEquipamento.dto.response.ProfessorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professor")
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;

    @PostMapping
    public ResponseEntity<ProfessorResponse> criarProfessor(@RequestBody ProfessorRequest professorRequest) {
        return ResponseEntity.ok(professorService.criarProfessor(professorRequest));
    }

    @GetMapping
    public ResponseEntity<List<ProfessorResponse>> todosProfessores() {
        return ResponseEntity.ok(professorService.listaDeProfessores());
    }

    @GetMapping("/buscarPorCpf/{cpf}")
    public ResponseEntity<ProfessorResponse> buscarProfessorPorCpf(@PathVariable String cpf) {
        return ResponseEntity.ok(professorService.buscarProfessorPorCpf(cpf));
    }

}
