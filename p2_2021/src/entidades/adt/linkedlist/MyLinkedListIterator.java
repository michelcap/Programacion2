package entidades.adt.linkedlist;

import java.util.Iterator;

public class MyLinkedListIterator<T> implements Iterator<T> {

    private Node<T> nodo;

    public MyLinkedListIterator(Node<T> nodo) {
        this.nodo = nodo;
    }


    @Override
    public boolean hasNext() {
        return (nodo != null);
    }

    @Override
    public T next() {
        T valueToReturn = nodo.getValue();
        nodo = nodo.getNext();
        return valueToReturn;
    }
}
