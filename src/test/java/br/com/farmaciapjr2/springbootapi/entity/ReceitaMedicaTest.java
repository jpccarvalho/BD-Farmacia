package br.com.farmaciapjr2.springbootapi.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
public class ReceitaMedicaTest {


    private ReceitaMedica receitaMedica;
    private Medico medico;

    private ProdutoCompra produtoCompra;
    @BeforeEach
    void setUp() {
        Cliente cliente = Cliente.builder()
                .id(1L)
                .nome("João Silva")
                .endereco("Rua ABC, 123")
                .telefone("11999999999")
                .codigoPostal("12345-678")
                .localidade("São Paulo")
                .numeroContribuinte("123.456.789-00")
                .build();

        Compra compra = Compra.builder()
                .id(1L)
                .cliente(cliente)
                .dataCompra(new Date())
                .build();

        Fabricante fabricante = Fabricante.builder()
                .id(1L)
                .fabricante("fabricante1")
                .build();

        TipoProduto tipoProduto = TipoProduto.builder()
                .id(1L)
                .tipo("tipo1")
                .build();

        Produto produto = Produto.builder()
                .id(1L)
                .composicao("composicao1")
                .designacao("designacao1")
                .produto("produto1")
                .precoVenda(10D)
                .tipoProduto(tipoProduto)
                .fabricante(fabricante)
                .build();

        medico = Medico.builder()
                .id(1L)
                .nome("Dr. Smith")
                .CRM("1234")
                .build();

        produtoCompra = ProdutoCompra.builder()
                .id(1L)
                .quantidade(1)
                .compra(compra)
                .produto(produto)
                .build();
    }
    @Test
    @DisplayName("Teste de criação do receita medica")
    void testeDeCriacaoReceitaMedica() {
        ReceitaMedica rm = ReceitaMedica.builder()
                .id(1L)
                .receita("receita1.pdf")
                .medico(medico)
                .produtoCompra(produtoCompra)
                .build();

        assertNotNull(rm);
        assertEquals("receita1.pdf", rm.getReceita());
        assertEquals(1L, rm.getMedico().getId());
        assertEquals(1L, rm.getProdutoCompra().getId());
    }

    @Test
    @DisplayName("Teste de exceção para atributo receita nulo")
    void testeExcecaoParaReceitaNull() {

        assertThrows(NullPointerException.class, () ->
                ReceitaMedica.builder()
                        .id(1L)
                        .medico(medico)
                        .produtoCompra(produtoCompra)
                        .build()
        );
    }

    @Test
    @DisplayName("Teste de exceção para atributo medico nulo")
    void testeExcecaoParaMedicoNull() {

        assertThrows(NullPointerException.class, () ->
                ReceitaMedica.builder()
                        .id(1L)
                        .receita("receita1.pdf")
                        .produtoCompra(produtoCompra)
                        .build()
        );
    }

    @Test
    @DisplayName("Teste de exceção para atributo produtoCompra nulo")
    void testeExcecaoParaProdutoCompraNull() {

        assertThrows(NullPointerException.class, () ->
                ReceitaMedica.builder()
                        .id(1L)
                        .receita("receita1.pdf")
                        .medico(medico)
                        .build()
        );
    }
}
