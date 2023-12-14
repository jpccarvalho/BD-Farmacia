package br.com.farmaciapjr2.springbootapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReceitaMedicaDTO {
    private Long id;
    private Long id_produtoCompra;
    private Long id_medico;
    private String receita;
}
