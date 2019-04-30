package br.ufma.lsdi.neurodailyweb.security;

import br.ufma.lsdi.neurodailyweb.model.domain.Usuario;
import lombok.Getter;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class UserLogged {

    @Getter
    private Object userLogged;

    public Usuario getUsuarioLogado() {
        Object user;
        UserSystem usuarioLogado;
        user = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (user.equals("anonymousUser")) {
            return null;
        }
        usuarioLogado = (UserSystem) user;
        return usuarioLogado.getUsuario();
    }
}
