package br.ufma.lsdi.neurodailyweb.repository;

import br.ufma.lsdi.neurodailyweb.model.domain.Avaliacao;
import br.ufma.lsdi.neurodailyweb.model.dto.AvaliacaoDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Long> {

    @Query("select new br.ufma.lsdi.neurodailyweb.model.dto.AvaliacaoDto" +
            "(a.id, a.dataAvaliacao, a.descricao, a.consideracao, a.nota, a.profissional.id, a.profissional.pessoa.nome, " +
            "a.profissional.profissao.descricao, a.paciente.id) " +
            "from Avaliacao a " +
            "where a.paciente.id = :pacienteId")
    List<AvaliacaoDto> findAvaliacaoByPacienteId(Long pacienteId);
}
