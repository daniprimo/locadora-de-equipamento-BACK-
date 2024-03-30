package br.com.colegioVencer.pedro.locadoraEquipamento.dominio;

import br.com.colegioVencer.pedro.locadoraEquipamento.dto.response.AtendenteResponse;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity(name = "tb_atendente")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Atendente{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String login;
    private String senha;

    @OneToMany(mappedBy = "atendente")
    private List<Agendamento> agendamentos;


    public AtendenteResponse response() {

        return AtendenteResponse.builder()
                .codigo(this.id)
                .nome(this.nome)
                .login(this.login)
                .build();
    }
}
