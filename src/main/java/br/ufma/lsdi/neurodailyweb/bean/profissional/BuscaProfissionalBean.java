package br.ufma.lsdi.neurodailyweb.bean.profissional;

import br.ufma.lsdi.neurodailyweb.model.domain.Profissional;
import br.ufma.lsdi.neurodailyweb.repository.ProfissionalRepository;
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
public class BuscaProfissionalBean implements Serializable {

    private static final long serialVersionUID = 5846457198003088450L;

    private transient ProfissionalRepository profissionalRepository;

    public BuscaProfissionalBean(ProfissionalRepository profissionalRepository) {
        this.profissionalRepository = profissionalRepository;
    }

    @Getter
    @Setter
    private String nome;
    @Getter
    @Setter
    private Long profissionalId;
    @Getter
    List<Profissional> profissionais;

    @PostConstruct
    private void init() {
        profissionais = new ArrayList<>();
    }

    public void find() {
        profissionais = profissionalRepository.findByPessoa_NomeContaining(nome);
        Messages.addGlobalInfo("Operação realizada com sucesso!");
    }

    public Navigate navigateToCadastroProfissional() {
        WebUtil.flashScope().put("profissionalId", profissionalId);
        return Navigate.to(RewriteProvider.CADASTRAR_PROFISSIONAL);
    }
}
