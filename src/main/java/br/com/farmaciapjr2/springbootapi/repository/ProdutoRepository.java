package br.com.farmaciapjr2.springbootapi.repository;

import br.com.farmaciapjr2.springbootapi.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    //Aninhada
    //Join
    @Query(nativeQuery = true, value = "SELECT p.*\n" +
            "    FROM produtos p\n" +
            "    JOIN produtos_compra pc ON p.id = pc.id_produto\n" +
            "    JOIN compras c ON pc.id_compra = c.id\n" +
            "    JOIN cliente cl ON c.id_cliente = cl.id\n" +
            "    WHERE cl.nome LIKE %:nome%")
    List<Produto> getProdutoByNomeCliente(@Param("nome") String nome);

//UNION
    @Query(nativeQuery = true, value = "SELECT p.*\n" +
            "    FROM produtos_compra pc\n" +
            "    JOIN produtos p ON pc.id_produto = p.id\n" +
            "    JOIN compras c ON pc.id_compra = c.id\n" +
            "    WHERE YEAR(c.data_compra) = 2023\n" +
            "\n" +
            "    UNION\n" +
            "\n" +
            "    SELECT p.*\n" +
            "    FROM produtos_compra pc\n" +
            "    JOIN produtos p ON pc.id_produto = p.id\n" +
            "    JOIN compras c ON pc.id_compra = c.id\n" +
            "    WHERE YEAR(c.data_compra) = 2022;")
    List<Produto> busca22E23();




}
