package br.com.farmaciapjr2.springbootapi.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProdutoTest {
    Fabricante fabricante;
    TipoProduto tipoProduto;

    @BeforeEach
    void setup() {
        tipoProduto = TipoProduto.builder()
                .id(1L)
                .tipo("tipo1")
                .build();

        fabricante = Fabricante.builder()
                .id(1L)
                .fabricante("fabricante1")
                .build();
    }

    @Test
    @DisplayName("Teste de criação do produto")
    void testeDeCriacaoProduto() {
        Produto produto = Produto.builder()
                .id(1L)
                .composicao("composicao1")
                .designacao("designacao1")
                .produto("produto1")
                .precoVenda(10D)
                .tipoProduto(tipoProduto)
                .fabricante(fabricante)
                .build();

        assertNotNull(produto);
        assertEquals("composicao1", produto.getComposicao());
        assertEquals("produto1", produto.getProduto());
        assertEquals("designacao1", produto.getDesignacao());
        assertEquals(10D, produto.getPrecoVenda());
        assertEquals(1L, produto.getTipoProduto().getId());
        assertEquals(1L, produto.getFabricante().getId());
    }

    @Test
    @DisplayName("Teste de exceção para atributo composicao nulo")
    void testeExcecaoParaComposicaoNull() {

        assertThrows(NullPointerException.class, () ->
                Produto.builder()
                        .id(1L)
                        .designacao("designacao1")
                        .produto("produto1")
                        .precoVenda(10D)
                        .tipoProduto(tipoProduto)
                        .fabricante(fabricante)
                        .build()
        );
    }

    @Test
    @DisplayName("Teste de exceção para atributo designacao nulo")
    void testeExcecaoParaDesignacaoNull() {

        assertThrows(NullPointerException.class, () ->
                Produto.builder()
                        .id(1L)
                        .composicao("composicao1")
                        .produto("produto1")
                        .precoVenda(10D)
                        .tipoProduto(tipoProduto)
                        .fabricante(fabricante)
                        .build()
        );
    }

    @Test
    @DisplayName("Teste de exceção para atributo produto nulo")
    void testeExcecaoParaProdutoNull() {

        assertThrows(NullPointerException.class, () ->
                Produto.builder()
                        .id(1L)
                        .composicao("composicao1")
                        .designacao("designacao1")
                        .precoVenda(10D)
                        .tipoProduto(tipoProduto)
                        .fabricante(fabricante)
                        .build()
        );
    }

    @Test
    @DisplayName("Teste de exceção para atributo precoVenda nulo")
    void testeExcecaoParaPrecoVendaNull() {

        assertThrows(NullPointerException.class, () ->
                Produto.builder()
                        .id(1L)
                        .composicao("composicao1")
                        .designacao("designacao1")
                        .produto("produto1")
                        .tipoProduto(tipoProduto)
                        .fabricante(fabricante)
                        .build()
        );
    }

    @Test
    @DisplayName("Teste de exceção para atributo tipoProduto nulo")
    void testeExcecaoParaTipoProdutoNull() {
        assertThrows(NullPointerException.class, () ->
                Produto.builder()
                        .id(1L)
                        .composicao("composicao1")
                        .designacao("designacao1")
                        .produto("produto1")
                        .precoVenda(10D)
                        .fabricante(fabricante)
                        .build()
        );
    }

    @Test
    @DisplayName("Teste de exceção para atributo fabricante nulo")
    void testeExcecaoParaNull() {
        assertThrows(NullPointerException.class, () ->
                Produto.builder()
                        .id(1L)
                        .composicao("composicao1")
                        .designacao("designacao1")
                        .produto("produto1")
                        .precoVenda(10D)
                        .tipoProduto(tipoProduto)
                        .build()
        );
    }
}
