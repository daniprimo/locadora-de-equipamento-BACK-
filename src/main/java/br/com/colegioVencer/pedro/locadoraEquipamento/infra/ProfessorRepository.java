package br.com.colegioVencer.pedro.locadoraEquipamento.infra;

import br.com.colegioVencer.pedro.locadoraEquipamento.dominio.Professor;
import br.com.colegioVencer.pedro.locadoraEquipamento.dto.response.ProfessorResponse;
import lombok.Value;
import lombok.extern.java.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfessorRepository  extends JpaRepository<Professor, String> {

    @Query(value = "select * from tb_professor where cpf LIKE :cpf", nativeQuery = true )
    Professor buscarProfessorPorCpf(@Param("cpf") String cpf);

}
