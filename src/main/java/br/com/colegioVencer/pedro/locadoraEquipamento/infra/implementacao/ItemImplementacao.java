package br.com.colegioVencer.pedro.locadoraEquipamento.infra.implementacao;

import br.com.colegioVencer.pedro.locadoraEquipamento.aplicacao.service.CategoriaService;
import br.com.colegioVencer.pedro.locadoraEquipamento.aplicacao.service.ItemService;
import br.com.colegioVencer.pedro.locadoraEquipamento.dominio.Item;
import br.com.colegioVencer.pedro.locadoraEquipamento.dto.request.ItemRequest;
import br.com.colegioVencer.pedro.locadoraEquipamento.dto.response.ItemResponse;
import br.com.colegioVencer.pedro.locadoraEquipamento.infra.CategoriaRepository;
import br.com.colegioVencer.pedro.locadoraEquipamento.infra.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemImplementacao implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public ItemResponse criarItem(ItemRequest itemRequest) {
        Item item = Item.builder()
                .nome(itemRequest.getNomeDoItem())
                .categoria(categoriaRepository.buscarCategoriaPorId(itemRequest.getId_categoria()))
                .build();
        Item itemSalvo = itemRepository.save(item);

        return itemSalvo.response();
    }

    @Override
    public List<ItemResponse> buscarTodosItens() {
        return itemRepository.findAll()
                .stream()
                .map(Item::response)
                .toList();
    }

    @Override
    public ItemResponse buscarItemPeloId(Long id) {
        return itemRepository.buscarItemPeloCodigo(id).response();
    }
}
