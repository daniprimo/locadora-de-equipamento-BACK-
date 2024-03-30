package br.com.colegioVencer.pedro.locadoraEquipamento.aplicacao.service;

import br.com.colegioVencer.pedro.locadoraEquipamento.dto.request.CategoriaRequest;
import br.com.colegioVencer.pedro.locadoraEquipamento.dto.response.CategoriaResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoriaService {

    CategoriaResponse criaCategoria(CategoriaRequest categoriaRequest);

    List<CategoriaResponse> listarTodasCategorias();

    CategoriaResponse buscarCategoriaPorId(Long id);

}
