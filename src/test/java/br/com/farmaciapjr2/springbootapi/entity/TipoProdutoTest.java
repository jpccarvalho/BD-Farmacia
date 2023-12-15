package br.com.farmaciapjr2.springbootapi.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TipoProdutoTest {

    private TipoProduto tipoProduto;

    @BeforeEach
    void setUp() {
        tipoProduto = TipoProduto
                .builder()
                .id(1L)
                .tipo("Cosmético")
                .build();
    }

    @Test
    @DisplayName("Teste de criação de Tipo de Produto")
    void testeDeCriacaoTipoProduto() {
        TipoProduto tp = TipoProduto
                .builder()
                .id(2L)
                .tipo("Cosmético")
                .build();
        assertNotNull(tp);
        assertEquals("Cosmético", tp.getTipo());
        assertEquals(2L, tp.getId());
    }

    @Test
    @DisplayName("Teste de exceção para atributo tipo nulo")
    void testeExcecaoParaTipoNulo() {
        assertThrows(NullPointerException.class, () ->
                TipoProduto
                        .builder()
                        .id(2L)
                        .build()
        );
    }
}