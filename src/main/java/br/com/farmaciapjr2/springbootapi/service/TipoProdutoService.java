package br.com.farmaciapjr2.springbootapi.service;

import br.com.farmaciapjr2.springbootapi.exceptions.ForeignKeyConstraintException;
import br.com.farmaciapjr2.springbootapi.entity.TipoProduto;
import br.com.farmaciapjr2.springbootapi.repository.TipoProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoProdutoService {

    @Autowired
    private TipoProdutoRepository tipoProdutoRepository;

    public List<TipoProduto> getAllTipoProdutos() {
        return tipoProdutoRepository.findAll();
    }

    public Optional<TipoProduto> getTipoProdutoById(Long id) {
        return tipoProdutoRepository.findById(id);
    }

    public TipoProduto createTipoProduto(TipoProduto tipoProduto) {
        return tipoProdutoRepository.save(tipoProduto);
    }

    public Optional<TipoProduto> updateTipoProduto(Long id, TipoProduto tipoProduto) {
        if (tipoProdutoRepository.existsById(id)) {
            tipoProduto.setId(id);
            return Optional.of(tipoProdutoRepository.save(tipoProduto));
        } else {
            return Optional.empty();
        }
    }

    public boolean deleteTipoProduto(Long id) throws Exception {
        try {
            if (tipoProdutoRepository.existsById(id)) {
                tipoProdutoRepository.deleteById(id);
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            throw new ForeignKeyConstraintException("Cannot delete or update a parent row: a foreign key constraint fails", e);
        }
    }
}