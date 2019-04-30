package br.ufma.lsdi.neurodailyweb.bean.avaliacao;

import br.ufma.lsdi.neurodailyweb.model.domain.Avaliacao;
import br.ufma.lsdi.neurodailyweb.model.domain.Paciente;
import br.ufma.lsdi.neurodailyweb.model.domain.Profissional;
import br.ufma.lsdi.neurodailyweb.repository.AvaliacaoRepository;
import br.ufma.lsdi.neurodailyweb.repository.PacienteRepository;
import br.ufma.lsdi.neurodailyweb.repository.ProfissionalRepository;
import br.ufma.lsdi.neurodailyweb.security.UserLogged;
import br.ufma.lsdi.neurodailyweb.util.WebUtil;
import lombok.Getter;
import lombok.Setter;
import org.omnifaces.util.Messages;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

@Component
@Scope("view")
public class FormularioAvaliacaoBean implements Serializable {

    private static final long serialVersionUID = 6931058971242919518L;

    private AvaliacaoRepository avaliacaoRepository;
    private PacienteRepository pacienteRepository;
    private ProfissionalRepository profissionalRepository;
    private UserLogged userLogged;

    public FormularioAvaliacaoBean(AvaliacaoRepository avaliacaoRepository, PacienteRepository pacienteRepository,
                                   ProfissionalRepository profissionalRepository, UserLogged userLogged) {
        this.avaliacaoRepository = avaliacaoRepository;
        this.pacienteRepository = pacienteRepository;
        this.profissionalRepository = profissionalRepository;
        this.userLogged = userLogged;
    }

    @Getter
    @Setter
    private Avaliacao avaliacao;
    @Getter
    @Setter
    private Paciente paciente;
    @Getter
    @Setter
    private Profissional profissional;

    @PostConstruct
    private void init() {
        paciente = pacienteRepository.findPacienteById((Long) WebUtil.flashScope().get("pacienteId"));
        profissional = profissionalRepository
                .findProfissionalByPessoaId(userLogged.getUsuarioLogado().getPessoa().getId());
        avaliacao = new Avaliacao();

        WebUtil.flashScope().keep("pacienteId");
    }

    public void save() {
        if (avaliacao.getId() == null) {
            avaliacao.setPaciente(paciente);
            avaliacao.setProfissional(profissional);
            avaliacao.setDataAvaliacao(new Date());
        }
        avaliacao = avaliacaoRepository.save(avaliacao);
        Messages.addGlobalInfo("Operação realizada com sucesso!");
    }

    public int getIdade() {
        LocalDate nascimento = Instant.ofEpochMilli(paciente.getPessoa().getNascimento().getTime())
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
        final LocalDate today = LocalDate.now();
        final Period periodo = Period.between(nascimento, today);
        return periodo.getYears();
    }
}
