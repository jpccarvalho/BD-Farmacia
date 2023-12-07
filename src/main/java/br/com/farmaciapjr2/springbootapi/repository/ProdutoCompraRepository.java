package br.com.farmaciapjr2.springbootapi.repository;

import br.com.farmaciapjr2.springbootapi.model.ProdutoCompra;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoCompraRepository extends JpaRepository<ProdutoCompra, Long> {}
