package TAD.Queue;

public class MyQueueImpl<T> implements MyQueue<T> {
    private NodoQueue<T> head;
    private NodoQueue<T> tail;
    private int size;

    public MyQueueImpl() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public NodoQueue<T> getHead() {
        return head;
    }

    public void setHead(NodoQueue<T> head) {
        this.head = head;
    }

    public NodoQueue<T> getTail() {
        return tail;
    }

    public void setTail(NodoQueue<T> tail) {
        this.tail = tail;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public void enqueue(T element) {
        if (isEmpty()) {
            NodoQueue<T> nuevoNodo = new NodoQueue<>(element);
            setHead(nuevoNodo);
            setTail(nuevoNodo);
        } else {
            NodoQueue<T> nuevoNodo = new NodoQueue<>(element);
            getTail().setPrevious(nuevoNodo);
            nuevoNodo.setNext(getTail());
            setTail(nuevoNodo);
        }
    }

    @Override
    public NodoQueue<T> dequeue() throws EmptyQueueException {
        if (isEmpty()) {
            throw new EmptyQueueException("Queue is empty");
        } else {
            NodoQueue<T> nodo = getHead();
            setHead(nodo.getPrevious());
            nodo.getPrevious().setNext(null);
            nodo.setPrevious(null);
            setSize(getSize() - 1);
            return nodo;
        }
    }

    @Override
    public boolean isEmpty() {
        return getHead() == null;
    }
}
