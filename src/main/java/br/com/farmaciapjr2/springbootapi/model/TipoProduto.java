package br.com.farmaciapjr2.springbootapi.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tipos_produtos")
@Data
public class TipoProduto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipo;
}
