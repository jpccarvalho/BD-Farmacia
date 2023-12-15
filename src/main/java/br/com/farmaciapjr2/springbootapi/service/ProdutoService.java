package br.com.farmaciapjr2.springbootapi.service;

import br.com.farmaciapjr2.springbootapi.dto.ProdutoDTO;
import br.com.farmaciapjr2.springbootapi.entity.Fabricante;
import br.com.farmaciapjr2.springbootapi.entity.Produto;
import br.com.farmaciapjr2.springbootapi.entity.TipoProduto;
import br.com.farmaciapjr2.springbootapi.repository.FabricanteRepository;
import br.com.farmaciapjr2.springbootapi.repository.ProdutoRepository;
import br.com.farmaciapjr2.springbootapi.repository.TipoProdutoRepository;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private TipoProdutoRepository tipoProdutoRepository;

    @Autowired
    private FabricanteRepository fabricanteRepository;

    public List<Produto> getAllProdutos() {
        return produtoRepository.findAll();
    }
    public List<Produto> getProdutoByNomeCliente(String nome) {
        return produtoRepository.getProdutoByNomeCliente(nome);
    }

    public List<Produto> busca22E23() {
        return produtoRepository.busca22E23();
    }

    public Optional<Produto> getProdutoById(Long id) {
        return produtoRepository.findById(id);
    }

    public Produto createProduto(@NonNull ProdutoDTO produtoDTO) {
        if(tipoProdutoRepository.existsById(produtoDTO.getTipoProdutoId())
        && fabricanteRepository.existsById(produtoDTO.getFabricanteId())){
            Fabricante fabricante = fabricanteRepository.getReferenceById(produtoDTO.getFabricanteId());
            TipoProduto tp = tipoProdutoRepository.getReferenceById(produtoDTO.getFabricanteId());

            return produtoRepository.save(Produto
                    .builder()
                    .id(produtoDTO.getId())
                    .tipoProduto(tp)
                    .fabricante(fabricante)
                    .produto(produtoDTO.getProduto())
                    .designacao(produtoDTO.getDesignacao())
                    .composicao(produtoDTO.getComposicao())
                    .precoVenda(produtoDTO.getPrecoVenda())
                    .build());
        }
        return produtoRepository.save(Produto.builder().build());
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