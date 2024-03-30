package br.com.colegioVencer.pedro.locadoraEquipamento.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RetirarAgendamentoRequest {
    private Long id;
    private String data;

    private String hora;
}
