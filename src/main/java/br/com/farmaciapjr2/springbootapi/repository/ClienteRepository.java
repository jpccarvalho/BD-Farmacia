package br.com.farmaciapjr2.springbootapi.repository;

import br.com.farmaciapjr2.springbootapi.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    //Ordenação
    @Query(nativeQuery = true, value = "SELECT *\n" +
            "    FROM cliente\n" +
            "    ORDER BY nome ASC;")
    List<Cliente> todosClientesOrdenadosPorNome();


    //Having
    //ALL
    @Query(nativeQuery = true, value = "SELECT cl.*\n" +
            "FROM cliente cl\n" +
            "WHERE cl.id = ALL (\n" +
            "    SELECT c.id_cliente\n" +
            "    FROM compras c\n" +
            "    JOIN produtos_compra pc ON c.id = pc.id_compra\n" +
            "    JOIN produtos p ON pc.id_produto = p.id\n" +
            "    JOIN cliente cl ON c.id_cliente = cl.id\n" +
            "    GROUP BY c.id_cliente\n" +
            "    HAVING SUM(pc.quantidade) > (\n" +
            "        SELECT SUM(pc2.quantidade)\n" +
            "        FROM compras c2\n" +
            "        JOIN produtos_compra pc2 ON c2.id = pc2.id_compra\n" +
            "        JOIN produtos p2 ON pc2.id_produto = p2.id\n" +
            "        JOIN cliente cl2 ON c2.id_cliente = cl2.id\n" +
            "        WHERE cl2.localidade = 'Minas Gerais'\n" +
            "    )\n" +
            ");\n")
    List<Cliente> comprasMaiorQueMG();



//EXISTS


@Query(nativeQuery = true, value="SELECT *\n" +
        "FROM cliente cl\n" +
        "WHERE EXISTS (\n" +
        "    SELECT 1\n" +
        "    FROM compras c\n" +
        "    WHERE c.id_cliente = cl.id\n" +
        ");")
    List<Cliente> clientesPeloMenosUmaCompra();


}
