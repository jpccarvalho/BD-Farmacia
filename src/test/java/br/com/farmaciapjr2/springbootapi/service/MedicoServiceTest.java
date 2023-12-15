package br.com.farmaciapjr2.springbootapi.service;

import br.com.farmaciapjr2.springbootapi.entity.Medico;
import br.com.farmaciapjr2.springbootapi.repository.MedicoRepository;
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
class MedicoServiceTest {

    @Mock
    private MedicoRepository medicoRepository;

    @InjectMocks
    private MedicoService medicoService;

    private Medico medico;

    @BeforeEach
    void setUp() {
        medico = Medico.builder()
                .id(1L)
                .nome("Dr. Smith")
                .CRM("1234")
                .build();
    }

    @Test
    void getAllMedicos() {
        when(medicoRepository.findAll()).thenReturn(Collections.singletonList(medico));

        List<Medico> result = medicoService.getAllMedicos();

        assertEquals(1, result.size());
        verify(medicoRepository, times(1)).findAll();
    }

    @Test
    void getMedicoById() {
        when(medicoRepository.findById(1L)).thenReturn(Optional.of(medico));

        Optional<Medico> result = medicoService.getMedicoById(1L);

        assertTrue(result.isPresent());
        assertEquals(medico, result.get());
        verify(medicoRepository, times(1)).findById(1L);
    }

    @Test
    void createMedico() {
        when(medicoRepository.save(medico)).thenReturn(medico);

        Medico result = medicoService.createMedico(medico);

        assertEquals(medico, result);
        verify(medicoRepository, times(1)).save(medico);
    }

    @Test
    void updateMedicoExistingId() {
        when(medicoRepository.existsById(1L)).thenReturn(true);
        when(medicoRepository.save(medico)).thenReturn(medico);

        Optional<Medico> result = medicoService.updateMedico(1L, medico);

        assertTrue(result.isPresent());
        assertEquals(medico, result.get());
        verify(medicoRepository, times(1)).existsById(1L);
        verify(medicoRepository, times(1)).save(medico);
    }

    @Test
    void updateMedicoNonExistingId() {
        when(medicoRepository.existsById(1L)).thenReturn(false);

        Optional<Medico> result = medicoService.updateMedico(1L, medico);

        assertFalse(result.isPresent());
        verify(medicoRepository, times(1)).existsById(1L);
        verify(medicoRepository, never()).save(medico);
    }

    @Test
    void deleteMedicoExistingId() {
        when(medicoRepository.existsById(1L)).thenReturn(true);
        doNothing().when(medicoRepository).deleteById(1L);

        boolean result = medicoService.deleteMedico(1L);

        assertTrue(result);
        verify(medicoRepository, times(1)).existsById(1L);
        verify(medicoRepository, times(1)).deleteById(1L);
    }

    @Test
    void deleteMedicoNonExistingId() {
        when(medicoRepository.existsById(1L)).thenReturn(false);

        boolean result = medicoService.deleteMedico(1L);

        assertFalse(result);
        verify(medicoRepository, times(1)).existsById(1L);
        verify(medicoRepository, never()).deleteById(1L);
    }
}

