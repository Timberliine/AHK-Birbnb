package dss.birbnb_ahk.entities;
import lombok.Setter;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Setter
@Getter
public class Notificacion {
    private String mensaje;
    private Usuario usuario;
    private LocalDate fechaAlta;
    private Boolean leida;
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
