package br.com.farmaciapjr2.controller;

import br.com.farmaciapjr2.model.ReceitaMedica;
import br.com.farmaciapjr2.service.ReceitaMedicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/receitaMedicas")
public class ReceitaMedicaController {

    @Autowired
    private ReceitaMedicaService receitaMedicaService;

    @GetMapping
    public List<ReceitaMedica> getAllReceitaMedicas() {
        return receitaMedicaService.getAllReceitaMedicas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReceitaMedica> getReceitaMedicaById(@PathVariable Long id) {
        return receitaMedicaService.getReceitaMedicaById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ReceitaMedica> createReceitaMedica(@RequestBody ReceitaMedica receitaMedica) {
        ReceitaMedica savedReceitaMedica = receitaMedicaService.createReceitaMedica(receitaMedica);
        return ResponseEntity.ok(savedReceitaMedica);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReceitaMedica> updateReceitaMedica(@PathVariable Long id, @RequestBody ReceitaMedica receitaMedica) {
        return receitaMedicaService.updateReceitaMedica(id, receitaMedica)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReceitaMedica(@PathVariable Long id) {
        if (receitaMedicaService.deleteReceitaMedica(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
