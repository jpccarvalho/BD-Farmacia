package br.com.farmaciapjr2.springbootapi.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
import lombok.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "compras", schema = "bdfarmacia")
@Data
public class Compra implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @Temporal(TemporalType.DATE)
    private Date dataCompra;
}
