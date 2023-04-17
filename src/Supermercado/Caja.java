package Supermercado;

import TAD.Queue.MyPriorityQueue;
import TAD.Queue.MyPriorityQueueImpl;
import TAD.Queue.MyQueue;

public class Caja<T extends Number> {
    private MyPriorityQueue<T> cola;

    public Caja() {
        cola = new MyPriorityQueueImpl<>();
    }

    public MyPriorityQueue<T> getCola() {
        return cola;
    }

    public int getDemora() {
        int cantProductosEnCola = 0;
        for (int i = cola.size(); i >= 1; i--) {
            cantProductosEnCola += (int) getCola().get(i).getValue();
        }
        return cantProductosEnCola;
    }

    public int getCantClientes() {
        return cola.size();
    }

    public void addCliente(int prioridad, T productos) {
        cola.enqueue(prioridad, productos);
    }

    public void removeProducto() throws MyQueue.EmptyQueueException {
        if (cola.isEmpty()) {
            throw new MyQueue.EmptyQueueException("Cola Vacia");
        } else {
            if ((int) cola.head().getValue() > 0) {
                T value = cola.head().restar(null);
                cola.head().setValue(value);
            } else {
                cola.dequeue();
            }
        }
    }
}
