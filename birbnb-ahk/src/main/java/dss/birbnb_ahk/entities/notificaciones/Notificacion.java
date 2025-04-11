package dss.birbnb_ahk.entities.notificaciones;
import dss.birbnb_ahk.entities.usuarios.Usuario;
import jakarta.persistence.*;
import lombok.Setter;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Setter
@Getter
@Entity
@Table(name = "notificacion")
public class Notificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private UUID id;

    @Column
    private String mensaje;
    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @Column(columnDefinition = "DATE")
    private LocalDate fechaAlta;
    @Column
    private Boolean leida;
    @Column(columnDefinition = "DATETIME")
    private LocalDateTime fechaLeida;


    public Notificacion(){
        this.leida=false;
        this.fechaAlta=LocalDate.now();
    }
    public void marcarComoLeida(){
        this.leida=true;
        this.fechaLeida=LocalDateTime.now();
    }
}
