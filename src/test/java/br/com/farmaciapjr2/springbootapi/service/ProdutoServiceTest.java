package br.com.farmaciapjr2.springbootapi.service;


import br.com.farmaciapjr2.springbootapi.dto.ProdutoDTO;
import br.com.farmaciapjr2.springbootapi.dto.ReceitaMedicaDTO;
import br.com.farmaciapjr2.springbootapi.entity.Fabricante;
import br.com.farmaciapjr2.springbootapi.entity.Produto;
import br.com.farmaciapjr2.springbootapi.entity.ReceitaMedica;
import br.com.farmaciapjr2.springbootapi.entity.TipoProduto;
import br.com.farmaciapjr2.springbootapi.repository.FabricanteRepository;
import br.com.farmaciapjr2.springbootapi.repository.ProdutoRepository;
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
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ProdutoServiceTest {


    @Mock
    private ProdutoRepository produtoRepository;

    @Mock
    private TipoProdutoRepository tipoProdutoRepository;

    @Mock
    private FabricanteRepository fabricanteRepository;

    @InjectMocks
    private ProdutoService produtoService;

    private Produto produto;
    private Fabricante fabricante;
    private TipoProduto tipoProduto;

    @BeforeEach
    void setup() {
        tipoProduto = TipoProduto.builder()
                .id(1L)
                .tipo("tipo1")
                .build();

        fabricante = Fabricante.builder()
                .id(1L)
                .fabricante("fabricante1")
                .build();

        produto = Produto.builder()
                .id(1L)
                .composicao("composicao1")
                .designacao("designacao1")
                .produto("produto1")
                .precoVenda(10D)
                .tipoProduto(tipoProduto)
                .fabricante(fabricante)
                .build();
    }

    @Test
    void getAllProdutos() {
        when(produtoRepository.findAll()).thenReturn(Collections.singletonList(produto));

        List<Produto> result = produtoService.getAllProdutos();

        assertEquals(1, result.size());
        verify(produtoRepository, times(1)).findAll();
    }

    @Test
    void getProdutoById() {
        when(produtoRepository.findById(1L)).thenReturn(Optional.of(produto));

        Optional<Produto> result = produtoService.getProdutoById(1L);

        assertTrue(result.isPresent());
        assertEquals(produto, result.get());
        verify(produtoRepository, times(1)).findById(1L);
    }

    @Test
    void createProduto() {
        when(produtoRepository.save(produto)).thenReturn(produto);
        when(tipoProdutoRepository.existsById(1L)).thenReturn(true);
        when(fabricanteRepository.existsById(1L)).thenReturn(true);
        when(tipoProdutoRepository.getReferenceById(1L)).thenReturn(tipoProduto);
        when(fabricanteRepository.getReferenceById(1L)).thenReturn(fabricante);


        ProdutoDTO produtoDTO = new ProdutoDTO(1L, "produto1","designacao1", "composicao1", 10D,  1L, 1L);

        Produto result = produtoService.createProduto(produtoDTO);

        assertEquals(produto, result);
        verify(produtoRepository, times(1)).save(produto);
    }

    @Test
    void updateProdutoExistingId() {
        when(produtoRepository.existsById(1L)).thenReturn(true);
        when(produtoRepository.save(produto)).thenReturn(produto);

        Optional<Produto> result = produtoService.updateProduto(1L, produto);

        assertTrue(result.isPresent());
        assertEquals(produto, result.get());
        verify(produtoRepository, times(1)).existsById(1L);
        verify(produtoRepository, times(1)).save(produto);
    }

    @Test
    void updateProdutoNonExistingId() {
        when(produtoRepository.existsById(1L)).thenReturn(false);

        Optional<Produto> result = produtoService.updateProduto(1L, produto);

        assertFalse(result.isPresent());
        verify(produtoRepository, times(1)).existsById(1L);
        verify(produtoRepository, never()).save(produto);
    }

    @Test
    void deleteProdutoExistingId() {
        when(produtoRepository.existsById(1L)).thenReturn(true);
        doNothing().when(produtoRepository).deleteById(1L);

        boolean result = produtoService.deleteProduto(1L);

        assertTrue(result);
        verify(produtoRepository, times(1)).existsById(1L);
        verify(produtoRepository, times(1)).deleteById(1L);
    }

    @Test
    void deleteReceitaNonExistingId() {
        when(produtoRepository.existsById(1L)).thenReturn(false);

        boolean result = produtoService.deleteProduto(1L);

        assertFalse(result);
        verify(produtoRepository, times(1)).existsById(1L);
        verify(produtoRepository, never()).deleteById(1L);
    }
}
