package exceptions;

public class AdultoNoRegistrado extends Exception{
    public AdultoNoRegistrado() {
        super("El adulto no a sido registrado");
    }
}