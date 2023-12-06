package br.com.farmaciapjr2.service;

import br.com.farmaciapjr2.model.Produto;
import br.com.farmaciapjr2.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> getAllProdutos() {
        return produtoRepository.findAll();
    }

    public Optional<Produto> getProdutoById(Long id) {
        return produtoRepository.findById(id);
    }

    public Produto createProduto(Produto produto) {
        // Lógica de validação ou processamento adicional, se necessário
        return produtoRepository.save(produto);
    }

    public Optional<Produto> updateProduto(Long id, Produto produto) {
        if (produtoRepository.existsById(id)) {
            produto.setId(id);
            return Optional.of(produtoRepository.save(produto));
        } else {
            return Optional.empty();
        }
    }

    public boolean deleteProduto(Long id) {
        if (produtoRepository.existsById(id)) {
            produtoRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}