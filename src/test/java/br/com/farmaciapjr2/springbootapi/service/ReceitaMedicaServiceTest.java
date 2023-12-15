package br.com.farmaciapjr2.springbootapi.service;

import br.com.farmaciapjr2.springbootapi.entity.*;
import br.com.farmaciapjr2.springbootapi.repository.ReceitaMedicaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ReceitaMedicaServiceTest {
    @Mock
    private ReceitaMedicaRepository receitaMedicaRepository;

    @InjectMocks
    private ReceitaMedicaService receitaMedicaService;

    private ReceitaMedica receitaMedica;
    private Medico medico;

    private ProdutoCompra produtoCompra;
    @BeforeEach
    void setUp() {
        medico = Medico.builder()
                .id(1L)
                .nome("Dr. Smith")
                .CRM("1234")
                .build();

        produtoCompra = ProdutoCompra.builder()
                .id(1L)
                .quantidade(1)
                .compra(Compra.builder().build())
                .produto(Produto.builder().build())
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

//    @Test
//    void createReceita() {
//        when(receitaMedicaRepository.save(receitaMedica)).thenReturn(receitaMedica);
//
//        ReceitaMedica result = receitaMedicaService.createReceitaMedica(receitaMedica);
//
//        assertEquals(receitaMedica, result);
//        verify(receitaMedicaRepository, times(1)).save(receitaMedica);
//    }

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
    void deleteMedicoExistingId() {
        when(receitaMedicaRepository.existsById(1L)).thenReturn(true);
        doNothing().when(receitaMedicaRepository).deleteById(1L);

        boolean result = receitaMedicaService.deleteReceitaMedica(1L);

        assertTrue(result);
        verify(receitaMedicaRepository, times(1)).existsById(1L);
        verify(receitaMedicaRepository, times(1)).deleteById(1L);
    }

    @Test
    void deleteMedicoNonExistingId() {
        when(receitaMedicaRepository.existsById(1L)).thenReturn(false);

        boolean result = receitaMedicaService.deleteReceitaMedica(1L);

        assertFalse(result);
        verify(receitaMedicaRepository, times(1)).existsById(1L);
        verify(receitaMedicaRepository, never()).deleteById(1L);
    }
}
