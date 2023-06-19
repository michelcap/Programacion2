package entities;

import uy.edu.um.adt.linkedlist.MyLinkedListImpl;
import uy.edu.um.adt.linkedlist.MyList;

public class Adulto extends Usuario {
    MyList<Menor> menoresACargo;

    public Adulto(String mailAdulto, String nombreAdulto) {
        super(mailAdulto, nombreAdulto);
        menoresACargo = new MyLinkedListImpl<>();
    }

    public Adulto(String mailAdulto) {
        super(mailAdulto);
    }

    public void addMenor(Menor menor) {
        this.menoresACargo.add(menor);
    }

    public boolean contains(Menor menor) {
        return this.menoresACargo.contains(menor);
    }
}
