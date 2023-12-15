package br.com.farmaciapjr2.springbootapi.service;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import br.com.farmaciapjr2.springbootapi.entity.Cliente;
import br.com.farmaciapjr2.springbootapi.repository.ClienteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;
import java.util.ArrayList;
import java.util.List;

public class ClienteServiceTest {

    @Mock
    private ClienteRepository clienteRepository;

    @InjectMocks
    private ClienteService clienteService;

    public Cliente cliente;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        cliente = Cliente.builder()
                .id(1L)
                .nome("Joao")
                .endereco("Joao")
                .telefone("Joao")
                .codigoPostal("Joao")
                .localidade("Joao")
                .numeroContribuinte("Joao")
                .build();
    }

    @Test
    public void testFindAll() {
        List<Cliente> lista = new ArrayList<>();
        lista.add(cliente);
        when(clienteRepository.findAll()).thenReturn(lista);

        List<Cliente> resultado = clienteService.getAllClientes();
        assertEquals(1, resultado.size());
        assertEquals(cliente, resultado.get(0));
    }

    @Test
    public void testFindById() {
        when(clienteRepository.findById(anyLong())).thenReturn(Optional.of(cliente));

        Optional<Cliente> resultado = clienteService.getClienteById(1L);
        assertTrue(resultado.isPresent());
        assertEquals(cliente, resultado.get());
    }

    @Test
    public void testSave() {
        when(clienteRepository.save(any(Cliente.class))).thenReturn(cliente);

        Cliente resultado = clienteService.createCliente(cliente);
        assertNotNull(resultado);
        assertEquals(cliente, resultado);
    }

    @Test
    public void testUpdate() {
        when(clienteRepository.save(any(Cliente.class))).thenReturn(cliente);
        when(clienteRepository.findById(anyLong())).thenReturn(Optional.of(cliente));
        when(clienteRepository.existsById(anyLong())).thenReturn(true);

        Optional<Cliente> resultado = clienteService.updateCliente(1L, cliente);
        assertNotNull(resultado);
        assertTrue(resultado.isPresent());
        assertEquals(cliente, resultado.get());
    }

    @Test
    public void testDelete() {
        when(clienteRepository.existsById(anyLong())).thenReturn(true);
        doNothing().when(clienteRepository).deleteById(anyLong());
        clienteService.deleteCliente(1L);
        verify(clienteRepository, times(1)).deleteById(1L);
    }
}

