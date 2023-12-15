package br.com.farmaciapjr2.springbootapi.service;

import br.com.farmaciapjr2.springbootapi.dto.ReceitaMedicaDTO;
import br.com.farmaciapjr2.springbootapi.entity.Medico;
import br.com.farmaciapjr2.springbootapi.entity.ProdutoCompra;
import br.com.farmaciapjr2.springbootapi.entity.ReceitaMedica;
import br.com.farmaciapjr2.springbootapi.repository.MedicoRepository;
import br.com.farmaciapjr2.springbootapi.repository.ProdutoCompraRepository;
import br.com.farmaciapjr2.springbootapi.repository.ReceitaMedicaRepository;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReceitaMedicaService {

    @Autowired
    private ReceitaMedicaRepository receitaMedicaRepository;

    @Autowired
    private ProdutoCompraRepository produtoCompraRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    public List<ReceitaMedica> getAllReceitaMedicas() {
        return receitaMedicaRepository.findAll();
    }

    public Optional<ReceitaMedica> getReceitaMedicaById(Long id) {
        return receitaMedicaRepository.findById(id);
    }

    public ReceitaMedica createReceitaMedica(@NonNull ReceitaMedicaDTO receitaMedicaDto) {

        if(produtoCompraRepository.existsById(receitaMedicaDto.getId_produtoCompra())
        && medicoRepository.existsById(receitaMedicaDto.getId_produtoCompra())){
            ProdutoCompra pc = produtoCompraRepository.getReferenceById(receitaMedicaDto.getId_produtoCompra());
            Medico medico = medicoRepository.getReferenceById(receitaMedicaDto.getId_produtoCompra());
                   ReceitaMedica receitaMedica = ReceitaMedica.builder()
                            .id(receitaMedicaDto.getId_produtoCompra())
                            .produtoCompra(pc)
                            .medico(medico)
                            .receita(receitaMedicaDto.getReceita())
                            .build();

            return receitaMedicaRepository.save(receitaMedica);
        }

        return ReceitaMedica.builder().build();
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