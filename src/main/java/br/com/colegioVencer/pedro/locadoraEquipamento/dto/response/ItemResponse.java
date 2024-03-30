package br.com.colegioVencer.pedro.locadoraEquipamento.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ItemResponse {

    private Long codigo;
    private String nomeDoItem;
    private CategoriaResponse categoriaResponse;

}
