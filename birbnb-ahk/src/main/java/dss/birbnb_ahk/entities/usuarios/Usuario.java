package dss.birbnb_ahk.entities.usuarios;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "email")
    private String email;

    @Enumerated(EnumType.STRING)
    private TipoUsuario tipo;
}
