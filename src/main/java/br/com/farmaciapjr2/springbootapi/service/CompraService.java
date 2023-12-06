package br.com.farmaciapjr2.springbootapi.service;

import br.com.farmaciapjr2.springbootapi.model.Compra;
import br.com.farmaciapjr2.springbootapi.repository.CompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompraService {

    @Autowired
    private CompraRepository compraRepository;

    public List<Compra> getAllCompras() {
        return compraRepository.findAll();
    }

    public List<Compra> findCompraByNome(String nome) {
        return compraRepository.findCompraByNome(nome);
    }

    public Optional<Compra> getCompraById(Long id) {
        return compraRepository.findById(id);
    }

    public Compra createCompra(Compra compra) {
        // Lógica de validação ou processamento adicional, se necessário
        return compraRepository.save(compra);
    }

    public Optional<Compra> updateCompra(Long id, Compra compra) {
        if (compraRepository.existsById(id)) {
            compra.setId(id);
            return Optional.of(compraRepository.save(compra));
        } else {
            return Optional.empty();
        }
    }

    public boolean deleteCompra(Long id) {
        if (compraRepository.existsById(id)) {
            compraRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}