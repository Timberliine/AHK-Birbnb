package dss.birbnb_ahk.entities.ubicaciones;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "pais")
public class Pais {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;

    @Column(name = "nombre", columnDefinition = "VARCHAR(50)")
    private String nombre;

    public Pais(String nombre) {
        this.nombre = nombre;
    }
}
