package br.com.farmaciapjr2.springbootapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
import lombok.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "compras", schema = "bdfarmacia")
@Data
public class Compra implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @NonNull
    @Temporal(TemporalType.DATE)
    private Date dataCompra;
}
