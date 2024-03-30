package br.com.colegioVencer.pedro.locadoraEquipamento.dto.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProfessorResponse {

    private String nome;
    private String cpf;
    private String telefone;

}
