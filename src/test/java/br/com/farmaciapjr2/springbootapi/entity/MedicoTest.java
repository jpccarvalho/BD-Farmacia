package br.com.farmaciapjr2.springbootapi.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class MedicoTest {
    @Test
    @DisplayName("Teste de criaçãode Medico")
    void testeDeCriacaoMedico() {
        Medico medico = Medico.builder()
                .id(1L)
                .nome("Dr. Felipe")
                .CRM("CRM123")
                .build();

        assertNotNull(medico);
        assertEquals("Dr. Felipe", medico.getNome());
        assertEquals("CRM123", medico.getCRM());
    }
    @Test
    @DisplayName("Teste de exceção para atributo nome nulo")
    void testeExcecaoParaNomeNulo() {

        assertThrows(NullPointerException.class, () ->
                Medico.builder().id(1L).CRM("CRM123").build()
        );
    }

    @Test
    @DisplayName("Teste de exceção para atributo CRM nulo")
    void testeExcecaoParaCrmNulo() {
        assertThrows(NullPointerException.class, () ->
                Medico.builder().nome("Dr. Felipe").build()
        );
    }
}