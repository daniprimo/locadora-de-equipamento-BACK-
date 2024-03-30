package br.com.colegioVencer.pedro.locadoraEquipamento.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AtendenteRequest {

    private String nome;
    private String login;
    private String senha;

}
