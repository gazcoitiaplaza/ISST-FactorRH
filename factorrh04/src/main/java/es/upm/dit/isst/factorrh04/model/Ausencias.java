package es.upm.dit.isst.factorrh04.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Ausencias {

    public enum TipoAusencia {
        BAJA,
        AUSENCIA,
        VACACIONES
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "nombre_usuario", length = 50) // Agregamos el nombre de usuario
    private String nombreUsuario; // Cambiamos Empleado a String

    private Date fechaInicio;
    private Date fechaFin;
    private TipoAusencia tipoAusencia;
    private boolean autorizada;
    private String notas;

    // Getters and setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    // Cambiamos Empleado a String y agregamos getters y setters
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public TipoAusencia getTipoAusencia() {
        return tipoAusencia;
    }

    public void setTipoAusencia(TipoAusencia tipoAusencia) {
        this.tipoAusencia = tipoAusencia;
    }

    public boolean isAutorizada() {
        return autorizada;
    }

    public void setAutorizada(boolean autorizada) {
        this.autorizada = autorizada;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }
}
