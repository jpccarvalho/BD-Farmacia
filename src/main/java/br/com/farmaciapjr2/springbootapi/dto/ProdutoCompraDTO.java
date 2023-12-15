package br.com.farmaciapjr2.springbootapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProdutoCompraDTO {
    private Long id;
    private Long produtoId;
    private Long compraId;
    private Integer quantidade;
}
