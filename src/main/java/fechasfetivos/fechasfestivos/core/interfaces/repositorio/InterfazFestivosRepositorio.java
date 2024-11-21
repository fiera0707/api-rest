package fechasfetivos.fechasfestivos.core.interfaces.repositorio;

//package fechasfetivos.fechasfestivos.interfaces.core.repositorio;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import fechasfetivos.fechasfestivos.dominio.entidades.TipoFestivo;
import fechasfetivos.fechasfestivos.dominio.entidades.festivos;
import java.util.Optional;

public interface InterfazFestivosRepositorio extends JpaRepository<festivos, Integer> {
    Optional<festivos> buscarFestivoPorFecha(String fecha);

}
