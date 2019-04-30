package br.ufma.lsdi.neurodailyweb.bean.paciente;

import br.ufma.lsdi.neurodailyweb.model.domain.Paciente;
import br.ufma.lsdi.neurodailyweb.model.dto.AvaliacaoDto;
import br.ufma.lsdi.neurodailyweb.repository.AvaliacaoRepository;
import br.ufma.lsdi.neurodailyweb.repository.PacienteRepository;
import br.ufma.lsdi.neurodailyweb.util.WebUtil;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.util.List;

@Component
@Scope("view")
public class AvaliacaoPacienteBean implements Serializable {

    private static final long serialVersionUID = 5846457198003088450L;

    private transient AvaliacaoRepository avaliacaoRepository;
    private transient PacienteRepository pacienteRepository;

    public AvaliacaoPacienteBean(AvaliacaoRepository avaliacaoRepository, PacienteRepository pacienteRepository) {
        this.avaliacaoRepository = avaliacaoRepository;
        this.pacienteRepository = pacienteRepository;
    }

    @Getter
    @Setter
    private Paciente paciente;
    @Getter
    List<AvaliacaoDto> avaliacoes;

    @PostConstruct
    private void init() {
        paciente = pacienteRepository.findPacienteById((Long) WebUtil.flashScope().get("pacienteId"));
        avaliacoes = avaliacaoRepository.findAvaliacaoByPacienteId(paciente.getId());
        WebUtil.flashScope().keep("pacienteId");
    }
}
