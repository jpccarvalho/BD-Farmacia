package br.com.farmaciapjr2.springbootapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "medicos", schema = "bdfarmacia")
@Data
public class Medico implements Serializable {
    @Id
    @NonNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @JsonProperty("nome")
    private String nome;

    @NonNull
    @JsonProperty("CRM")
    private String CRM;
}
