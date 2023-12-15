package br.com.farmaciapjr2.springbootapi.service;

import br.com.farmaciapjr2.springbootapi.entity.Fabricante;
import br.com.farmaciapjr2.springbootapi.repository.FabricanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FabricanteService {

    @Autowired
    private FabricanteRepository fabricanteRepository;

    public List<Fabricante> getAllFabricantes() {
        return fabricanteRepository.findAll();
    }

    public Optional<Fabricante> getFabricanteById(Long id) {
        return fabricanteRepository.findById(id);
    }

    public Fabricante createFabricante(Fabricante fabricante) {
        return fabricanteRepository.save(fabricante);
    }

    public Optional<Fabricante> updateFabricante(Long id, Fabricante fabricante) {
        if (fabricanteRepository.existsById(id)) {
            fabricante.setId(id);
            return Optional.of(fabricanteRepository.save(fabricante));
        } else {
            return Optional.empty();
        }
    }

    public boolean deleteFabricante(Long id) {
        if (fabricanteRepository.existsById(id)) {
            fabricanteRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}