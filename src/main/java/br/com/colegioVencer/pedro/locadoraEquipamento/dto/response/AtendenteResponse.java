package br.com.colegioVencer.pedro.locadoraEquipamento.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AtendenteResponse {

    private Long codigo;
    private String nome;
    private String login;

}
