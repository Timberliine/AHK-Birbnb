package dss.birbnb_ahk.entities;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class rangoFechas {
    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    public boolean haySuperposicionCon(rangoFechas rango) {
        return this.fechaInicio.isBefore(rango.getFechaFin()) &&
                rango.getFechaInicio().isBefore(this.fechaFin);
    }
}
