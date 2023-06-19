package entities;

import uy.edu.um.adt.linkedlist.MyLinkedListImpl;
import uy.edu.um.adt.linkedlist.MyList;

public class Menor extends Usuario{
    MyList<RestringirAcceso> listaRestricciones;

    public Menor(String mailMenor, String nombreMenor) {
        super(mailMenor, nombreMenor);
        listaRestricciones = new MyLinkedListImpl<>();
    }

    public Menor(String mailMenor) {
        super(mailMenor);
    }

    public void addRestriccion(Aplicaciones app, long tiempoPermitido) {
        RestringirAcceso restriccion = new RestringirAcceso(app, tiempoPermitido);
        listaRestricciones.remove(restriccion);
        listaRestricciones.add(restriccion);
    }

    @Override
    public boolean AperturaApp(Aplicaciones app) {
        boolean retorno = false;
        for (int i = 0; i < listaRestricciones.size(); i++) {
            RestringirAcceso acceso = listaRestricciones.get(i);
            if(acceso.equals(app)) {
                if (acceso.getTiempoPermitidoDiario() == 0) {
                    break;
                } else if (acceso.getTiempoPermitidoDiario() > super.calcularTiempo(app)) {
                    retorno = super.AperturaApp(app);
                }
            }
        }
        return retorno;
    }
}
