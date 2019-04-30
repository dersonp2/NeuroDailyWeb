package br.ufma.lsdi.neurodailyweb.service;

import br.ufma.lsdi.neurodailyweb.model.domain.Profissional;
import br.ufma.lsdi.neurodailyweb.model.domain.Usuario;
import br.ufma.lsdi.neurodailyweb.repository.ProfissionalRepository;
import br.ufma.lsdi.neurodailyweb.repository.UsuarioRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

@Service
public class ProfissionalService {

    private PasswordEncoder encoder;
    private ProfissionalRepository profissionalRepository;
    private UsuarioRepository usuarioRepository;

    public ProfissionalService(PasswordEncoder encoder, ProfissionalRepository profissionalRepository,
                               UsuarioRepository usuarioRepository) {
        this.encoder = encoder;
        this.profissionalRepository = profissionalRepository;
        this.usuarioRepository = usuarioRepository;
    }

    @Transactional
    public Profissional save(Profissional profissional) {

        profissional.setDataCadastro(new Date());
        profissional.setMatricula(UUID.randomUUID().toString());
        profissional = profissionalRepository.save(profissional);

        String senha = profissional.getPessoa().getDocumentoPessoal().getCpf().substring(0, 3) + "@neuro";

        Usuario usuario = new Usuario();
        usuario.setPessoa(profissional.getPessoa());
        usuario.setSenha(encoder.encode(senha));
        usuario.setAtivo(Boolean.TRUE);
        usuarioRepository.save(usuario);

        return profissional;
    }
}
