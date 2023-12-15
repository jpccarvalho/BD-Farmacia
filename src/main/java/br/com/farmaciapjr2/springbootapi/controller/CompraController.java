package br.com.farmaciapjr2.springbootapi.controller;

import br.com.farmaciapjr2.springbootapi.dto.CompraDTO;
import br.com.farmaciapjr2.springbootapi.entity.Compra;
import br.com.farmaciapjr2.springbootapi.service.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/compras")
public class CompraController {

    @Autowired
    private CompraService compraService;

    @GetMapping
    public List<Compra> getAllCompras() {
        return compraService.getAllCompras();
    }
    @GetMapping("/compra-by-nome/{nome}")
    public List<Compra> findCompraByNome(@PathVariable String nome) {
        return compraService.findCompraByNome(nome);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Compra> getCompraById(@PathVariable Long id) {
        return compraService.getCompraById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Compra> createCompra(@RequestBody CompraDTO compra) {
        Compra savedCompra = compraService.createCompra(compra);
        return ResponseEntity.ok(savedCompra);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Compra> updateCompra(@PathVariable Long id, @RequestBody Compra compra) {
        return compraService.updateCompra(id, compra)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCompra(@PathVariable Long id) {
        if (compraService.deleteCompra(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
