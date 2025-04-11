package dss.birbnb_ahk.entities.reservas;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Embeddable
public class rangoFechas {
    @Column(columnDefinition = "DATE")
    private LocalDate fechaInicio;

    @Column(name = "DATE")
    private LocalDate fechaFin;

    public boolean haySuperposicionCon(rangoFechas rango) {
        return this.fechaInicio.isBefore(rango.getFechaFin()) &&
                rango.getFechaInicio().isBefore(this.fechaFin);
    }
}
