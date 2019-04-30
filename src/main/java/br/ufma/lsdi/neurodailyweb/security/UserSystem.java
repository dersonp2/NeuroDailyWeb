package br.ufma.lsdi.neurodailyweb.security;

import br.ufma.lsdi.neurodailyweb.model.domain.Usuario;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class UserSystem extends User {

    private static final long serialVersionUID = 1L;

    @Getter
    private Usuario usuario;

    public UserSystem(Usuario usuario, Collection<? extends GrantedAuthority> authorities) {
        super(usuario.getPessoa().getDocumentoPessoal().getCpf(), usuario.getSenha(), authorities);
        this.usuario = usuario;
    }
}
