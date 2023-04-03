import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Inresar Cantidad de Personas: ");
        String cantidadPersonas = scanner.nextLine();
        int numeroPersonas = Integer.parseInt(cantidadPersonas);
        System.out.print("Inresar Saltos de Lugares: ");
        String cantidadSatos = scanner.nextLine();
        int numeroSaltos = Integer.parseInt(cantidadSatos);
        ProbleaDeJosefo juegoInteger = new ProbleaDeJosefo(numeroPersonas, numeroSaltos);
        int ganador = juegoInteger.Ganador();
        System.out.println("GANADOR! #" + ganador);
    }
}