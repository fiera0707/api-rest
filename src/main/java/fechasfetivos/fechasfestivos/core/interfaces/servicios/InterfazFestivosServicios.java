package fechasfetivos.fechasfestivos.core.interfaces.servicios;

import java.util.List;
import fechasfetivos.fechasfestivos.dominio.entidades.festivos;
import fechasfetivos.fechasfestivos.dominio.entidades.TipoFestivo;
//   package core.servicios;

public interface InterfazFestivosServicios {
  boolean esFestivo(String fecha);

  public List<festivos> obtenerTodos();
  // public List<Campeonato> listar();

  // public festivos obtener(Integer id);

  //public int buscar();

  // public festivos agregar(festivos pais);

  // public festivos modificar(festivos pais);

  /// public boolean eliminar(Integer id);

  // public List<TipoFestivo> obtenerGrupos(Integer id);

}
