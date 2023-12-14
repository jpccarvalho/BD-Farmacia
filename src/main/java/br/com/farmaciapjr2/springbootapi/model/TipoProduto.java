package br.com.farmaciapjr2.springbootapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

@Builder
@Entity
@Table(name = "tipos_produtos")
@Data
public class TipoProduto {

    @NonNull
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @JsonProperty("tipo")
    private String tipo;
}
