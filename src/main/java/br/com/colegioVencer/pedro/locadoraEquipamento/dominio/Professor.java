package br.com.colegioVencer.pedro.locadoraEquipamento.dominio;


import br.com.colegioVencer.pedro.locadoraEquipamento.dto.response.ProfessorResponse;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity(name = "tb_professor")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Professor{

    @Id
    private String cpf;

    private String nome;

    private String telefone;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "professor")
    private List<Agendamento> agendamentos;

    public ProfessorResponse response() {
        return ProfessorResponse.builder()
                .nome(this.nome)
                .cpf(this.cpf)
                .telefone(this.telefone)
                .build();
    }
}
