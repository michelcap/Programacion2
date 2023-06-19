package entities;

import org.junit.jupiter.api.Assertions;

class ControlParentalServiceTest {

    ControlParentalService controlador = new ControlParentalImpl();

    @org.junit.jupiter.api.Test
    void registrarUsuario() throws Exception {
        controlador.registrarUsuario("mail1", "N1", false, null);
        controlador.registrarUsuario("mail2", "N2", true, "mail1");
        Assertions.assertThrows(Exception.class, () -> {controlador.registrarUsuario("mail1", "N3", false, null);});
        Assertions.assertThrows(Exception.class, () -> {controlador.registrarUsuario("mail3", "N3", true, null);});
        Assertions.assertThrows(Exception.class, () -> {controlador.registrarUsuario("", "N3", false, null);});
    }

    @org.junit.jupiter.api.Test
    void restringirAcceso() throws Exception {
        controlador.registrarUsuario("mail1", "N1", false, null);
        controlador.registrarUsuario("mail     3", "N1", false, null);
        controlador.registrarUsuario("mail2", "N2", true, "mail1");
        controlador.registrarUsuario("mail4", "N2", true, "mail3");

        controlador.restringirAcceso("mail1", "mail2", 100, "APP1");

        Assertions.assertThrows(Exception.class, () -> {controlador.restringirAcceso("mail3", "mail2", 100, "APP1");});
        Assertions.assertThrows(Exception.class, () -> {controlador.restringirAcceso("mail2", "mail1", 100, "APP1");});
        Assertions.assertThrows(Exception.class, () -> {controlador.restringirAcceso("mail1", "mail2", -1, "APP1");});
    }

    @org.junit.jupiter.api.Test
    void notificacionAperturaAplicacion() {
    }

    @org.junit.jupiter.api.Test
    void notificacionCierreAplicacion() {
    }

    @org.junit.jupiter.api.Test
    void obtenerRankingAplicaciones() {
    }

    @org.junit.jupiter.api.Test
    void obtenerRankingTop5Usuarios() {
    }
}