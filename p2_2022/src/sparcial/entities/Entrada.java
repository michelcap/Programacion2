package sparcial.entities;

import java.util.Objects;

public class Entrada implements Comparable<Entrada> {
    String codigo;
    Aficionado aficionado;
    String pasaporteAficionado;

    public Entrada(String pasaporteAficionado) {
        this.pasaporteAficionado = pasaporteAficionado;
    }
    public Entrada(String codigo, Aficionado aficionado) {
        this.codigo = codigo;
        this.aficionado = aficionado;
        this.pasaporteAficionado = aficionado.getPasaporte();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Entrada entrada)) return false;

        if (!Objects.equals(codigo, entrada.codigo)) return false;
        if (!Objects.equals(aficionado, entrada.aficionado)) return false;
        return Objects.equals(pasaporteAficionado, entrada.pasaporteAficionado);
    }

    @Override
    public int hashCode() {
        int result = codigo != null ? codigo.hashCode() : 0;
        result = 31 * result + (aficionado != null ? aficionado.hashCode() : 0);
        result = 31 * result + (pasaporteAficionado != null ? pasaporteAficionado.hashCode() : 0);
        return result;
    }

    @Override
    public int compareTo(Entrada o) {
        int retorno = -1;
        if (Objects.equals(this.pasaporteAficionado, o.getPasaporteAficionado())){
            retorno = 0;
        }
        return retorno;
    }

    private String getPasaporteAficionado() {
        return this.pasaporteAficionado;
    }
}
