package br.com.colegioVencer.pedro.locadoraEquipamento.dominio;

import br.com.colegioVencer.pedro.locadoraEquipamento.dto.response.CategoriaResponse;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity(name = "tb_categoria")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @OneToMany(mappedBy = "categoria", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Item> itens;


    public CategoriaResponse response() {
        return CategoriaResponse.builder()
                .id(this.id)
                .nome(this.nome)
                .build();
    }
}
