package br.com.farmaciapjr2.springbootapi.service;

import br.com.farmaciapjr2.springbootapi.dto.CompraDTO;
import br.com.farmaciapjr2.springbootapi.dto.ReceitaMedicaDTO;
import br.com.farmaciapjr2.springbootapi.entity.Cliente;
import br.com.farmaciapjr2.springbootapi.entity.Compra;
import br.com.farmaciapjr2.springbootapi.entity.ReceitaMedica;
import br.com.farmaciapjr2.springbootapi.repository.ClienteRepository;
import br.com.farmaciapjr2.springbootapi.repository.CompraRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CompraServiceTest {
    @Mock
    private CompraRepository compraRepository;

    @Mock
    ClienteRepository clienteRepository;

    @InjectMocks
    private CompraService compraService;

    private Cliente cliente;

    private Compra compra;

    Date data;

    @BeforeEach
    void setup() {
        data = new Date();

        cliente = Cliente.builder()
                .id(1L)
                .nome("João Silva")
                .endereco("Rua ABC, 123")
                .telefone("11999999999")
                .codigoPostal("12345-678")
                .localidade("São Paulo")
                .numeroContribuinte("123.456.789-00")
                .build();

        compra = Compra.builder()
                .id(1L)
                .cliente(cliente)
                .dataCompra(data)
                .build();

    }

    @Test
    void getAllCompras() {
        when(compraRepository.findAll()).thenReturn(Collections.singletonList(compra));

        List<Compra> result = compraService.getAllCompras();

        assertEquals(1, result.size());
        verify(compraRepository, times(1)).findAll();
    }

    @Test
    void getCompraById() {
        when(compraRepository.findById(1L)).thenReturn(Optional.of(compra));

        Optional<Compra> result = compraService.getCompraById(1L);

        assertTrue(result.isPresent());
        assertEquals(compra, result.get());
        verify(compraRepository, times(1)).findById(1L);
    }

    @Test
    void createCompra() {
        lenient().when(compraRepository.save(compra)).thenReturn(compra);
        when(clienteRepository.existsById(1L)).thenReturn(true);
        when(clienteRepository.getReferenceById(1L)).thenReturn(cliente);


        CompraDTO compraDto = new CompraDTO(1L, 1L, data);

        Compra result = compraService.createCompra(compraDto);

        assertEquals(compra, result);
        verify(compraRepository, times(1)).save(compra);
    }

    @Test
    void updateCompraExistingId() {
        when(compraRepository.existsById(1L)).thenReturn(true);
        when(compraRepository.save(compra)).thenReturn(compra);

        Optional<Compra> result = compraService.updateCompra(1L, compra);

        assertTrue(result.isPresent());
        assertEquals(compra, result.get());
        verify(compraRepository, times(1)).existsById(1L);
        verify(compraRepository, times(1)).save(compra);
    }

    @Test
    void updateCompraNonExistingId() {
        when(compraRepository.existsById(1L)).thenReturn(false);

        Optional<Compra> result = compraService.updateCompra(1L, compra);

        assertFalse(result.isPresent());
        verify(compraRepository, times(1)).existsById(1L);
        verify(compraRepository, never()).save(compra);
    }

    @Test
    void deleteCompraExistingId() {
        when(compraRepository.existsById(1L)).thenReturn(true);
        doNothing().when(compraRepository).deleteById(1L);

        boolean result = compraService.deleteCompra(1L);

        assertTrue(result);
        verify(compraRepository, times(1)).existsById(1L);
        verify(compraRepository, times(1)).deleteById(1L);
    }

    @Test
    void deleteCompraNonExistingId() {
        when(compraRepository.existsById(1L)).thenReturn(false);

        boolean result = compraService.deleteCompra(1L);

        assertFalse(result);
        verify(compraRepository, times(1)).existsById(1L);
        verify(compraRepository, never()).deleteById(1L);
    }
}
