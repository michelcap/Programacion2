package entidades;

public class Cliente implements Comparable<Cliente>{
    private long cedula;
    private long diasFacturaVencida = 0;

    public Cliente(long cedula) {
        this.cedula = cedula;
    }

    @Override
    public String toString() {
        return " "+cedula+" ";
    }

    @Override
    public int compareTo(Cliente o) {
        if(this.diasFacturaVencida < o.getDiasFacturaVencida())
            return -1;
        else if(this.diasFacturaVencida > o.getDiasFacturaVencida())
            return 1;
        else
            return 0;
    }

    long getDiasFacturaVencida() {
        return this.diasFacturaVencida;
    }

    public void setDiasFacturaVencida(long diasFacturaVencida) {
        this.diasFacturaVencida = diasFacturaVencida;
    }
}
