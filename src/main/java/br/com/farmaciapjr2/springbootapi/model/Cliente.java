package br.com.farmaciapjr2.springbootapi.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "cliente")
@Data
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("nome")
    private String nome;
    @JsonProperty("endereco")
    private String endereco;
    @JsonProperty("telefone")
    private String telefone;
    @JsonProperty("codigoPostal")
    private String codigoPostal;
    @JsonProperty("localidade")
    private String localidade;
    @JsonProperty("numeroContribuinte")
    private String numeroContribuinte;
}
