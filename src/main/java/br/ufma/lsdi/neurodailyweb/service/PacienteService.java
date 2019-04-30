package br.ufma.lsdi.neurodailyweb.service;

import br.ufma.lsdi.neurodailyweb.model.domain.Paciente;
import br.ufma.lsdi.neurodailyweb.repository.PacienteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PacienteService {

    private PacienteRepository pacienteRepository;

    public PacienteService(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    @Transactional
    public Paciente save(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }
}
