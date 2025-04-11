package dss.birbnb_ahk.entities.alojamientos;
import dss.birbnb_ahk.entities.ubicaciones.Direccion;
import dss.birbnb_ahk.entities.Moneda;
import dss.birbnb_ahk.entities.reservas.Reserva;
import dss.birbnb_ahk.entities.reservas.rangoFechas;
import dss.birbnb_ahk.entities.usuarios.Usuario;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "alojamiento")
public class Alojamiento {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Setter
    @Getter
    @Column
    private String nombre;

    @Setter
    @Getter
    @Column(columnDefinition = "TEXT")
    private String descripcion;

    @Setter
    @Getter
    @Column(columnDefinition = "TIME")
    private LocalTime horarioCheckIn;

    @Setter
    @Getter
    @Column(columnDefinition = "TIME")
    private LocalTime horarioCheckOut;

    @Setter
    @Getter
    @ManyToOne
    @JoinColumn(name = "anfitrion_id", nullable = false)
    private Usuario anfitrion;

    @Setter
    @Getter
    @Column
    private Double precioPorNoche;

    @Setter
    @Getter
    @Enumerated(EnumType.STRING)
    private Moneda moneda;

    @Setter
    @Getter
    @OneToOne
    @JoinColumn(name = "direccion_id", nullable = false)
    private Direccion direccion;

    @Setter
    @Getter
    @Column
    private Integer cantHuespedesMax;

    @Getter
    @OneToMany
    @JoinColumn(name = "alojamiento_id")
    private List<Foto> fotos;

    @Getter
    @ElementCollection
    @CollectionTable(name = "alojamiento_caracteristica", joinColumns = @JoinColumn(name = "alojamiento_id"))
    @Enumerated(EnumType.STRING)
    @Column(name = "caracteristicas")
    private List<Caracteristica> caracteristicas;

    @Getter
    @OneToMany(mappedBy = "alojamiento")
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

        //return !this.reservas.stream().anyMatch(r -> r.getRangoFechas().haySuperposicionCon(rango));

        for (int i = 0; i < this.reservas.size(); i++) {
            Reserva reservaActual = this.reservas.get(i);
            if (reservaActual.getRangoFechas().haySuperposicionCon(rango)){
                return false;
            }
        }

        return true;

    }

    public Boolean tenesCaracteristica(Caracteristica caracteristica){
        return this.caracteristicas.contains(caracteristica);
    }

    public Boolean puedenAlojarse(Integer cantHuespedes){
        return cantHuespedes <= this.cantHuespedesMax;
    }
}
