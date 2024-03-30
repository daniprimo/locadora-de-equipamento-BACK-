package br.com.colegioVencer.pedro.locadoraEquipamento.infra;

import br.com.colegioVencer.pedro.locadoraEquipamento.dominio.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

    @Query(value = "select * from tb_item where id = :id", nativeQuery = true )
    Item buscarItemPeloCodigo(Long id);
}
