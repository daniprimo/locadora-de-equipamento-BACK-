package br.com.colegioVencer.pedro.locadoraEquipamento.infra.implementacao;

import br.com.colegioVencer.pedro.locadoraEquipamento.aplicacao.service.CategoriaService;
import br.com.colegioVencer.pedro.locadoraEquipamento.dominio.Categoria;
import br.com.colegioVencer.pedro.locadoraEquipamento.dto.request.CategoriaRequest;
import br.com.colegioVencer.pedro.locadoraEquipamento.dto.response.CategoriaResponse;
import br.com.colegioVencer.pedro.locadoraEquipamento.infra.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaImplementacao implements CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public CategoriaResponse criaCategoria(CategoriaRequest categoriaRequest) {
        Categoria categoria = Categoria.builder()
                .nome(categoriaRequest.getNome())
                .build();
        Categoria categoriaSalvo = categoriaRepository.save(categoria);


        return categoriaSalvo.response();
    }

    @Override
    public List<CategoriaResponse> listarTodasCategorias() {
        return categoriaRepository.findAll()
                .stream()
                .map(Categoria::response)
                .toList();
    }

    @Override
    public CategoriaResponse buscarCategoriaPorId(Long id) {
        return categoriaRepository.buscarCategoriaPorId(id).response();
    }
}
