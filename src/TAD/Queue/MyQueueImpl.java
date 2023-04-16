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

    public NodoQueue<T> head() {
        return head;
    }

    public void setHead(NodoQueue<T> head) {
        this.head = head;
    }

    public NodoQueue<T> tail() {
        return tail;
    }

    public void setTail(NodoQueue<T> tail) {
        this.tail = tail;
    }

    public int size() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public void enqueue(T element) {
        if (isEmpty()) {
            NodoQueue<T> nuevoNodo = new NodoQueue<>(0, element);
            setHead(nuevoNodo);
            setTail(nuevoNodo);
            setSize(size() + 1);
        } else {
            NodoQueue<T> nuevoNodo = new NodoQueue<>(0, element);
            tail().setPrevious(nuevoNodo);
            nuevoNodo.setNext(tail());
            setTail(nuevoNodo);
            setSize(size() + 1);
        }
    }

    @Override
    public NodoQueue<T> dequeue() throws EmptyQueueException {
        if (isEmpty()) {
            throw new EmptyQueueException("Queue is empty");
        } else {
            NodoQueue<T> nodo = head();
            setHead(nodo.getPrevious());
            nodo.getPrevious().setNext(null);
            nodo.setPrevious(null);
            setSize(size() - 1);
            return nodo;
        }
    }

    @Override
    public boolean isEmpty() {
        return head() == null;
    }

}
