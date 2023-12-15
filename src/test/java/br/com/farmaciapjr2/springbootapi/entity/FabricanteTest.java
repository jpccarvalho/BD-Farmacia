package br.com.farmaciapjr2.springbootapi.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FabricanteTest {
    @Test
    @DisplayName("Teste de criação do fabricante")
    void testeDeCriacaoFabricante() {
        Fabricante fabricante = Fabricante.builder()
                .id(1L)
                .fabricante("Fabricante1")
                .build();

        assertNotNull(fabricante);
        assertEquals("Fabricante1", fabricante.getFabricante());
    }

    @Test
    @DisplayName("Teste de exceção para atributo fabricante nulo")
    void testeExcecaoParaFabricanteNull() {

        assertThrows(NullPointerException.class, () ->
                Fabricante.builder()
                        .id(1L)
                        .build()
        );
    }
}
