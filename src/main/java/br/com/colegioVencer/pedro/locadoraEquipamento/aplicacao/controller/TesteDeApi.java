package br.com.colegioVencer.pedro.locadoraEquipamento.aplicacao.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teste")
public class TesteDeApi {

    @GetMapping
    public ResponseEntity<String> testandoAPI() {
        return ResponseEntity.ok("teste");
    }

}
