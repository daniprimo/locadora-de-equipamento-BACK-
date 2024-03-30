package br.com.colegioVencer.pedro.locadoraEquipamento.dominio;

import br.com.colegioVencer.pedro.locadoraEquipamento.dto.response.ItemResponse;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity(name = "tb_item")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @ManyToOne
    private Categoria categoria;

    @ManyToMany(mappedBy = "itens")
    private List<Agendamento> agendamento;


    public ItemResponse response() {
        return ItemResponse.builder()
                .categoriaResponse(categoria.response())
                .codigo(this.id)
                .nomeDoItem(this.nome)
                .build();
    }
}
