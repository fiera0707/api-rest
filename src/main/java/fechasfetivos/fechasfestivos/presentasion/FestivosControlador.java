package fechasfetivos.fechasfestivos.presentasion;

//package presentacion;
import fechasfetivos.fechasfestivos.core.interfaces.servicios.InterfazFestivosServicios;
import fechasfetivos.fechasfestivos.core.interfaces.repositorio.InterfazFestivosRepositorio;
//import fechasfetivos.fechasfestivos.interfaces.core.servicios.InterfazFestivosServicios;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FestivosControlador {
    private final InterfazFestivosServicios festivosServicios;

    public FestivosControlador(InterfazFestivosServicios festivosServicios) {
        this.festivosServicios = festivosServicios;
    }

    @GetMapping("/esFestivo")
    public boolean esFestivo(@RequestParam String fecha) {
        return festivosServicios.esFestivo(fecha);
    }
}
