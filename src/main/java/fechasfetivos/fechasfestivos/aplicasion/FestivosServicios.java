package fechasfetivos.fechasfestivos.aplicasion;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import org.springframework.stereotype.Service;
import fechasfetivos.fechasfestivos.core.interfaces.servicios.InterfazFestivosServicios;
import fechasfetivos.fechasfestivos.core.interfaces.repositorio.InterfazFestivosRepositorio;
import fechasfetivos.fechasfestivos.core.interfaces.servicios.InterfazFestivosServicios;
import fechasfetivos.fechasfestivos.dominio.entidades.festivos;
import fechasfetivos.fechasfestivos.dominio.entidades.TipoFestivo;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FestivosServicios implements InterfazFestivosServicios {

    private InterfazFestivosRepositorio festivosRepositorio;
    private final ServicioFechas servicioFechas; // Aquí se usa la clase de cálculo

    public FestivosServicios(InterfazFestivosRepositorio festivosRepositorio, ServicioFechas servicioFechas) {
        this.festivosRepositorio = festivosRepositorio;
        this.servicioFechas = servicioFechas;

        this.festivosRepositorio = festivosRepositorio;
    }

    public List<festivos> obtenerTodos() {

        return festivosRepositorio.findAll();
    }

    

    @Override
    public boolean esFestivo(String fechaStr) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date fecha;
    
        try {
            // Convertir fecha de String a Date
            fecha = sdf.parse(fechaStr);
        } catch (ParseException e) {
            return false; // Si el formato es incorrecto, no es festivo
        }
    
        // Convertir a LocalDate para extraer partes de la fecha
        LocalDate localDate = LocalDate.parse(fechaStr, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        int anio = localDate.getYear();
        int mes = localDate.getMonthValue();
        int dia = localDate.getDayOfMonth();
    
        // Obtener la lista de festivos
        List<festivos> registros = obtenerTodos();
    
        // Iterar sobre los registros y verificar si es festivo
        for (festivos registro : registros) {
            // Verificar festivos fijos
            if (registro.getDia() == dia && registro.getMes() == mes && registro.getTipo() == 1) {
                return true;
            }
    
            // Verificar festivos tipo 2 (puente festivo)
            if (registro.getTipo() == 2) {
                Date siguienteLunes = ServicioFechas.siguienteLunes(fecha);
                if (fecha.equals(siguienteLunes)) {
                    return true;
                }
            }
    
            // Verificar festivos tipo 3 (relacionados con Semana Santa)
            if (registro.getTipo() == 3) {
                Date domingoPascua = ServicioFechas.agregarDias(ServicioFechas.getInicioSemanaSanta(anio), 7);
                Date juevesSanto = ServicioFechas.agregarDias(domingoPascua, -3);
                Date viernesSanto = ServicioFechas.agregarDias(domingoPascua, -2);
                if (fecha.equals(domingoPascua) || fecha.equals(juevesSanto) || fecha.equals(viernesSanto)) {
                    return true;
                }
            }
    
            // Verificar festivos tipo 4 (Semana Santa + puente festivo)
            if (registro.getTipo() == 4) {
                Date domingoPascua = ServicioFechas.agregarDias(ServicioFechas.getInicioSemanaSanta(anio), 7);
                Date ascension = ServicioFechas.siguienteLunes(ServicioFechas.agregarDias(domingoPascua, 40));
                Date corpusChristi = ServicioFechas.siguienteLunes(ServicioFechas.agregarDias(domingoPascua, 61));
                Date sagradoCorazon = ServicioFechas.siguienteLunes(ServicioFechas.agregarDias(domingoPascua, 68));
                if (fecha.equals(ascension) || fecha.equals(corpusChristi) || fecha.equals(sagradoCorazon)) {
                    return true;
                }
            }
        }
    
        // Si no se encuentra coincidencia, no es festivo
        return false;
    }
    
    }

