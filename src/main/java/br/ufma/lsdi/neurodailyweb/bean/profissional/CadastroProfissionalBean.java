package br.ufma.lsdi.neurodailyweb.bean.profissional;

import br.ufma.lsdi.neurodailyweb.model.domain.*;
import br.ufma.lsdi.neurodailyweb.model.enums.EstadoEnum;
import br.ufma.lsdi.neurodailyweb.repository.CidadeRepository;
import br.ufma.lsdi.neurodailyweb.repository.ProfissaoRepository;
import br.ufma.lsdi.neurodailyweb.repository.ProfissionalRepository;
import br.ufma.lsdi.neurodailyweb.repository.SexoRepository;
import br.ufma.lsdi.neurodailyweb.service.ProfissionalService;
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
public class CadastroProfissionalBean implements Serializable {

    private static final long serialVersionUID = 4202098827205154430L;

    private transient CidadeRepository cidadeRepository;
    private transient ProfissaoRepository profissaoRepository;
    private transient ProfissionalRepository profissionalRepository;
    private transient ProfissionalService profissionalService;
    private transient SexoRepository sexoRepository;

    public CadastroProfissionalBean(CidadeRepository cidadeRepository, ProfissaoRepository profissaoRepository,
                                    ProfissionalRepository profissionalRepository,
                                    ProfissionalService profissionalService,
                                    SexoRepository sexoRepository) {
        this.cidadeRepository = cidadeRepository;
        this.profissaoRepository = profissaoRepository;
        this.profissionalRepository = profissionalRepository;
        this.profissionalService = profissionalService;
        this.sexoRepository = sexoRepository;
    }

    @Getter
    @Setter
    private boolean edicao;
    @Getter
    @Setter
    private Profissional profissional;
    @Getter
    private List<Cidade> cidades;
    @Getter
    private List<Profissao> profissoes;
    @Getter
    private List<Sexo> sexos;

    @PostConstruct
    private void init() {
        if (WebUtil.flashScope().get("profissionalId") != null) {
            profissional = profissionalRepository.findProfissionalById((Long) WebUtil.flashScope().get("profissionalId"));
            edicao = true;
        } else {
            renew();
        }

        cidades = cidadeRepository.findByEstado_Id(EstadoEnum.MARANHAO.getValue());
        profissoes = profissaoRepository.findAll();
        sexos = sexoRepository.findAll();
    }

    public void save() {
        if (edicao) {
            profissional = profissionalRepository.save(profissional);
        } else {
            profissional = profissionalService.save(profissional);
            edicao = true;
        }
        Messages.addGlobalInfo("Operação realizada com sucesso!");
    }

    public void renew() {
        profissional = new Profissional();
        profissional.getPessoa().setEndereco(new Endereco());
        edicao = false;
    }

}
