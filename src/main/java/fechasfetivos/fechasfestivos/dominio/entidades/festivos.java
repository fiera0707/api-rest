package fechasfetivos.fechasfestivos.dominio.entidades;

import java.time.LocalDate;

import org.hibernate.annotations.IdGeneratorType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.TableGenerator;

@Entity
@TableGenerator(name = "Fetivos")
public class festivos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private int dia;

    @Column(nullable = false, unique = true)
    private int mes;

    @Column(nullable = false, length = 255)
    private String nombre;

    @Column(nullable = false)
    private Integer tipo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tipo", insertable = false, updatable = false)
    private TipoFestivo tipoFestivo;

    @Column(nullable = false, unique = true)
    private int diasDePascua;

    public festivos(Long id, int dia, int mes, String nombre, Integer tipo, TipoFestivo tipoFestivo, int diasDePascua) {
        this.id = id;
        this.dia = dia;
        this.mes = mes;
        this.nombre = nombre;
        this.tipo = tipo;
        this.tipoFestivo = tipoFestivo;
        this.diasDePascua = diasDePascua;
    }

    public festivos() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public TipoFestivo getTipoFestivo() {
        return tipoFestivo;
    }

    public void setTipoFestivo(TipoFestivo tipoFestivo) {
        this.tipoFestivo = tipoFestivo;
    }

    public int getDiasDePascua() {
        return diasDePascua;
    }

    public void setDiasDePascua(int diasDePascua) {
        this.diasDePascua = diasDePascua;
    }
}

.....

/*
 * CREATE TABLE festivos (
 * id SERIAL PRIMARY KEY,
 * nombre VARCHAR(255) NOT NULL,
 * fecha DATE NOT NULL UNIQUE,
 * tipo INTEGER NOT NULL CHECK (tipo BETWEEN 1 AND 4)
 */