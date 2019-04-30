package br.ufma.lsdi.neurodailyweb.repository;

import br.ufma.lsdi.neurodailyweb.model.domain.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
