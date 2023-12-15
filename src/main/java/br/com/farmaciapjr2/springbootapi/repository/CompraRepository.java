package br.com.farmaciapjr2.springbootapi.repository;

import br.com.farmaciapjr2.springbootapi.entity.Compra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CompraRepository extends JpaRepository<Compra, Long> {

    //Aninhada
    @Query(nativeQuery = true, value = "SELECT * FROM compras WHERE id_cliente = (SELECT id FROM cliente WHERE nome LIKE %:nome%);")
    List<Compra> findCompraByNome(@Param("nome") String nome);

}
