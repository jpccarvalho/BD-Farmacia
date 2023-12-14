package br.com.farmaciapjr2.springbootapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "receitas_medica", schema = "bdfarmacia")
@Data
public class ReceitaMedica implements Serializable {
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
