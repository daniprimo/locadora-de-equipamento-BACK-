package br.com.colegioVencer.pedro.locadoraEquipamento.infra;

import br.com.colegioVencer.pedro.locadoraEquipamento.dominio.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    @Query(value = "select * from tb_categoria where id = :id", nativeQuery = true )
    Categoria buscarCategoriaPorId(Long id);
}
