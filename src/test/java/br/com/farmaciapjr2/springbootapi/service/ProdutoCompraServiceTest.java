package br.com.farmaciapjr2.springbootapi.service;


import br.com.farmaciapjr2.springbootapi.dto.ProdutoCompraDTO;
import br.com.farmaciapjr2.springbootapi.dto.ReceitaMedicaDTO;
import br.com.farmaciapjr2.springbootapi.entity.*;
import br.com.farmaciapjr2.springbootapi.repository.CompraRepository;
import br.com.farmaciapjr2.springbootapi.repository.ProdutoCompraRepository;
import br.com.farmaciapjr2.springbootapi.repository.ProdutoRepository;
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
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ProdutoCompraServiceTest {

    @Mock
    private ProdutoCompraRepository produtoCompraRepository;

    @Mock
    private CompraRepository compraRepository;

    @Mock
    private ProdutoRepository produtoRepository;


    @InjectMocks
    private ProdutoCompraService produtoCompraService;

    private Compra compra;

    private Produto produto;

    private ProdutoCompra produtoCompra;

    @BeforeEach
    void setup() {
        Cliente cliente = Cliente.builder()
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

        produto = Produto.builder()
                .id(1L)
                .composicao("composicao1")
                .designacao("designacao1")
                .produto("produto1")
                .precoVenda(10D)
                .tipoProduto(tipoProduto)
                .fabricante(fabricante)
                .build();

        produtoCompra = ProdutoCompra.builder()
                .id(1L)
                .quantidade(100)
                .compra(compra)
                .produto(produto)
                .build();
    }

    @Test
    void getAllProdutoCompra() {
        when(produtoCompraRepository.findAll()).thenReturn(Collections.singletonList(produtoCompra));

        List<ProdutoCompra> result = produtoCompraService.getAllProdutoCompras();

        assertEquals(1, result.size());
        verify(produtoCompraRepository, times(1)).findAll();
    }

    @Test
    void createProdutoCompra() {
        when(produtoCompraRepository.save(produtoCompra)).thenReturn(produtoCompra);
        when(produtoRepository.existsById(1L)).thenReturn(true);
        when(compraRepository.existsById(1L)).thenReturn(true);
        when(produtoRepository.getReferenceById(1L)).thenReturn(produto);
        when(compraRepository.getReferenceById(1L)).thenReturn(compra);


        ProdutoCompraDTO produtoCompraDTO = new ProdutoCompraDTO(1L, 1L, 1L, 100);

        ProdutoCompra result = produtoCompraService.createProdutoCompra(produtoCompraDTO);

        assertEquals(produtoCompra, result);
        verify(produtoCompraRepository, times(1)).save(produtoCompra);
    }

    @Test
    void getProdutoCompraById() {
        when(produtoCompraRepository.findById(1L)).thenReturn(Optional.of(produtoCompra));

        Optional<ProdutoCompra> result = produtoCompraService.getProdutoCompraById(1L);

        assertTrue(result.isPresent());
        assertEquals(produtoCompra, result.get());
        verify(produtoCompraRepository, times(1)).findById(1L);
    }

    @Test
    void updateProdutoCompraExistingId() {
        when(produtoCompraRepository.existsById(1L)).thenReturn(true);
        when(produtoCompraRepository.save(produtoCompra)).thenReturn(produtoCompra);

        Optional<ProdutoCompra> result = produtoCompraService.updateProdutoCompra(1L, produtoCompra);

        assertTrue(result.isPresent());
        assertEquals(produtoCompra, result.get());
        verify(produtoCompraRepository, times(1)).existsById(1L);
        verify(produtoCompraRepository, times(1)).save(produtoCompra);
    }

    @Test
    void updateProdutoCompraNonExistingId() {
        when(produtoCompraRepository.existsById(1L)).thenReturn(false);

        Optional<ProdutoCompra> result = produtoCompraService.updateProdutoCompra(1L, produtoCompra);

        assertFalse(result.isPresent());
        verify(produtoCompraRepository, times(1)).existsById(1L);
        verify(produtoCompraRepository, never()).save(produtoCompra);
    }

    @Test
    void deleteProdutoCompraExistingId() {
        when(produtoCompraRepository.existsById(1L)).thenReturn(true);
        doNothing().when(produtoCompraRepository).deleteById(1L);

        boolean result = produtoCompraService.deleteProdutoCompra(1L);

        assertTrue(result);
        verify(produtoCompraRepository, times(1)).existsById(1L);
        verify(produtoCompraRepository, times(1)).deleteById(1L);
    }

    @Test
    void deleteProdutoCompraNonExistingId() {
        when(produtoCompraRepository.existsById(1L)).thenReturn(false);

        boolean result = produtoCompraService.deleteProdutoCompra(1L);

        assertFalse(result);
        verify(produtoCompraRepository, times(1)).existsById(1L);
        verify(produtoCompraRepository, never()).deleteById(1L);
    }
}
