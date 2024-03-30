package br.com.colegioVencer.pedro.locadoraEquipamento.aplicacao.controller;

import br.com.colegioVencer.pedro.locadoraEquipamento.aplicacao.service.CategoriaService;
import br.com.colegioVencer.pedro.locadoraEquipamento.aplicacao.service.ItemService;
import br.com.colegioVencer.pedro.locadoraEquipamento.dto.request.CategoriaRequest;
import br.com.colegioVencer.pedro.locadoraEquipamento.dto.request.ItemRequest;
import br.com.colegioVencer.pedro.locadoraEquipamento.dto.response.CategoriaResponse;
import br.com.colegioVencer.pedro.locadoraEquipamento.dto.response.ItemResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @Autowired
    private CategoriaService categoriaService;

    @PostMapping
    public ResponseEntity<ItemResponse> criarItem(@RequestBody ItemRequest itemRequest) {
        return ResponseEntity.ok(itemService.criarItem(itemRequest));
    }

    @GetMapping
    public ResponseEntity<List<ItemResponse>> listarTodosItens(){
        return ResponseEntity.ok(itemService.buscarTodosItens());
    }

    @GetMapping("/buscarItemPeloId/{id}")
    public  ResponseEntity<ItemResponse> buscarItemPeloId(@PathVariable("id") Long id){
        return ResponseEntity.ok(itemService.buscarItemPeloId(id));
    }

    @PostMapping("/categoria")
    public ResponseEntity<CategoriaResponse> criarCategoria(@RequestBody CategoriaRequest categoriaRequest){
        return ResponseEntity.ok(categoriaService.criaCategoria(categoriaRequest));
    }

    @GetMapping("/categoria")
    public ResponseEntity<List<CategoriaResponse>> buscarTodasCategorias() {
        return ResponseEntity.ok(categoriaService.listarTodasCategorias());
    }

    @GetMapping("/categoria/buscarPorId/{id}")
    public ResponseEntity<CategoriaResponse> buscarCategoriaPorId(@PathVariable("id") Long id) {
        return ResponseEntity.ok(categoriaService.buscarCategoriaPorId(id));
    }

}
