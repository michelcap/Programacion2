package sparcial.entities;

public class Aficionado {
    private String pasaporteAficionado;
    private String paisOrigen;

    public Aficionado(String pasaporteAficionado, String paisOrigen) {
        this.pasaporteAficionado = pasaporteAficionado;
        this.paisOrigen = paisOrigen;
    }

    public Aficionado(String pasaporteAficionado) {
        this.pasaporteAficionado = pasaporteAficionado;
    }

    public String getPasaporte() {
        return pasaporteAficionado;
    }
}
