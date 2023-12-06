package br.com.farmaciapjr2.service;

import br.com.farmaciapjr2.model.Medico;
import br.com.farmaciapjr2.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository medicoRepository;

    public List<Medico> getAllMedicos() {
        return medicoRepository.findAll();
    }

    public Optional<Medico> getMedicoById(Long id) {
        return medicoRepository.findById(id);
    }

    public Medico createMedico(Medico medico) {
        // Lógica de validação ou processamento adicional, se necessário
        return medicoRepository.save(medico);
    }

    public Optional<Medico> updateMedico(Long id, Medico medico) {
        if (medicoRepository.existsById(id)) {
            medico.setId(id);
            return Optional.of(medicoRepository.save(medico));
        } else {
            return Optional.empty();
        }
    }

    public boolean deleteMedico(Long id) {
        if (medicoRepository.existsById(id)) {
            medicoRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}