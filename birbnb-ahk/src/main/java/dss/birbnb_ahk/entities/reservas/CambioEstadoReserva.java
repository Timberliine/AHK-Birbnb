package dss.birbnb_ahk.entities.reservas;
import dss.birbnb_ahk.entities.usuarios.Usuario;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "reserva_cambio_estado")
public class CambioEstadoReserva {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;

    @Column(columnDefinition = "DATE")
    private LocalDate fecha;
    @Enumerated(EnumType.STRING)
    private EstadoReserva estado;
    @ManyToOne
    @JoinColumn(name = "reserva_id", nullable = false)
    private Reserva reserva;
    @Column
    private String motivo;
    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;
}
