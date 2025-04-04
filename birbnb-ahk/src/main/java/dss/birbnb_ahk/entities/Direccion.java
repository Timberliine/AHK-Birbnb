package dss.birbnb_ahk.entities;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Direccion {
    private String calle;
    private String altura;
    private Long latitud;
    private Long longitud;
    private Ciudad ciudad;
}
