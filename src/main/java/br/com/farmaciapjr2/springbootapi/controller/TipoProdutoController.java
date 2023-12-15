package br.com.farmaciapjr2.springbootapi.controller;

import br.com.farmaciapjr2.springbootapi.entity.TipoProduto;
import br.com.farmaciapjr2.springbootapi.service.TipoProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tipoProdutos")
public class TipoProdutoController {

    @Autowired
    private TipoProdutoService tipoProdutoService;

    @GetMapping
    public List<TipoProduto> getAllTipoProdutos() {
        return tipoProdutoService.getAllTipoProdutos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoProduto> getTipoProdutoById(@PathVariable Long id) {
        return tipoProdutoService.getTipoProdutoById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<TipoProduto> createTipoProduto(@RequestBody TipoProduto tipoProduto) {
        TipoProduto savedTipoProduto = tipoProdutoService.createTipoProduto(tipoProduto);
        return ResponseEntity.ok(savedTipoProduto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoProduto> updateTipoProduto(@PathVariable Long id, @RequestBody TipoProduto tipoProduto) {
        return tipoProdutoService.updateTipoProduto(id, tipoProduto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTipoProduto(@PathVariable Long id) throws Exception {
        if (tipoProdutoService.deleteTipoProduto(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
