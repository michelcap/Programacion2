package entities;

public class RestringirAcceso {
    Long tiempoPermitidoDiario;
    Aplicaciones aplicacion;

    public RestringirAcceso(Aplicaciones app, long tiempoPermitido) {
        this.aplicacion = app;
        this.tiempoPermitidoDiario = tiempoPermitido;
    }

    public Long getTiempoPermitidoDiario() {
        return tiempoPermitidoDiario;
    }

    public void setTiempoPermitidoDiario(Long tiempoPermitidoDiario) {
        this.tiempoPermitidoDiario = tiempoPermitidoDiario;
    }

    public String getNombreAplicacion() {
        return aplicacion.nobreAplicacion();
    }

    public void setAplicacion(Aplicaciones aplicacion) {
        this.aplicacion = aplicacion;
    }

    @Override
    public boolean equals(Object o) {
        if (this.aplicacion == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RestringirAcceso that = (RestringirAcceso) o;

        return aplicacion.equals(that.aplicacion);
    }
}
