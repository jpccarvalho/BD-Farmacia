package br.com.farmaciapjr2.springbootapi.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "cliente", schema = "bdfarmacia")
@Data
public class Cliente implements Serializable {
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

    public Cliente(@NonNull String nome, @NonNull String endereco, @NonNull String telefone, @NonNull String codigoPostal, @NonNull String localidade, @NonNull String numeroContribuinte) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.codigoPostal = codigoPostal;
        this.localidade = localidade;
        this.numeroContribuinte = numeroContribuinte;
    }
}
