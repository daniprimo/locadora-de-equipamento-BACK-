package br.com.colegioVencer.pedro.locadoraEquipamento.infra;

import br.com.colegioVencer.pedro.locadoraEquipamento.dominio.Atendente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AtendenteRepository extends JpaRepository<Atendente, Long> {
    @Query(value = "select * from tb_atendente where id = :id", nativeQuery = true )
    Atendente buscarAtendentePeloCodigo(@Param("id") Long id);
}
