package br.com.colegioVencer.pedro.locadoraEquipamento.infra.implementacao;

import br.com.colegioVencer.pedro.locadoraEquipamento.aplicacao.service.AtendenteService;
import br.com.colegioVencer.pedro.locadoraEquipamento.dominio.Atendente;
import br.com.colegioVencer.pedro.locadoraEquipamento.dto.request.AtendenteRequest;
import br.com.colegioVencer.pedro.locadoraEquipamento.dto.response.AtendenteResponse;
import br.com.colegioVencer.pedro.locadoraEquipamento.infra.AtendenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AtendenteImplementacao implements AtendenteService {

    @Autowired
    private AtendenteRepository atendenteRepository;

    @Override
    public AtendenteResponse criarNovoAtendente(AtendenteRequest atendenteRequest) {
        Atendente atendente = Atendente.builder()
                .nome(atendenteRequest.getNome())
                .login(atendenteRequest.getLogin())
                .senha(atendenteRequest.getSenha())
                .build();

        Atendente atendenteSalvo = atendenteRepository.save(atendente);


        return atendenteSalvo.response();
    }

    @Override
    public List<AtendenteResponse> buscarTodos() {
        return atendenteRepository.findAll().stream().map(Atendente::response).toList();
    }

    @Override
    public AtendenteResponse buscarAtendentePorCodigoInterno(Long id) {
        return atendenteRepository.buscarAtendentePeloCodigo(id).response();
    }
}
