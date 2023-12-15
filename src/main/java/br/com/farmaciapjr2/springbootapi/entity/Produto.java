package br.com.farmaciapjr2.springbootapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "produtos", schema = "bdfarmacia")
@Data
public class Produto implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @JsonProperty("produto")
    private String produto;
    @NonNull
    @JsonProperty("designacao")
    private String designacao;
    @NonNull
    @JsonProperty("composicao")
    private String composicao;
    @NonNull
    @JsonProperty("precoVenda")
    private Double precoVenda;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "id_tipo_produto")
    private TipoProduto tipoProduto;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "id_fabricante")
    private Fabricante fabricante;
}
