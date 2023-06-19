package sparcial;

import exceptions.InformacionInvalida;
import org.junit.jupiter.api.Test;
import sparcial.exceptions.CompraRechazada;
import sparcial.exceptions.EntidadNoExiste;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ControladorMundialTest {

    @Test
    void registrarPartido() throws InformacionInvalida {
        ControladorMundial controladorMundial = new ControladorMundial();
        controladorMundial.registrarPartido(LocalDate.parse("2022-06-21"), "EstadioA",
                50000, "Uruguay", "Argentina");
        controladorMundial.registrarPartido(LocalDate.parse("2022-06-21"), "EstadioB",
                60000, "Alemania", "Brasil");
        controladorMundial.registrarPartido(LocalDate.parse("2022-06-21"), "EstadioV",
                70000, "Ruanda", "China");
        controladorMundial.registrarPartido(LocalDate.parse("2022-06-21"), "EstadioX",
                80000, "Italia", "Korea");
    }
    @Test
    void registrarPartidoException() throws InformacionInvalida {
        ControladorMundial controladorMundial = new ControladorMundial();
        controladorMundial.registrarPartido(LocalDate.parse("2022-06-21"), "EstadioA",
                50000, "Uruguay", "Argentina");
        controladorMundial.registrarPartido(LocalDate.parse("2022-06-21"), "EstadioB",
                60000, "Alemania", "Brasil");
        controladorMundial.registrarPartido(LocalDate.parse("2022-06-21"), "EstadioV",
                70000, "Ruanda", "China");
        controladorMundial.registrarPartido(LocalDate.parse("2022-06-21"), "EstadioX",
                80000, "Italia", "Korea");
        assertThrows(InformacionInvalida.class, ()->{controladorMundial.registrarPartido(LocalDate.parse("2022-06-21"), "EstadioA",
                50000, "Uruguay", "Argentina"); });
        assertThrows(InformacionInvalida.class, ()->{controladorMundial.registrarPartido(LocalDate.parse("2022-06-21"), "",
                50000, "Paraguay", "Brasil"); });

    }

    @Test
    void venderEntrada() throws InformacionInvalida, EntidadNoExiste, CompraRechazada {
        ControladorMundial controladorMundial = new ControladorMundial();
        controladorMundial.registrarPartido(LocalDate.parse("2022-06-21"), "EstadioA",
                50000, "Uruguay", "Argentina");
        controladorMundial.registrarPartido(LocalDate.parse("2022-06-21"), "EstadioB",
                60000, "Alemania", "Brasil");
        controladorMundial.registrarPartido(LocalDate.parse("2022-06-21"), "EstadioV",
                70000, "Ruanda", "China");
        controladorMundial.registrarPartido(LocalDate.parse("2022-06-21"), "EstadioX",
                80000, "Italia", "Korea");
        controladorMundial.venderEntrada("40178007", "Uruguay",LocalDate.parse("2022-06-21"),
                "EstadioA");
        controladorMundial.venderEntrada("12345678", "Australia",LocalDate.parse("2022-06-21"),
                "EstadioX");
    }
    @Test
    void venderEntradaInformacionInvalida() throws InformacionInvalida, EntidadNoExiste, CompraRechazada {
        ControladorMundial controladorMundial = new ControladorMundial();
        controladorMundial.registrarPartido(LocalDate.parse("2022-06-21"), "EstadioA",
                50000, "Uruguay", "Argentina");
        controladorMundial.registrarPartido(LocalDate.parse("2022-06-21"), "EstadioB",
                60000, "Alemania", "Brasil");
        controladorMundial.registrarPartido(LocalDate.parse("2022-06-21"), "EstadioV",
                70000, "Ruanda", "China");
        controladorMundial.registrarPartido(LocalDate.parse("2022-06-21"), "EstadioX",
                80000, "Italia", "Korea");
        assertThrows(InformacionInvalida.class, ()->{controladorMundial.venderEntrada("40178007", "Uruguay",LocalDate.parse("2022-06-21"),
                "E"); });

    }
    @Test
    void venderEntradaEntidadNoExiste() throws InformacionInvalida, EntidadNoExiste, CompraRechazada {
        ControladorMundial controladorMundial = new ControladorMundial();
        controladorMundial.registrarPartido(LocalDate.parse("2022-06-21"), "EstadioA",
                50000, "Uruguay", "Argentina");
        controladorMundial.registrarPartido(LocalDate.parse("2022-06-21"), "EstadioB",
                60000, "Alemania", "Brasil");
        controladorMundial.registrarPartido(LocalDate.parse("2022-06-21"), "EstadioV",
                70000, "Ruanda", "China");
        controladorMundial.registrarPartido(LocalDate.parse("2022-06-21"), "EstadioX",
                80000, "Italia", "Korea");
        assertThrows(EntidadNoExiste.class, ()->{controladorMundial.venderEntrada("40178007", "Uruguay",LocalDate.parse("2025-06-21"),
                "EstadioA"); });

    }
    @Test
    void venderEntradaCompraRechazada() throws InformacionInvalida, EntidadNoExiste, CompraRechazada {
        ControladorMundial controladorMundial = new ControladorMundial();
        controladorMundial.registrarPartido(LocalDate.parse("2022-06-21"), "EstadioA",
                50000, "Uruguay", "Argentina");
        controladorMundial.registrarPartido(LocalDate.parse("2022-06-21"), "EstadioB",
                60000, "Alemania", "Brasil");
        controladorMundial.registrarPartido(LocalDate.parse("2022-06-21"), "EstadioV",
                70000, "Ruanda", "China");
        controladorMundial.registrarPartido(LocalDate.parse("2022-06-21"), "EstadioX",
                80000, "Italia", "Korea");
        controladorMundial.venderEntrada("40178007", "Uruguay",LocalDate.parse("2022-06-21"),
                "EstadioA");
        assertThrows(CompraRechazada.class, ()->{controladorMundial.venderEntrada("40178007", "Uruguay",LocalDate.parse("2022-06-21"),
                "EstadioX"); });

    }
}