package br.com.farmaciapjr2.springbootapi.controller;

import br.com.farmaciapjr2.springbootapi.entity.Fabricante;
import br.com.farmaciapjr2.springbootapi.service.FabricanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fabricantes")
public class FabricanteController {

    @Autowired
    private FabricanteService fabricantesService;

    @GetMapping
    public List<Fabricante> getAllFabricantes() {
        return fabricantesService.getAllFabricantes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fabricante> getFabricanteById(@PathVariable Long id) {
        return fabricantesService.getFabricanteById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Fabricante> createFabricante(@RequestBody Fabricante fabricantes) {
        Fabricante savedFabricante = fabricantesService.createFabricante(fabricantes);
        return ResponseEntity.ok(savedFabricante);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Fabricante> updateFabricante(@PathVariable Long id, @RequestBody Fabricante fabricantes) {
        return fabricantesService.updateFabricante(id, fabricantes)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFabricante(@PathVariable Long id) {
        if (fabricantesService.deleteFabricante(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
