package br.com.farmaciapjr2.springbootapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "receitas_medica")
@Data
public class ReceitaMedica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_produto_compra")
    private ProdutoCompra produtoCompra;

    @ManyToOne
    @JoinColumn(name = "id_medico")
    private Medico medico;

    @JsonProperty("receita")
    private String receita;
}
