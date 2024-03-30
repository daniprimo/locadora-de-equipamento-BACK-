package br.com.colegioVencer.pedro.locadoraEquipamento.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProfessorRequest {

    private String nome;
    private String cpf;
    private String telefone;

}
