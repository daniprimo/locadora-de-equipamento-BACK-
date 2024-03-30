package br.com.colegioVencer.pedro.locadoraEquipamento.aplicacao.service;

import br.com.colegioVencer.pedro.locadoraEquipamento.dto.request.AtendenteRequest;
import br.com.colegioVencer.pedro.locadoraEquipamento.dto.response.AtendenteResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AtendenteService {

    AtendenteResponse criarNovoAtendente(AtendenteRequest atendenteRequest);
    List<AtendenteResponse> buscarTodos();
    AtendenteResponse buscarAtendentePorCodigoInterno(Long id);
}
