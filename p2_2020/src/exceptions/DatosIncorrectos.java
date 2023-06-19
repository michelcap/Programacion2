package exceptions;

public class DatosIncorrectos extends Exception{
    public DatosIncorrectos() {
        super("Los datos ingresados tienen errores");
    }
}
