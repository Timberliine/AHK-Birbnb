package dss.birbnb_ahk.entities;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CambioEstadoReserva {
    private LocalDate fecha;
    private EstadoReserva estado;
    private Reserva reserva;
    private String motivo;
    private Usuario usuario;
}
