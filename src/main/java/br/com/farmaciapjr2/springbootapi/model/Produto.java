package br.com.farmaciapjr2.springbootapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "produtos")
@Data
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("produto")
    private String produto;
    @JsonProperty("designacao")
    private String designacao;
    @JsonProperty("composicao")
    private String composicao;
    @JsonProperty("precoVenda")
    private Double precoVenda;

    @ManyToOne
    @JoinColumn(name = "id_tipo_produto")
    private TipoProduto tipoProduto;

    @ManyToOne
    @JoinColumn(name = "id_fabricante")
    private Fabricante fabricante;
}
