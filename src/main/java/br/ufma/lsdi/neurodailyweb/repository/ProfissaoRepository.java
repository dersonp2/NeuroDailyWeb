package br.ufma.lsdi.neurodailyweb.repository;

import br.ufma.lsdi.neurodailyweb.model.domain.Profissao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfissaoRepository extends JpaRepository<Profissao, Long> {
}
