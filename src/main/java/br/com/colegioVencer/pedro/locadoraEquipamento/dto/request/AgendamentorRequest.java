package br.com.colegioVencer.pedro.locadoraEquipamento.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AgendamentorRequest {

    private String cpfProfessor;
    private Long idAtendenete;

    private List<Long> listaDeItens;

    private String dataAgendado;
    private String horaAgendado;

}
