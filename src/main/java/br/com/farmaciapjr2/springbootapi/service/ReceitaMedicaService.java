package br.com.farmaciapjr2.springbootapi.service;

import br.com.farmaciapjr2.springbootapi.model.ReceitaMedica;
import br.com.farmaciapjr2.springbootapi.repository.ReceitaMedicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReceitaMedicaService {

    @Autowired
    private ReceitaMedicaRepository receitaMedicaRepository;

    public List<ReceitaMedica> getAllReceitaMedicas() {
        return receitaMedicaRepository.findAll();
    }

    public Optional<ReceitaMedica> getReceitaMedicaById(Long id) {
        return receitaMedicaRepository.findById(id);
    }

    public ReceitaMedica createReceitaMedica(ReceitaMedica receitaMedica) {
        return receitaMedicaRepository.save(receitaMedica);
    }

    public Optional<ReceitaMedica> updateReceitaMedica(Long id, ReceitaMedica receitaMedica) {
        if (receitaMedicaRepository.existsById(id)) {
            receitaMedica.setId(id);
            return Optional.of(receitaMedicaRepository.save(receitaMedica));
        } else {
            return Optional.empty();
        }
    }

    public boolean deleteReceitaMedica(Long id) {
        if (receitaMedicaRepository.existsById(id)) {
            receitaMedicaRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}