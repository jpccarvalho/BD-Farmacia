package br.com.farmaciapjr2.springbootapi.repository;

import br.com.farmaciapjr2.springbootapi.entity.ReceitaMedica;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReceitaMedicaRepository extends JpaRepository<ReceitaMedica, Long> {
}
