package br.ufma.lsdi.neurodailyweb.bean.paciente;

import br.ufma.lsdi.neurodailyweb.model.domain.Cidade;
import br.ufma.lsdi.neurodailyweb.model.domain.Endereco;
import br.ufma.lsdi.neurodailyweb.model.domain.Paciente;
import br.ufma.lsdi.neurodailyweb.model.domain.Sexo;
import br.ufma.lsdi.neurodailyweb.model.enums.EstadoEnum;
import br.ufma.lsdi.neurodailyweb.repository.CidadeRepository;
import br.ufma.lsdi.neurodailyweb.repository.PacienteRepository;
import br.ufma.lsdi.neurodailyweb.repository.SexoRepository;
import br.ufma.lsdi.neurodailyweb.service.PacienteService;
import br.ufma.lsdi.neurodailyweb.util.WebUtil;
import lombok.Getter;
import lombok.Setter;
import org.omnifaces.util.Messages;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.util.List;

@Component
@Scope("view")
public class CadastroPacienteBean implements Serializable {

    private static final long serialVersionUID = 5846457198003088450L;

    private transient CidadeRepository cidadeRepository;
    private transient PacienteRepository pacienteRepository;
    private transient PacienteService pacienteService;
    private transient SexoRepository sexoRepository;

    public CadastroPacienteBean(CidadeRepository cidadeRepository,
                                PacienteRepository pacienteRepository,
                                PacienteService pacienteService,
                                SexoRepository sexoRepository) {
        this.cidadeRepository = cidadeRepository;
        this.pacienteRepository = pacienteRepository;
        this.pacienteService = pacienteService;
        this.sexoRepository = sexoRepository;
    }

    @Getter
    @Setter
    private boolean edicao;
    @Getter
    @Setter
    private Paciente paciente;
    @Getter
    private List<Cidade> cidades;
    @Getter
    private List<Sexo> sexos;


    @PostConstruct
    private void init() {
        if (WebUtil.flashScope().get("pacienteId") != null) {

            paciente = pacienteRepository.findPacienteById((Long) WebUtil.flashScope().get("pacienteId"));
            edicao = true;
        } else {

            renew();
        }
        cidades = cidadeRepository.findByEstado_Id(EstadoEnum.MARANHAO.getValue());
        sexos = sexoRepository.findAll();
    }

    public void renew() {
        paciente = new Paciente();
        paciente.getResponsavel().setEndereco(new Endereco());
        edicao = false;
    }

    public void save() {
        paciente = pacienteService.save(paciente);
        edicao = true;
        Messages.addGlobalInfo("Operação realizada com sucesso!");
    }
}
