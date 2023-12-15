package br.com.farmaciapjr2.springbootapi.service;


import br.com.farmaciapjr2.springbootapi.entity.TipoProduto;
import br.com.farmaciapjr2.springbootapi.repository.TipoProdutoRepository;
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
public class TipoProdutoServiceTest {

    @Mock
    private TipoProdutoRepository tipoProdutoRepository;

    @InjectMocks
    private TipoProdutoService tipoProdutoService;

    private TipoProduto tipoProduto;

    @BeforeEach
    void setUp() {
        tipoProduto = TipoProduto.builder()
                .id(1L)
                .tipo("Medicamento")
                .build();
    }

    @Test
    void getAllTipos() {
        when(tipoProdutoRepository.findAll()).thenReturn(Collections.singletonList(tipoProduto));

        List<TipoProduto> result = tipoProdutoService.getAllTipoProdutos();

        assertEquals(1, result.size());
        verify(tipoProdutoRepository, times(1)).findAll();
    }

    @Test
    void getTipoProdutoById() {
        when(tipoProdutoRepository.findById(1L)).thenReturn(Optional.of(tipoProduto));

        Optional<TipoProduto> result = tipoProdutoService.getTipoProdutoById(1L);

        assertTrue(result.isPresent());
        assertEquals(tipoProduto, result.get());
        verify(tipoProdutoRepository, times(1)).findById(1L);
    }

    @Test
    void createTipoProduto() {
        when(tipoProdutoRepository.save(tipoProduto)).thenReturn(tipoProduto);

        TipoProduto result = tipoProdutoService.createTipoProduto(tipoProduto);

        assertEquals(tipoProduto, result);
        verify(tipoProdutoRepository, times(1)).save(tipoProduto);
    }

    @Test
    void updateTipoProdutoExistingId() {
        when(tipoProdutoRepository.existsById(1L)).thenReturn(true);
        when(tipoProdutoRepository.save(tipoProduto)).thenReturn(tipoProduto);

        Optional<TipoProduto> result = tipoProdutoService.updateTipoProduto(1L, tipoProduto);

        assertTrue(result.isPresent());
        assertEquals(tipoProduto, result.get());
        verify(tipoProdutoRepository, times(1)).existsById(1L);
        verify(tipoProdutoRepository, times(1)).save(tipoProduto);
    }

    @Test
    void updateTipoProdutoNonExistingId() {
        when(tipoProdutoRepository.existsById(1L)).thenReturn(false);

        Optional<TipoProduto> result = tipoProdutoService.updateTipoProduto(1L, tipoProduto);

        assertFalse(result.isPresent());
        verify(tipoProdutoRepository, times(1)).existsById(1L);
        verify(tipoProdutoRepository, never()).save(tipoProduto);
    }

    @Test
    void deleteTipoProdutoExistingId() throws Exception {
        when(tipoProdutoRepository.existsById(1L)).thenReturn(true);
        doNothing().when(tipoProdutoRepository).deleteById(1L);

        boolean result = tipoProdutoService.deleteTipoProduto(1L);

        assertTrue(result);
        verify(tipoProdutoRepository, times(1)).existsById(1L);
        verify(tipoProdutoRepository, times(1)).deleteById(1L);
    }

    @Test
    void deleteTipoProdutoNonExistingId() throws Exception {
        when(tipoProdutoRepository.existsById(1L)).thenReturn(false);

        boolean result = tipoProdutoService.deleteTipoProduto(1L);

        assertFalse(result);
        verify(tipoProdutoRepository, times(1)).existsById(1L);
        verify(tipoProdutoRepository, never()).deleteById(1L);
    }
}
