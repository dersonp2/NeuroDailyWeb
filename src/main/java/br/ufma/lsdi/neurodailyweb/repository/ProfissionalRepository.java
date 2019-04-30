package br.ufma.lsdi.neurodailyweb.repository;

import br.ufma.lsdi.neurodailyweb.model.domain.Profissional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProfissionalRepository extends JpaRepository<Profissional, Long> {

    @Query("select p from Profissional p " +
            "join fetch p.pessoa pa " +
            "join fetch p.profissao pr " +
            "where p.id = :id")
    Profissional findProfissionalById(Long id);

    @Query("select p from Profissional p " +
            "join fetch p.pessoa pa " +
            "join fetch p.profissao pr " +
            "where pa.id = :pessoaId")
    Profissional findProfissionalByPessoaId(Long pessoaId);

    List<Profissional> findByPessoa_NomeContaining(String nome);
}
