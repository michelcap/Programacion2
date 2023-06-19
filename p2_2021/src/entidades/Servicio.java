package entidades;

import entidades.adt.hash.MyHash;
import entidades.adt.hash.MyHashImpl;
import entidades.adt.linkedlist.MyLinkedListImpl;
import entidades.adt.linkedlist.MyList;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Servicio {
    String nombreServicio;
    Long diferencia;
    MyHash<Long, MyList<Factura>> facturasImpagas;
    MyHash<Long, MyList<Factura>> facturasPagas = new MyHashImpl<>();

    public Servicio(String nombreServicio) {
        this.nombreServicio = nombreServicio;
        this.facturasImpagas = new MyHashImpl<>();
    }

    public Long getDiferencia() {
        return diferencia;
    }

    public void setDiferencia(Long diferencia) {
        this.diferencia = diferencia;
    }

    public void addFactura(Long cedulaCliente, Factura factura) {
        MyList<Factura> facturasCliente;

        // Si la cedulaCliente no existe en facturasImpagas, inicializamos una nueva lista
        if (!facturasImpagas.contains(cedulaCliente)) {
            facturasCliente = new MyLinkedListImpl<>();
            factura.setCedulaCliente(cedulaCliente);
            facturasCliente.add(factura);
            facturasImpagas.put(cedulaCliente, facturasCliente);
        }
        // Si la cedulaCliente ya existe en facturasImpagas, obtenemos la lista existente
        else {
            facturasCliente = facturasImpagas.get(cedulaCliente);
            factura.setCedulaCliente(cedulaCliente);
            facturasCliente.add(factura);
            facturasImpagas.put(cedulaCliente, facturasCliente);
        }
    }

    public MyList<Factura> getFacturasImpagas(long cedulaCliente) {
        MyList<Factura> retorno = new MyLinkedListImpl<>();
        MyList<Factura> lista;
        // Si la cedulaCliente no existe en facturasImpagas, inicializamos una nueva lista
        if (!facturasImpagas.contains(cedulaCliente)) {
            retorno = null;
        }
        // Si la cedulaCliente ya existe en facturasImpagas, obtenemos la lista existente
        else {
            lista = facturasImpagas.get(cedulaCliente);
            for (Factura value : lista) {
                if (!value.isPaga()) {
                    retorno.add(value);
                }
            }
        }
        return retorno;
    }

    public boolean isVencidas(long cedulaCliente) {
        boolean retorno = false;
        MyList<Factura> facturas = facturasImpagas.get(cedulaCliente);
        if (facturas != null) {
            for (Factura factura : facturas) {
                if (factura != null && !factura.isPaga() && factura.getVencimiento().isBefore(LocalDate.now())) {
                    retorno = true;
                    this.diferencia = ChronoUnit.DAYS.between(factura.getVencimiento(), LocalDate.now());
                }
            }
        }
        return retorno;
    }

    public void pagarFactura(long numeroFactura, long cedulaCliente, LocalDate fechaPago) {
        MyList<Factura> listaFacturaCliente = facturasImpagas.get(cedulaCliente);

        for (Factura value : listaFacturaCliente) {
            if (!value.isPaga() && value.getNumeroFactura() == numeroFactura) {
                value.setEstaPaga(true);
                value.setFechaDePago(fechaPago);
                MyList<Factura> pagas = facturasPagas.get(cedulaCliente);
                if (pagas == null) {
                    pagas = new MyLinkedListImpl<>();
                }
                pagas.add(value);
                facturasPagas.put(cedulaCliente, pagas);
                listaFacturaCliente.remove(value);
            }
        }

        facturasImpagas.put(cedulaCliente, listaFacturaCliente);
    }
}
