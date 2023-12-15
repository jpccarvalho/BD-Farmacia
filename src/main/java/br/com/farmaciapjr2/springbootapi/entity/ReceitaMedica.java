package br.com.farmaciapjr2.springbootapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "receitas_medica", schema = "bdfarmacia")
@Data
public class ReceitaMedica implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "id_produto_compra")
    private ProdutoCompra produtoCompra;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "id_medico")
    private Medico medico;

    @NonNull
    @JsonProperty("receita")
    private String receita;

    public ReceitaMedica(Medico medico, ProdutoCompra pc, String receita) {
        this.medico = medico;
        this.produtoCompra = pc;
        this.receita = receita;
    }
}
