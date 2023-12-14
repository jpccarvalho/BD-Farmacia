package br.com.farmaciapjr2.springbootapi.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

@Builder
@Entity
@Table(name = "cliente")
@Data
public class Cliente {
    @Id
    @NonNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @JsonProperty("nome")
    private String nome;

    @NonNull
    @JsonProperty("endereco")
    private String endereco;

    @NonNull
    @JsonProperty("telefone")
    private String telefone;

    @NonNull
    @JsonProperty("codigoPostal")
    private String codigoPostal;

    @NonNull
    @JsonProperty("localidade")
    private String localidade;

    @NonNull
    @JsonProperty("numeroContribuinte")
    private String numeroContribuinte;
}
