package entities;

import java.time.Duration;
import java.time.LocalDateTime;

import static java.time.LocalDateTime.now;

public class RegistroAcceso {
    private LocalDateTime inicio;
    private LocalDateTime fin;
    Aplicaciones aplicacion;
    private boolean running;

    public RegistroAcceso(Aplicaciones app) {
        this.aplicacion = app;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public void iniciar() {
        this.inicio = now();
    }

    public boolean isRunning() {
        return this.running;
    }

    public boolean esDeHoy() {
        Duration Duration = null;
        if (java.time.Duration.between(this.inicio, now()).toHours() < 24){
            return true;
        }
        return false;
    }

    public Long calcularTiempo() {
        return Duration.between(this.inicio, this.fin).toMinutes();
    }

    public void finalizar() {
        this.fin = now();
    }
}
