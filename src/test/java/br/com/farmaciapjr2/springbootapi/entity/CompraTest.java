package br.com.farmaciapjr2.springbootapi.entity;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class CompraTest {

    private Cliente cliente;

    @BeforeEach
    void setup() {
        cliente = Cliente.builder()
                .id(1L)
                .nome("João Silva")
                .endereco("Rua ABC, 123")
                .telefone("11999999999")
                .codigoPostal("12345-678")
                .localidade("São Paulo")
                .numeroContribuinte("123.456.789-00")
                .build();
    }
    @Test
    @DisplayName("Teste de criação de compra")
    void testeDeCriacaoCompra() {
        Date date = new Date();
        Compra compra = Compra.builder()
                .id(1L)
                .dataCompra(date)
                .cliente(cliente)
                .build();

        assertNotNull(compra);
        assertEquals(date, compra.getDataCompra());
        assertEquals(1L,compra.getCliente().getId() );
    }

    @Test
    @DisplayName("Teste de exceção para atributo dataCompra nulo")
    void testeExcecaoParaDataCompraNull() {

        assertThrows(NullPointerException.class, () ->
                Compra.builder()
                        .id(1L)
                        .cliente(cliente)
                        .build()
        );
    }

    @Test
    @DisplayName("Teste de exceção para atributo cliente nulo")
    void testeExcecaoParaClienteNull() {

        assertThrows(NullPointerException.class, () ->
                Compra.builder()
                        .id(1L)
                        .dataCompra(new Date())
                        .build()
        );
    }
}
