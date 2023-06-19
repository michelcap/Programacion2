package test;

import entidades.Cliente;
import entidades.Factura;
import entidades.MiCuentaFacilMgr;
import entidades.adt.linkedlist.MyList;
import exceptions.InformacionInvalida;
import exceptions.ObjetoNoExiste;

import java.time.LocalDate;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MiCuentaFacilMgrTest {

    MiCuentaFacilMgr mi = new MiCuentaFacilMgr();

    @org.junit.jupiter.api.Test
    void agregarFactura() throws InformacionInvalida {
        mi.agregarFactura("Antel", 40178007, "otros", LocalDate.parse("2023-06-12"), 1890);
        assertThrows(InformacionInvalida.class, ()->{mi.agregarFactura("", 401780078, "otros", LocalDate.parse("2023-06-12"), 1890); });
    }

    @org.junit.jupiter.api.Test
    void obtenerFacturasNoPagas() throws InformacionInvalida, ObjetoNoExiste {
        mi.agregarFactura("Antel", 40178007, "otros", LocalDate.parse("2023-06-12"), 1890);
        mi.agregarFactura("Ose", 40178007, "otros", LocalDate.parse("2023-04-12"), 800);
        mi.agregarFactura("Ute", 40178007, "otros", LocalDate.parse("2023-05-12"), 2000);
        MyList<Factura> lista = mi.obtenerFacturasNoPagas(40178007);
        assertNotNull(lista);
        assertThrows(InformacionInvalida.class, ()->{mi.obtenerFacturasNoPagas(-1);});
        assertThrows(ObjetoNoExiste.class, ()->{mi.obtenerFacturasNoPagas(40178009);});
    }

    @org.junit.jupiter.api.Test
    void pagarFactura() throws InformacionInvalida, ObjetoNoExiste {
        mi.agregarFactura("Antel", 40178007, "otros", LocalDate.parse("2023-06-12"), 1890);
        mi.agregarFactura("Ose", 40178007, "otros", LocalDate.parse("2023-04-12"), 800);
        mi.agregarFactura("Ute", 40178007, "otros", LocalDate.parse("2023-05-12"), 2000);
        mi.pagarFactura("Antel", 1, 40178007, null);
        MyList<Factura> lista = mi.obtenerFacturasNoPagas(40178007);
        assertNotNull(lista);
        assertEquals(lista.size(), 2);
    }

    @org.junit.jupiter.api.Test
    void obtenerClientesConDeudaVencida() throws InformacionInvalida, ObjetoNoExiste {
        mi.agregarFactura("Antel", 40178007, "otros", LocalDate.parse("2023-06-12"), 1890);
        mi.agregarFactura("Ose", 40178007, "otros", LocalDate.parse("2023-04-12"), 800);
        mi.agregarFactura("Ute", 40178007, "otros", LocalDate.parse("2023-05-12"), 2000);

        mi.agregarFactura("Antel", 40178008, "otros", LocalDate.parse("2024-06-12"), 1890);
        mi.agregarFactura("Ose", 40178008, "otros", LocalDate.parse("2024-04-12"), 800);
        mi.agregarFactura("Ute", 40178008, "otros", LocalDate.parse("2024-05-12"), 2000);

        mi.agregarFactura("Antel", 40178009, "otros", LocalDate.parse("2023-01-12"), 1890);

        mi.agregarFactura("Ose", 40178097, "otros", LocalDate.parse("2023-02-12"), 800);

        mi.agregarFactura("Ute", 40178907, "otros", LocalDate.parse("2023-03-12"), 2000);
        MyList<Cliente> lista = mi.obtenerClientesConDeudaVencida();
        assertNotNull(lista);

        for (Cliente cliente : lista) {
            System.out.print(cliente.toString());
        }
    }
}