import javax.persistence.*;
import lombok.*;

@Entity
@Table(name = "cliente")
@Data
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String endereco;
    private String telefone;
    private String codigoPostal;
    private String localidade;
    private String numeroContribuinte;
}
