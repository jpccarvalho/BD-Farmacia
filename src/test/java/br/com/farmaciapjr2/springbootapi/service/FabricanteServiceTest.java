package br.com.farmaciapjr2.springbootapi.service;

import br.com.farmaciapjr2.springbootapi.entity.Fabricante;
import br.com.farmaciapjr2.springbootapi.repository.FabricanteRepository;
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
import static org.mockito.Mockito.never;

@ExtendWith(MockitoExtension.class)
public class FabricanteServiceTest {

    @Mock
    private FabricanteRepository fabricanteRepository;

    @InjectMocks
    private FabricanteService fabricanteService;

    private Fabricante fabricante;

    @BeforeEach
    void setup() {
        fabricante = Fabricante.builder()
                .id(1L)
                .fabricante("fabricante")
                .build();
    }

    @Test
    void getAllTipos() {
        when(fabricanteRepository.findAll()).thenReturn(Collections.singletonList(fabricante));

        List<Fabricante> result = fabricanteService.getAllFabricantes();

        assertEquals(1, result.size());
        verify(fabricanteRepository, times(1)).findAll();
    }

    @Test
    void getTipoProdutoById() {
        when(fabricanteRepository.findById(1L)).thenReturn(Optional.of(fabricante));

        Optional<Fabricante> result = fabricanteService.getFabricanteById(1L);

        assertTrue(result.isPresent());
        assertEquals(fabricante, result.get());
        verify(fabricanteRepository, times(1)).findById(1L);
    }

    @Test
    void createTipoProduto() {
        when(fabricanteRepository.save(fabricante)).thenReturn(fabricante);

        Fabricante result = fabricanteService.createFabricante(fabricante);

        assertEquals(fabricante, result);
        verify(fabricanteRepository, times(1)).save(fabricante);
    }

    @Test
    void updateTipoProdutoExistingId() {
        when(fabricanteRepository.existsById(1L)).thenReturn(true);
        when(fabricanteRepository.save(fabricante)).thenReturn(fabricante);

        Optional<Fabricante> result = fabricanteService.updateFabricante(1L, fabricante);

        assertTrue(result.isPresent());
        assertEquals(fabricante, result.get());
        verify(fabricanteRepository, times(1)).existsById(1L);
        verify(fabricanteRepository, times(1)).save(fabricante);
    }

    @Test
    void updateTipoProdutoNonExistingId() {
        when(fabricanteRepository.existsById(1L)).thenReturn(false);

        Optional<Fabricante> result = fabricanteService.updateFabricante(1L, fabricante);

        assertFalse(result.isPresent());
        verify(fabricanteRepository, times(1)).existsById(1L);
        verify(fabricanteRepository, never()).save(fabricante);
    }

    @Test
    void deleteTipoProdutoExistingId() throws Exception {
        when(fabricanteRepository.existsById(1L)).thenReturn(true);
        doNothing().when(fabricanteRepository).deleteById(1L);

        boolean result = fabricanteService.deleteFabricante(1L);

        assertTrue(result);
        verify(fabricanteRepository, times(1)).existsById(1L);
        verify(fabricanteRepository, times(1)).deleteById(1L);
    }

    @Test
    void deleteTipoProdutoNonExistingId() throws Exception {
        when(fabricanteRepository.existsById(1L)).thenReturn(false);

        boolean result = fabricanteService.deleteFabricante(1L);

        assertFalse(result);
        verify(fabricanteRepository, times(1)).existsById(1L);
        verify(fabricanteRepository, never()).deleteById(1L);
    }
}
