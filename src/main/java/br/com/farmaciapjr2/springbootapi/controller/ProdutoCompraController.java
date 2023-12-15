package br.com.farmaciapjr2.springbootapi.controller;

import br.com.farmaciapjr2.springbootapi.dto.ProdutoCompraDTO;
import br.com.farmaciapjr2.springbootapi.entity.ProdutoCompra;
import br.com.farmaciapjr2.springbootapi.service.ProdutoCompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produtoCompras")
public class ProdutoCompraController {

    @Autowired
    private ProdutoCompraService produtoCompraService;

    @GetMapping
    public List<ProdutoCompra> getAllProdutoCompras() {
        return produtoCompraService.getAllProdutoCompras();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoCompra> getProdutoCompraById(@PathVariable Long id) {
        return produtoCompraService.getProdutoCompraById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ProdutoCompra> createProdutoCompra(@RequestBody ProdutoCompraDTO produtoCompraDto) {
        ProdutoCompra savedProdutoCompra = produtoCompraService.createProdutoCompra(produtoCompraDto);
        return ResponseEntity.ok(savedProdutoCompra);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoCompra> updateProdutoCompra(@PathVariable Long id, @RequestBody ProdutoCompra produtoCompra) {
        return produtoCompraService.updateProdutoCompra(id, produtoCompra)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProdutoCompra(@PathVariable Long id) {
        if (produtoCompraService.deleteProdutoCompra(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
