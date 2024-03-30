package br.com.colegioVencer.pedro.locadoraEquipamento.dto.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AgendamentoResponse {

    private Long id;
    private String status;
    private AtendenteResponse atendenteResponse;
    private ProfessorResponse professorResponse;
    private Integer quantidadeItens;
    private List<ItemResponse> itens;
    private String dataAgendado;
    private String horaAgendado;

}
