package br.com.colegioVencer.pedro.locadoraEquipamento.aplicacao.service;

import br.com.colegioVencer.pedro.locadoraEquipamento.dto.request.ItemRequest;
import br.com.colegioVencer.pedro.locadoraEquipamento.dto.response.ItemResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ItemService {

    ItemResponse criarItem(ItemRequest itemRequest);

    List<ItemResponse> buscarTodosItens();

    ItemResponse buscarItemPeloId(Long id);
}
