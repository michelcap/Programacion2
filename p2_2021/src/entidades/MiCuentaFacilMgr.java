package entidades;

import entidades.adt.hash.MyHash;
import entidades.adt.hash.MyHashImpl;
import entidades.adt.heap.MyHeap;
import entidades.adt.heap.MyHeapImpl;
import entidades.adt.linkedlist.MyLinkedListImpl;
import entidades.adt.linkedlist.MyList;
import exceptions.InformacionInvalida;
import exceptions.ObjetoNoExiste;
import entidades.adt.binarytree.MySearchBinaryTree;
import entidades.adt.binarytree.MySearchBinaryTreeImpl;

import java.time.LocalDate;

import static java.time.LocalTime.now;

public class MiCuentaFacilMgr {

    MySearchBinaryTree<Long, Cliente> clientes;
    MyHash<String, Servicio> servicios;

    public MiCuentaFacilMgr() {
        clientes = new MySearchBinaryTreeImpl<Long, Cliente>();
        servicios = new MyHashImpl<String, Servicio>();
    }

    public void agregarFactura(String nombreServicio, long cedulaCliente, String concepto, LocalDate vencimiento, long importe) throws InformacionInvalida {
        if ((nombreServicio == null || nombreServicio.equals("")) ||
                (cedulaCliente < 0 || Long.toString(Math.abs(cedulaCliente)).length() < 8 || Long.toString(Math.abs(cedulaCliente)).length() > 9)
                || (concepto == null || concepto.equals("")) || (vencimiento == null || vencimiento.equals(""))
                || (importe < 0)) {
            throw new InformacionInvalida("Datos Ingresados Invalidos");
        }

        Cliente cliente;
        Servicio servicio;

        if (!clientes.contains(cedulaCliente)) {
            cliente = new Cliente(cedulaCliente);
            clientes.add(cedulaCliente, cliente);
        } else {
            cliente = clientes.find(cedulaCliente);
        }

        if (!servicios.contains(nombreServicio)) {
            servicio = new Servicio(nombreServicio);
        } else {
            servicio = servicios.get(nombreServicio);
        }

        Factura factura = new Factura(nombreServicio, concepto, vencimiento, importe);

        servicio.addFactura(cedulaCliente, factura);
        servicios.put(nombreServicio, servicio);
    }

    public MyList<Factura> obtenerFacturasNoPagas(long cedulaCliente) throws ObjetoNoExiste, InformacionInvalida {
        MyList<Servicio> listaServicios;
        MyList<Factura> listaFacturasNoPagas = new MyLinkedListImpl<>();

        if ((cedulaCliente < 0 || Long.toString(Math.abs(cedulaCliente)).length() < 8 || Long.toString(Math.abs(cedulaCliente)).length() > 9)) {
            throw new InformacionInvalida("Datos Ingresados Invalidos");
        }

        if (!clientes.contains(cedulaCliente)) {
            throw new ObjetoNoExiste("cliente no existe: " + cedulaCliente);
        }

        listaServicios = servicios.values();
        for (Servicio value : listaServicios) {
            MyList<Factura> subLista;
            subLista = value.getFacturasImpagas(cedulaCliente);
            if (subLista != null) {
                for (Factura factura : subLista) {
                    listaFacturasNoPagas.add(factura);
                }
            }
        }

        return listaFacturasNoPagas;
    }

    public void pagarFactura(String nombreServicio, long numeroFactura, long cedulaCliente, LocalDate fechaPago) throws InformacionInvalida, ObjetoNoExiste {
        if (fechaPago == null) {
            fechaPago = LocalDate.now();
        }
        if ((nombreServicio==null || nombreServicio.equals("")) || (numeroFactura<0) || (cedulaCliente < 0 || Long.toString(Math.abs(cedulaCliente)).length() < 8 || Long.toString(Math.abs(cedulaCliente)).length() > 9)) {
            throw new InformacionInvalida("Informacion invalida en Pago Factura");
        }
        if (!clientes.contains(cedulaCliente)) {
            throw new ObjetoNoExiste("No existe el cliente " + cedulaCliente);
        }
        if(!servicios.contains(nombreServicio)) {
            throw new ObjetoNoExiste("No existe el servicio " + nombreServicio);
        }
        Servicio servicio = servicios.get(nombreServicio);
        servicio.pagarFactura(numeroFactura, cedulaCliente, fechaPago);
    }

    public MyList<Cliente> obtenerClientesConDeudaVencida() {
        MyList<Servicio> listaServicios = servicios.values();
        MyList<Cliente> retorno = new MyLinkedListImpl<>();
        MyHeap<Cliente> heapClientes = new MyHeapImpl<>(false);
        for (Long cedula : clientes.inOrder()) {
            for (Servicio value : listaServicios) {
                if (value.isVencidas(cedula)) {
                    if (clientes.find(cedula).getDiasFacturaVencida() < value.getDiferencia()) {
                        clientes.find(cedula).setDiasFacturaVencida(value.getDiferencia());
                    }
                }
            }
        }
        for (Long cedula : clientes.inOrder()) {
            if (clientes.find(cedula).getDiasFacturaVencida() != 0) {
                heapClientes.insert(clientes.find(cedula));
            }
        }
        while (heapClientes.size() > 0) {
            retorno.add(heapClientes.delete());
        }
        return retorno;
    }

}
