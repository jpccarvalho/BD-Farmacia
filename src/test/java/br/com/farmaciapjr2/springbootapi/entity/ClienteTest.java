package br.com.farmaciapjr2.springbootapi.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ClienteTest {

    @Test
    @DisplayName("Teste de criação do cliente")
    void testeDeCriacaoCliente() {
        Cliente cliente = Cliente.builder()
                .id(1L)
                .nome("João Silva")
                .endereco("Rua ABC, 123")
                .telefone("11999999999")
                .codigoPostal("12345-678")
                .localidade("São Paulo")
                .numeroContribuinte("123.456.789-00")
                .build();

        assertNotNull(cliente);
        assertEquals("João Silva", cliente.getNome());
        assertEquals("Rua ABC, 123", cliente.getEndereco());
        assertEquals("11999999999", cliente.getTelefone());
        assertEquals("12345-678", cliente.getCodigoPostal());
        assertEquals("São Paulo", cliente.getLocalidade());
        assertEquals("123.456.789-00", cliente.getNumeroContribuinte());
    }

    @Test
    @DisplayName("Teste de exceção para atributo nome nulo")
    void testeExcecaoParaNomeNulo() {

        assertThrows(NullPointerException.class, () ->
                Cliente.builder()
                        .endereco("Rua ABC, 123")
                        .telefone("11999999999")
                        .codigoPostal("12345-678")
                        .localidade("São Paulo")
                        .numeroContribuinte("123.456.789-00")
                        .build()
        );
    }

    @Test
    @DisplayName("Teste de exceção para atributo endereco nulo")
    void testeExcecaoParaEnderecoNulo() {

        assertThrows(NullPointerException.class, () ->
                Cliente.builder()
                        .nome("João Silva")
                        .telefone("11999999999")
                        .codigoPostal("12345-678")
                        .localidade("São Paulo")
                        .numeroContribuinte("123.456.789-00")
                        .build()
        );
    }

    @Test
    @DisplayName("Teste de exceção para atributo telefone nulo")
    void testeExcecaoParaTelefoneNulo() {

        assertThrows(NullPointerException.class, () ->
                Cliente.builder()
                        .nome("João Silva")
                        .endereco("Rua ABC, 123")
                        .codigoPostal("12345-678")
                        .localidade("São Paulo")
                        .numeroContribuinte("123.456.789-00")
                        .build()
        );
    }

    @Test
    @DisplayName("Teste de exceção para atributo codigo postal nulo")
    void testeExcecaoParaCodigoPostalNulo() {

        assertThrows(NullPointerException.class, () ->
                Cliente.builder()
                        .nome("João Silva")
                        .endereco("Rua ABC, 123")
                        .telefone("11999999999")
                        .localidade("São Paulo")
                        .numeroContribuinte("123.456.789-00")
                        .build()
        );
    }

    @Test
    @DisplayName("Teste de exceção para atributo localidade nulo")
    void testeExcecaoParaLocalidadeNulo() {

        assertThrows(NullPointerException.class, () ->
                Cliente.builder()
                        .nome("João Silva")
                        .endereco("Rua ABC, 123")
                        .telefone("11999999999")
                        .codigoPostal("12345-678")
                        .numeroContribuinte("123.456.789-00")
                        .build()
        );
    }

    @Test
    @DisplayName("Teste de exceção para atributo numero contribuinte nulo")
    void testeExcecaoParaNContribuinteNulo() {

        assertThrows(NullPointerException.class, () ->
                Cliente.builder()
                        .nome("João Silva")
                        .endereco("Rua ABC, 123")
                        .telefone("11999999999")
                        .codigoPostal("12345-678")
                        .localidade("São Paulo")
                        .build()
        );
    }
}

