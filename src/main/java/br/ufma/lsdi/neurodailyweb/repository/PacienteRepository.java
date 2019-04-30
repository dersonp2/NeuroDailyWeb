package br.ufma.lsdi.neurodailyweb.repository;

import br.ufma.lsdi.neurodailyweb.model.domain.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {

    @Query("select p from Paciente p " +
            "join fetch p.pessoa pa " +
            "join fetch pa.documentoPessoal dp1 " +
            "join fetch p.responsavel re " +
            "join fetch re.documentoPessoal dp2 " +
            "join fetch re.endereco ed " +
            "where p.id = :id")
    Paciente findPacienteById(Long id);

    List<Paciente> findByPessoa_NomeContaining(String nome);
}
