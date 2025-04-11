package dss.birbnb_ahk.entities.notificaciones;
import dss.birbnb_ahk.entities.reservas.EstadoReserva;
import dss.birbnb_ahk.entities.reservas.Reserva;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FactoryNotificacion {
    private String crearMensaje( Reserva reserva){
        return switch (reserva.getEstado()){
            case PENDIENTE -> "Tenes una reserva de"+ reserva.getHuesped().getNombre()
                    +", para el alojamiento"+ reserva.getAlojamiento().getNombre()
                    +", desde el dia"+ reserva.getRangoFechas().getFechaInicio().toString()
                    +"hasta el dia"+ reserva.getRangoFechas().getFechaFin().toString()
                    +".";

            case CONFIRMADA -> "La reserva para el alojamiento"+ reserva.getAlojamiento().getNombre()
                    +", desde el dia"+ reserva.getRangoFechas().getFechaInicio().toString()
                    +", hasta el dia"+ reserva.getRangoFechas().getFechaFin().toString()
                    +"fue confirmada.";

            case CANCELADA -> "La reserva de"+ reserva.getHuesped().getNombre()
                    +", para el alojamiento"+ reserva.getAlojamiento().getNombre()
                    +", desde el dia"+ reserva.getRangoFechas().getFechaInicio().toString()
                    +"hasta el dia"+ reserva.getRangoFechas().getFechaFin().toString()
                    +"fue CANCELADA .";
        };
    }

    public Notificacion crearSegunReserva(Reserva reserva){
        Notificacion noti=new Notificacion();

        if(reserva.getEstado().equals(EstadoReserva.PENDIENTE)){
            noti.setUsuario(reserva.getAlojamiento().getAnfitrion());
        }
        else if (reserva.getEstado().equals(EstadoReserva.CONFIRMADA)){
            noti.setUsuario(reserva.getHuesped());
        }
        else if (reserva.getEstado().equals(EstadoReserva.CANCELADA)){
            noti.setUsuario(reserva.getAlojamiento().getAnfitrion());
        }

        noti.setMensaje(this.crearMensaje(reserva));
        return noti;
    }
}
