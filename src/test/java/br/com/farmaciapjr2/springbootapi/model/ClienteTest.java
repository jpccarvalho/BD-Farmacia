package br.com.farmaciapjr2.springbootapi.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ClienteTest {

    @Test
    @DisplayName("")
    void testeDeCriacaoCliente() {
        Cliente cliente = Cliente.builder()
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
}

