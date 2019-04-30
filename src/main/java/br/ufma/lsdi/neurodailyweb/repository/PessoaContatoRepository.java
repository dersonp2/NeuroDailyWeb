package br.ufma.lsdi.neurodailyweb.repository;

import br.ufma.lsdi.neurodailyweb.model.domain.PessoaContato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaContatoRepository extends JpaRepository<PessoaContato, Long> {
}
