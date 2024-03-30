package br.com.colegioVencer.pedro.locadoraEquipamento.dominio;

import br.com.colegioVencer.pedro.locadoraEquipamento.dto.response.AgendamentoResponse;
import br.com.colegioVencer.pedro.locadoraEquipamento.dto.response.AgendamentoRetiradoResponse;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity(name = "tb_agendamento")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Atendente atendente;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Professor professor;

    @ManyToMany
    @JoinTable(
            name = "agendamento_realizados",
            joinColumns = @JoinColumn(name = "agendamento_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id")
    )
    private List<Item> itens;

    private String status;

    private String agendamentoData;
    private String agendamentoDHora;

    private String retiradaData;
    private String retiradaHora;

    private String entregaData;
    private String entregaHora;

    public AgendamentoResponse response() {
        return AgendamentoResponse.builder()
                .atendenteResponse(this.atendente.response())
                .professorResponse(this.professor.response())
                .itens(this.itens
                        .stream()
                        .map(Item::response)
                        .toList())
                .dataAgendado(this.agendamentoData)
                .horaAgendado(this.agendamentoDHora)
                .status(this.status)
                .id(this.id)
                .quantidadeItens(this.itens.size())
                .build();
    }

    public AgendamentoRetiradoResponse RetiradaResponse() {
        return AgendamentoRetiradoResponse.builder()
                .atendenteResponse(this.atendente.response())
                .professorResponse(this.professor.response())
                .itens(this.itens
                        .stream()
                        .map(Item::response)
                        .toList())
                .dataRetirada(this.retiradaData)
                .horaRetirada(this.retiradaHora)
                .status(this.status)
                .id(this.id)
                .quantidadeItens(this.itens.size())
                .build();
    }
}
