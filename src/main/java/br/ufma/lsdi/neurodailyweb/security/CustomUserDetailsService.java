package br.ufma.lsdi.neurodailyweb.security;

import br.ufma.lsdi.neurodailyweb.model.domain.Usuario;
import br.ufma.lsdi.neurodailyweb.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;


    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String cpf) throws UsernameNotFoundException {
        try {
            Usuario usuario = usuarioRepository.findByPessoa_DocumentoPessoal_Cpf(cpf).
                    orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));
            return new UserSystem(usuario, getGrantedAuthorities());
        } catch (Exception e) {
            e.printStackTrace();
            throw new UsernameNotFoundException("Usuario nao encontrado");
        }
    }

    private List<GrantedAuthority> getGrantedAuthorities() throws Exception {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        return authorities;
    }
}
