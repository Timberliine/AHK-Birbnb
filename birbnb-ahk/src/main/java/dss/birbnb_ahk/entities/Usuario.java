package dss.birbnb_ahk.entities;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Usuario {
    private String nombre;
    private String email;
    private TipoUsuario tipo;
}
