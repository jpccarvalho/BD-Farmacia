package br.com.farmaciapjr2.springbootapi.service;

import br.com.farmaciapjr2.springbootapi.dto.ProdutoCompraDTO;
import br.com.farmaciapjr2.springbootapi.entity.Compra;
import br.com.farmaciapjr2.springbootapi.entity.Produto;
import br.com.farmaciapjr2.springbootapi.entity.ProdutoCompra;
import br.com.farmaciapjr2.springbootapi.repository.CompraRepository;
import br.com.farmaciapjr2.springbootapi.repository.ProdutoCompraRepository;
import br.com.farmaciapjr2.springbootapi.repository.ProdutoRepository;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoCompraService {

    @Autowired
    private ProdutoCompraRepository produtoCompraRepository;
    @Autowired
    private CompraRepository compraRepository;
    @Autowired
    private ProdutoRepository produtoRepository;

    public List<ProdutoCompra> getAllProdutoCompras() {
        return produtoCompraRepository.findAll();
    }

    public Optional<ProdutoCompra> getProdutoCompraById(Long id) {
        return produtoCompraRepository.findById(id);
    }

    public ProdutoCompra createProdutoCompra(@NonNull ProdutoCompraDTO produtoCompraDto) {
        if(compraRepository.existsById(produtoCompraDto.getCompraId()) &&
        produtoRepository.existsById(produtoCompraDto.getProdutoId())){
            Compra compra = compraRepository.getReferenceById(produtoCompraDto.getCompraId());
            Produto produto = produtoRepository.getReferenceById(produtoCompraDto.getProdutoId());

            return produtoCompraRepository.save(ProdutoCompra
                    .builder()
                    .id(produtoCompraDto.getId())
                    .compra(compra)
                    .produto(produto)
                    .quantidade(produtoCompraDto.getQuantidade())
                    .build());
        }
        return produtoCompraRepository.save(ProdutoCompra.builder().build());
    }

    public Optional<ProdutoCompra> updateProdutoCompra(Long id, ProdutoCompra produto) {
        if (produtoCompraRepository.existsById(id)) {
            produto.setId(id);
            return Optional.of(produtoCompraRepository.save(produto));
        } else {
            return Optional.empty();
        }
    }

    public boolean deleteProdutoCompra(Long id) {
        if (produtoCompraRepository.existsById(id)) {
            produtoCompraRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}