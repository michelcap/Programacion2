package entidades;

import java.time.LocalDate;

public class Factura {
    private long numeroFactura = 0;
    private String nombreServicio;
    private long cedulaCliente;
    private String concepto;
    private LocalDate vencimiento;
    private long importe;
    private boolean estaPaga;
    private LocalDate fechaDePago;

    public Factura(String nombreServicio, String concepto, LocalDate vencimiento, long importe) {
        this.numeroFactura += 1;
        this.nombreServicio = nombreServicio;
        this.concepto = concepto;
        this.vencimiento = vencimiento;
        this.importe = importe;
        this.estaPaga = false;
    }

    public boolean isPaga() {
        return estaPaga;
    }

    public void setEstaPaga(boolean estaPaga) {
        this.estaPaga = estaPaga;
    }

    public long getNumeroFactura() {
        return numeroFactura;
    }

    public LocalDate getVencimiento() {
        return vencimiento;
    }

    public void setFechaDePago(LocalDate fechaDePago) {
        this.fechaDePago = fechaDePago;
    }

    public long getCedulaCliente() {
        return cedulaCliente;
    }

    public void setCedulaCliente(long cedulaCliente) {
        this.cedulaCliente = cedulaCliente;
    }
}
