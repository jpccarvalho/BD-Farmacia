import javax.persistence.*;
import lombok.*;

@Entity
@Table(name = "produtos_compra")
@Data
public class ProdutoCompra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_produto")
    private Produto produto;

    @ManyToOne
    @JoinColumn(name = "id_compra")
    private Compra compra;

    private int quantidade;
}
