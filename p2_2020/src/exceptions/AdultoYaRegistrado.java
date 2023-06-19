package exceptions;

public class AdultoYaRegistrado extends Exception{
    public AdultoYaRegistrado() {
        super("El adulto ya registrado");
    }
}