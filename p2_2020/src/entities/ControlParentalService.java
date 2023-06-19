package entities;

public interface ControlParentalService {

    void registrarUsuario(String mail, String nombre, boolean esMenor, String mailAdulto) throws Exception;

    void restringirAcceso(String mailAdulto, String mailMenor, long tiempoPermitido, String aplicacion) throws Exception;

    boolean notificacionAperturaAplicacion(String mail, String aplicacion) throws Exception;

    boolean notificacionCierreAplicacion(String mail, String aplicacion) throws Exception;

    void obtenerRankingAplicaciones(String mail);

    void obtenerRankingTop5Usuarios();
}
