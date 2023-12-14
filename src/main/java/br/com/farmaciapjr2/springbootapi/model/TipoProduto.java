package br.com.farmaciapjr2.springbootapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tipos_produtos", schema = "bdfarmacia")
@Data
public class TipoProduto implements Serializable {

    public TipoProduto(@NonNull String tipo) {
        this.tipo = tipo;
    }

    @NonNull
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @JsonProperty("tipo")
    private String tipo;
}
