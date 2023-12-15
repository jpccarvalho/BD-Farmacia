package br.com.farmaciapjr2.springbootapi.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class ProdutoCompraTest {
    private Produto produto;
    private Compra compra;


    @BeforeEach
    void setup() {

        Fabricante fabricante = Fabricante.builder()
                .id(1L)
                .fabricante("fabricante1")
                .build();

        TipoProduto tipoProduto = TipoProduto.builder()
                .id(1L)
                .tipo("tipo1")
                .build();

        Cliente cliente = Cliente.builder()
                .id(1L)
                .nome("João Silva")
                .endereco("Rua ABC, 123")
                .telefone("11999999999")
                .codigoPostal("12345-678")
                .localidade("São Paulo")
                .numeroContribuinte("123.456.789-00")
                .build();

        produto = Produto.builder()
                .id(1L)
                .composicao("composicao1")
                .designacao("designacao1")
                .produto("produto1")
                .precoVenda(10D)
                .tipoProduto(tipoProduto)
                .fabricante(fabricante)
                .build();

        compra = Compra.builder()
                .id(1L)
                .cliente(cliente)
                .dataCompra(new Date())
                .build();

    }

    @Test
    @DisplayName("Teste de criação do produtoCompra")
    void testeDeCriacaoProdutoCompra() {
        ProdutoCompra produtoCompra = ProdutoCompra
                .builder()
                .id(1L)
                .compra(compra)
                .produto(produto)
                .quantidade(10)
                .build();

        assertNotNull(produtoCompra);
        assertEquals(10, produtoCompra.getQuantidade());
        assertEquals(1L, produtoCompra.getProduto().getId());
        assertEquals(1L, produtoCompra.getCompra().getId());
    }

    @Test
    @DisplayName("Teste de exceção para atributo compra nulo")
    void testeExcecaoParaCompraNulo() {

        assertThrows(NullPointerException.class, () ->
                ProdutoCompra
                        .builder()
                        .id(1L)
                        .produto(produto)
                        .quantidade(10)
                        .build()
        );
    }

    @Test
    @DisplayName("Teste de exceção para atributo produto nulo")
    void testeExcecaoParaProdutoNulo() {

        assertThrows(NullPointerException.class, () ->
                ProdutoCompra
                        .builder()
                        .id(1L)
                        .compra(compra)
                        .quantidade(10)
                        .build()
        );
    }

    @Test
    @DisplayName("Teste de exceção para atributo quantidade nulo")
    void testeExcecaoParaQuantidadeNulo() {

        assertThrows(NullPointerException.class, () ->
                ProdutoCompra
                        .builder()
                        .id(1L)
                        .compra(compra)
                        .produto(produto)
                        .build()
        );
    }
}
