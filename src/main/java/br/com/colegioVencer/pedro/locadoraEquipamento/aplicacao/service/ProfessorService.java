package br.com.colegioVencer.pedro.locadoraEquipamento.aplicacao.service;

import br.com.colegioVencer.pedro.locadoraEquipamento.dto.request.ProfessorRequest;
import br.com.colegioVencer.pedro.locadoraEquipamento.dto.response.ProfessorResponse;
import br.com.colegioVencer.pedro.locadoraEquipamento.infra.ProfessorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProfessorService {

    ProfessorResponse criarProfessor(ProfessorRequest professorRequest);
    List<ProfessorResponse> listaDeProfessores();

    ProfessorResponse buscarProfessorPorCpf(String cpf);
}
