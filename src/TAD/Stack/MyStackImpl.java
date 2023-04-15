package TAD.Stack;

import TAD.LinkedList.Nodo;

import java.util.EmptyStackException;

public class MyStackImpl<T> implements MyStack<T> {
    private T element;
    private Nodo<T> head;

    // Getter head
    public Nodo<T> getHead() {
      return head;
    }

    // Setter head
    public void setHead(Nodo<T> new_Head) {
      this.head = new_Head;
    }

    @Override
    public void push(T element) {
        if (getHead() == null) {
            Nodo<T> nuevo = new Nodo<>(element);
            setHead(nuevo);
            nuevo.setNext(null);
            nuevo.setPrevious(null);
        } else {
            Nodo<T> nuevo = new Nodo<>(element);
            Nodo<T> aux = getHead();
            aux.setNext(nuevo);
            nuevo.setPrevious(aux);
            setHead(nuevo);
        }
    }

    @Override
    public Nodo<T> pop() throws EmptyStackException {
        Nodo<T> retorno;
        if (getHead() == null) {
            throw new EmptyStackException();
        } else {
            Nodo<T> aux = getHead();
            if (aux.getPrevious() != null) {
                Nodo<T> newHead = aux.getPrevious();
                retorno = aux;
                setHead(newHead);
                aux.setPrevious(null);
                newHead.setNext(null);
            } else {
                retorno = aux;
                aux.setNext(null);
                aux.setPrevious(null);
                setHead(null);
            }
        }
        return retorno;
    }

    @Override
    public Nodo<T> top() throws EmptyStackException {
        Nodo<T> element = getHead();
        return element;
    }

    @Override
    public boolean isEmpty() {
        return getHead() == null;
    }

    @Override
    public void makeEmpty() {
        if (getHead() == null) {
            throw new EmptyStackException();
        } else {
            Nodo<T> aux = getHead();
            Nodo<T> previus = aux.getPrevious();
            while (previus != null) {
                 aux = previus;
                 previus = aux.getPrevious();
                 aux.setNext(null);
                 aux.setPrevious(null);
            }
            getHead().setNext(null);
            getHead().setPrevious(null);
            setHead(null);
        }
    }
}
