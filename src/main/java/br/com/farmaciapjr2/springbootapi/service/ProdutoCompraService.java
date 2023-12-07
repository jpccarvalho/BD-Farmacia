package br.com.farmaciapjr2.springbootapi.service;

import br.com.farmaciapjr2.springbootapi.model.ProdutoCompra;
import br.com.farmaciapjr2.springbootapi.repository.ProdutoCompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoCompraService {

    @Autowired
    private ProdutoCompraRepository produtoRepository;

    public List<ProdutoCompra> getAllProdutoCompras() {
        return produtoRepository.findAll();
    }

    public Optional<ProdutoCompra> getProdutoCompraById(Long id) {
        return produtoRepository.findById(id);
    }

    public ProdutoCompra createProdutoCompra(ProdutoCompra produto) {
        // Lógica de validação ou processamento adicional, se necessário
        return produtoRepository.save(produto);
    }

    public Optional<ProdutoCompra> updateProdutoCompra(Long id, ProdutoCompra produto) {
        if (produtoRepository.existsById(id)) {
            produto.setId(id);
            return Optional.of(produtoRepository.save(produto));
        } else {
            return Optional.empty();
        }
    }

    public boolean deleteProdutoCompra(Long id) {
        if (produtoRepository.existsById(id)) {
            produtoRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}