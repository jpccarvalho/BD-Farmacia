package br.com.farmaciapjr2.springbootapi.model;

import jakarta.persistence.*;
import java.util.Date;
import lombok.*;

@Entity
@Table(name = "compras")
@Data
public class Compra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @Temporal(TemporalType.DATE)
    private Date dataCompra;
}
