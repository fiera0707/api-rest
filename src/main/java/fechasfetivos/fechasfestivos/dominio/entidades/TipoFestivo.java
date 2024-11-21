package fechasfetivos.fechasfestivos.dominio.entidades;
import jakarta.persistence.*;
//import java.time.LocalDate;

@Entity
@Table(name = "tipos_festivos")
public class TipoFestivo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255)
    private String descripcion;

    public TipoFestivo(Long id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    public TipoFestivo() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Long getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    

}