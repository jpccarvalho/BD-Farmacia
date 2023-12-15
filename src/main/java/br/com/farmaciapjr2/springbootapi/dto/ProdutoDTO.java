package br.com.farmaciapjr2.springbootapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProdutoDTO {
    private Long id;
    private String produto;
    private String designacao;
    private String composicao;
    private Double precoVenda;

    private Long tipoProdutoId;

    private Long fabricanteId;
}
