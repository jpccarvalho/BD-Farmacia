package br.com.farmaciapjr2.springbootapi.service;

import br.com.farmaciapjr2.springbootapi.dto.ReceitaMedicaDTO;
import br.com.farmaciapjr2.springbootapi.entity.*;
import br.com.farmaciapjr2.springbootapi.repository.MedicoRepository;
import br.com.farmaciapjr2.springbootapi.repository.ProdutoCompraRepository;
import br.com.farmaciapjr2.springbootapi.repository.ReceitaMedicaRepository;
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
public class ReceitaMedicaServiceTest {
    @Mock
    private ReceitaMedicaRepository receitaMedicaRepository;
    @Mock
    private ProdutoCompraRepository produtoCompraRepository;
    @Mock
    private MedicoRepository medicoRepository;

    @InjectMocks
    private ReceitaMedicaService receitaMedicaService;

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

        receitaMedica = ReceitaMedica.builder()
                .id(1L)
                .receita("receita1.pdf")
                .medico(medico)
                .produtoCompra(produtoCompra)
                .build();
    }

    @Test
    void getAllReceitasMedicas() {
        when(receitaMedicaRepository.findAll()).thenReturn(Collections.singletonList(receitaMedica));

        List<ReceitaMedica> result = receitaMedicaService.getAllReceitaMedicas();

        assertEquals(1, result.size());
        verify(receitaMedicaRepository, times(1)).findAll();
    }

    @Test
    void getReceitaById() {
        when(receitaMedicaRepository.findById(1L)).thenReturn(Optional.of(receitaMedica));

        Optional<ReceitaMedica> result = receitaMedicaService.getReceitaMedicaById(1L);

        assertTrue(result.isPresent());
        assertEquals(receitaMedica, result.get());
        verify(receitaMedicaRepository, times(1)).findById(1L);
    }

    @Test
    void createReceita() {
        when(receitaMedicaRepository.save(receitaMedica)).thenReturn(receitaMedica);
        when(medicoRepository.existsById(1L)).thenReturn(true);
        when(produtoCompraRepository.existsById(1L)).thenReturn(true);
        when(medicoRepository.getReferenceById(1L)).thenReturn(medico);
        when(produtoCompraRepository.getReferenceById(1L)).thenReturn(produtoCompra);


        ReceitaMedicaDTO rm = new ReceitaMedicaDTO(1L, 1L, 1L, "receita1.pdf");

        ReceitaMedica result = receitaMedicaService.createReceitaMedica(rm);

        assertEquals(receitaMedica, result);
        verify(receitaMedicaRepository, times(1)).save(receitaMedica);
    }

    @Test
    void updateReceitaExistingId() {
        when(receitaMedicaRepository.existsById(1L)).thenReturn(true);
        when(receitaMedicaRepository.save(receitaMedica)).thenReturn(receitaMedica);

        Optional<ReceitaMedica> result = receitaMedicaService.updateReceitaMedica(1L, receitaMedica);

        assertTrue(result.isPresent());
        assertEquals(receitaMedica, result.get());
        verify(receitaMedicaRepository, times(1)).existsById(1L);
        verify(receitaMedicaRepository, times(1)).save(receitaMedica);
    }

    @Test
    void updateReceitaNonExistingId() {
        when(receitaMedicaRepository.existsById(1L)).thenReturn(false);

        Optional<ReceitaMedica> result = receitaMedicaService.updateReceitaMedica(1L, receitaMedica);

        assertFalse(result.isPresent());
        verify(receitaMedicaRepository, times(1)).existsById(1L);
        verify(receitaMedicaRepository, never()).save(receitaMedica);
    }

    @Test
    void deleteReceitaExistingId() {
        when(receitaMedicaRepository.existsById(1L)).thenReturn(true);
        doNothing().when(receitaMedicaRepository).deleteById(1L);

        boolean result = receitaMedicaService.deleteReceitaMedica(1L);

        assertTrue(result);
        verify(receitaMedicaRepository, times(1)).existsById(1L);
        verify(receitaMedicaRepository, times(1)).deleteById(1L);
    }

    @Test
    void deleteReceitaNonExistingId() {
        when(receitaMedicaRepository.existsById(1L)).thenReturn(false);

        boolean result = receitaMedicaService.deleteReceitaMedica(1L);

        assertFalse(result);
        verify(receitaMedicaRepository, times(1)).existsById(1L);
        verify(receitaMedicaRepository, never()).deleteById(1L);
    }
}
