package br.com.colegioVencer.pedro.locadoraEquipamento.aplicacao.controller;

import br.com.colegioVencer.pedro.locadoraEquipamento.aplicacao.service.AtendenteService;
import br.com.colegioVencer.pedro.locadoraEquipamento.dto.request.AtendenteRequest;
import br.com.colegioVencer.pedro.locadoraEquipamento.dto.response.AtendenteResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/atendente")
public class AtendenteController {

    @Autowired
    private AtendenteService atendenteService;

    @PostMapping
    public ResponseEntity<AtendenteResponse> criarNovoAtendente(@RequestBody AtendenteRequest atendenteRequest){
        return ResponseEntity.ok(atendenteService.criarNovoAtendente(atendenteRequest));
    }

    @GetMapping
    public ResponseEntity<List<AtendenteResponse>> listarTodosAtendente() {
        return  ResponseEntity.ok(atendenteService.buscarTodos());
    }

    @GetMapping("/atendentePorCodigo/{id}")
    public ResponseEntity<AtendenteResponse> buscarAtendentePorId(@PathVariable("id") Long id) {
        return ResponseEntity.ok(atendenteService.buscarAtendentePorCodigoInterno(id));
    }

}
