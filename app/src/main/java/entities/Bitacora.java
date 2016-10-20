package entities;

import java.util.Date;

/**
 * Created by ddelacruz on 20/10/2016.
 */

public class Bitacora {
    private Date fecha;
    private String descripcion;
    private String estado;

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
