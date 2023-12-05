import javax.persistence.*;
import lombok.*;

@Entity
@Table(name = "fabricantes")
@Data
public class Fabricante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fabricante;
}
