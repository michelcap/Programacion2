import TAD.LinkedList.*;

public class ProbleaDeJosefo {
    private int cantidadPersonas = 0;
    private int saltos = 0;

    public ProbleaDeJosefo(int cantidadPersonas, int saltos){
        this.cantidadPersonas = cantidadPersonas;
        this.saltos = saltos;
    }

    // Getter cantidadPersonas
    public int getCantidadPersonas() {
      return cantidadPersonas;
    }

    // Setter cantidadPersonas
    public void setCantidadPersonas(int new_CantidadPersonas) {
      this.cantidadPersonas = new_CantidadPersonas;
    }

    // Getter saltos
    public int getSaltos() {
      return saltos;
    }

    // Setter saltos
    public void setSaltos(int new_Saltos) {
      this.saltos = new_Saltos;
    }

    ListaCircular<Integer> nuevoJuego = new ListaCircularSimple<>();

    public Integer Ganador () {
        for (int persona = 1; persona <= getCantidadPersonas(); persona++) {
            nuevoJuego.add(persona);
        }
        int index = 0;
        int size = nuevoJuego.size();
        while (size != 1) {
            index = (index + getSaltos()) % size;
            System.out.println("Abandona persona #" + nuevoJuego.get(index));
            nuevoJuego.remove(index);
            index++;
            size--;
        }
        return nuevoJuego.get(index+1);
    }


}
