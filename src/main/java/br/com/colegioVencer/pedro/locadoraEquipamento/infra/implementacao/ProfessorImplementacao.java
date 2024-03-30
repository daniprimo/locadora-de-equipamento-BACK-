package br.com.colegioVencer.pedro.locadoraEquipamento.infra.implementacao;

import br.com.colegioVencer.pedro.locadoraEquipamento.aplicacao.service.ProfessorService;
import br.com.colegioVencer.pedro.locadoraEquipamento.dominio.Professor;
import br.com.colegioVencer.pedro.locadoraEquipamento.dto.request.ProfessorRequest;
import br.com.colegioVencer.pedro.locadoraEquipamento.dto.response.ProfessorResponse;
import br.com.colegioVencer.pedro.locadoraEquipamento.infra.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorImplementacao implements ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    @Override
    public ProfessorResponse criarProfessor(ProfessorRequest professorRequest) {
        Professor professor = Professor.builder()
                .cpf(professorRequest.getCpf())
                .nome(professorRequest.getNome())
                .telefone(professorRequest.getTelefone())
                .build();

        Professor professorSalvo = professorRepository.save(professor);


        return professorSalvo.response();
    }

    @Override
    public List<ProfessorResponse> listaDeProfessores() {
        return professorRepository.findAll().stream().map(Professor::response).toList();
    }

    @Override
    public ProfessorResponse buscarProfessorPorCpf(String cpf) {
        return professorRepository.buscarProfessorPorCpf(cpf).response();
    }
}
