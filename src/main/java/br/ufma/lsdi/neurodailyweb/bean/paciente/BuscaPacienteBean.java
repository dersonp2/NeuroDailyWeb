package br.ufma.lsdi.neurodailyweb.bean.paciente;

import br.ufma.lsdi.neurodailyweb.model.domain.Paciente;
import br.ufma.lsdi.neurodailyweb.repository.PacienteRepository;
import br.ufma.lsdi.neurodailyweb.rewrite.RewriteProvider;
import br.ufma.lsdi.neurodailyweb.util.WebUtil;
import lombok.Getter;
import lombok.Setter;
import org.ocpsoft.rewrite.faces.navigate.Navigate;
import org.omnifaces.util.Messages;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Component
@Scope("view")
public class BuscaPacienteBean implements Serializable {

    private static final long serialVersionUID = 5846457198003088450L;

    private transient PacienteRepository pacienteRepository;

    public BuscaPacienteBean(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    @Getter
    @Setter
    private String nome;
    @Getter
    @Setter
    private Long pacienteId;
    @Getter
    List<Paciente> pacientes;

    @PostConstruct
    private void init() {
        pacientes = new ArrayList<>();
    }

    public void find() {
        pacientes = pacienteRepository.findByPessoa_NomeContaining(nome);
        Messages.addGlobalInfo("Operação realizada com sucesso!");
    }

    public Navigate navigateToAvaliacaoPaciente() {
        WebUtil.flashScope().put("pacienteId", pacienteId);
        return Navigate.to(RewriteProvider.AVALIACAO_PACIENTE);
    }

    public Navigate navigateToCadastroPaciente() {
        WebUtil.flashScope().put("pacienteId", pacienteId);
        return Navigate.to(RewriteProvider.CADASTRAR_PACIENTE);
    }

    public Navigate navigateToFormularioAvaliacao() {
        WebUtil.flashScope().put("pacienteId", pacienteId);
        return Navigate.to(RewriteProvider.FORMULARIO_AVALIACAO);
    }
}
