package br.com.farmaciapjr2.springbootapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "produtos_compra", schema = "bdfarmacia")
@Data
public class ProdutoCompra implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "id_produto")
    private Produto produto;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "id_compra")
    private Compra compra;

    @NonNull
    @JsonProperty("quantidade")
    private Integer quantidade;
}
