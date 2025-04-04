package dss.birbnb_ahk.entities;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Alojamiento {

    @Setter
    @Getter
    private String nombre;

    @Setter
    @Getter
    private String descripcion;

    @Setter
    @Getter
    private LocalTime horarioCheckIn;

    @Setter
    @Getter
    private LocalTime horarioCheckOut;

    @Setter
    @Getter
    private Usuario anfitrion;

    @Setter
    @Getter
    private Double precioPorNoche;

    @Setter
    @Getter
    private Moneda moneda;

    @Setter
    @Getter
    private Direccion direccion;

    @Setter
    @Getter
    private Integer cantHuespedesMax;

    @Getter
    private List<Foto> fotos;

    @Getter
    private List<Caracteristica> caracteristicas;

    @Getter
    private List<Reserva> reservas;

    public Alojamiento() {
        this.fotos = new ArrayList<>();
        this.caracteristicas = new ArrayList<>();
        this.reservas = new ArrayList<>();
    }

    public Boolean tuPrecioEstaDentroDe(Double valorMinimo, Double valorMax) {
        return this.precioPorNoche <= valorMax && this.precioPorNoche >= valorMinimo;
    }

    public Boolean estasDisponibleEn(rangoFechas rango) {
       /* boolean haySuperposicion = false;
        int i = 0;

        while (i < this.reservas.size() && !haySuperposicion) {
            Reserva reserva = this.reservas.get(i);
            rangoFechas rangoDeLaReserva = reserva.getRangoFechas();

            if (rangoDeLaReserva.haySuperposicionCon(rango)) {
                haySuperposicion = true;
            }
            i++;
        }
        return !haySuperposicion;*/
        return this.reservas.stream().anyMatch(r -> r.getRangoFechas().haySuperposicionCon(rango));

    }

    public Boolean tenesCaracteristica(Caracteristica caracteristica){
        return this.caracteristicas.contains(caracteristica);
    }

    public Boolean puedenAlojarse(Integer cantHuespedes){
        return cantHuespedes <= this.cantHuespedesMax;
    }
}
