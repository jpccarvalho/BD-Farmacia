package br.com.farmaciapjr2.springbootapi.controller;

import br.com.farmaciapjr2.springbootapi.dto.ProdutoDTO;
import br.com.farmaciapjr2.springbootapi.entity.Produto;
import br.com.farmaciapjr2.springbootapi.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public List<Produto> getAllProdutos() {
        return produtoService.getAllProdutos();
    }

    @GetMapping("/produto-por-cliente/{nome}")
    public List<Produto> getProdutoByNomeCliente(@PathVariable String nome) {
        return produtoService.getProdutoByNomeCliente(nome);
    }

    @GetMapping("/produtos-22-e-23")
    public List<Produto> busca22E23() {
        return produtoService.busca22E23();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> getProdutoById(@PathVariable Long id) {
        return produtoService.getProdutoById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Produto> createProduto(@RequestBody ProdutoDTO produtoDTO) {
        Produto savedProduto = produtoService.createProduto(produtoDTO);
        return ResponseEntity.ok(savedProduto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> updateProduto(@PathVariable Long id, @RequestBody Produto produto) {
        return produtoService.updateProduto(id, produto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduto(@PathVariable Long id) {
        if (produtoService.deleteProduto(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
