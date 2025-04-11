package dss.birbnb_ahk.entities.ubicaciones;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "direccion")
@Entity
public class Direccion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;

    @Column(name = "calle")
    private String calle;

    @Column(name = "altura")
    private String altura;

    @Column(name = "latitud")
    private Long latitud;

    @Column(name = "longitud")
    private Long longitud;

    @ManyToOne
    @JoinColumn(name = "ciudad_id", nullable = false)
    private Ciudad ciudad;
}
