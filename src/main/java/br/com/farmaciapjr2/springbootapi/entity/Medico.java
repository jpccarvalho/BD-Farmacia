import javax.persistence.*;
import lombok.*;

@Entity
@Table(name = "medicos")
@Data
public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String CRM;
}
