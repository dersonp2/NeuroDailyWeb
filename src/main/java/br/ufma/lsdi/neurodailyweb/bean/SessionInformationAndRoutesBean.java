package br.ufma.lsdi.neurodailyweb.bean;

import br.ufma.lsdi.neurodailyweb.rewrite.RewriteProvider;
import br.ufma.lsdi.neurodailyweb.security.UserLogged;
import lombok.Getter;
import org.ocpsoft.rewrite.faces.navigate.Navigate;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@Scope("session")
public class SessionInformationAndRoutesBean implements Serializable {

    private static final long serialVersionUID = 2796396046008405052L;

    @Getter
    private UserLogged userLogged;

    public SessionInformationAndRoutesBean(UserLogged userLogged) {
        this.userLogged = userLogged;
    }

    public Navigate navigateToBuscaPaciente() {
        return Navigate.to(RewriteProvider.BUSCAR_PACIENTE);
    }

    public Navigate navigateToCadastroPaciente() {
        return Navigate.to(RewriteProvider.CADASTRAR_PACIENTE);
    }

    public Navigate navigateToBuscaProfissional() {
        return Navigate.to(RewriteProvider.BUSCAR_PROFISSIONAL);
    }

    public Navigate navigateToCadastroProfissional() {
        return Navigate.to(RewriteProvider.CADASTRAR_PROFISSIONAL);
    }
}
