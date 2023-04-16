package TAD.Queue;

public class MyPriorityQueueImpl<T> implements MyPriorityQueue<T> {
    private NodoQueue<T> head;
    private NodoQueue<T> tail;
    private NodoQueue<T> tailMenus = new NodoQueue<T>(-1, null);
    private int size;

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
    public void enqueue(int priority, T element) {
        NodoQueue<T> nodo = new NodoQueue<>(priority, element);
        if (isEmpty()) {
            setHead(nodo);
            setTail(nodo);
            tailMenus.setNext(tail());
            tail().setPrevious(tailMenus);
            size++;
        } else if (nodo.compareTo(head()) > 0) {
            head().setNext(nodo);
            nodo.setPrevious(head());
            setHead(nodo);
            size++;
        } else if (nodo.compareTo(head()) < 0 && head().equals(tail())) {
            setTail(nodo);
            tail().setNext(head());
            head().setPrevious(tail());
            size++;
        } else if (nodo.compareTo(head()) == 0 && size() == 1) {
            setTail(nodo);
            tail().setNext(nodo);
            head().setPrevious(tail());
            size++;
        } else if (nodo.compareTo(head()) > 0) {
            nodo.setPrevious(head());
            head().setNext(nodo);
            setHead(nodo);
            size++;
        } else {
            NodoQueue<T> currentHead = head();
            NodoQueue<T> currentHeadPrevius = currentHead.getPrevious();
            while (currentHeadPrevius.getNext()!= null) {
                if (currentHeadPrevius.compareTo(nodo) < 0 && nodo.compareTo(currentHead) < 0) {
                    nodo.setPrevious(currentHeadPrevius);
                    nodo.setNext(currentHead);
                    currentHead.setPrevious(nodo);
                    currentHeadPrevius.setNext(nodo);
                    if (currentHead.compareTo(tail()) == 0) {
                        tail().setPrevious(nodo);
                        nodo.setNext(tail());
                        setTail(nodo);
                    }
                    size++;
                    break;
                } else if (nodo.compareTo(currentHeadPrevius) == 0) {
                    nodo.setPrevious(currentHeadPrevius.getPrevious());
                    nodo.setNext(currentHeadPrevius);
                    currentHeadPrevius.getPrevious().setNext(nodo);
                    currentHeadPrevius.setPrevious(nodo);
                    size++;
                    break;
                } else {
                    currentHead = currentHeadPrevius;
                    currentHeadPrevius = currentHead.getPrevious();
                }
            }
        }
    }

    @Override
    public NodoQueue<T> dequeue() throws MyQueue.EmptyQueueException {
        if (isEmpty()) {
            throw new MyQueue.EmptyQueueException("Queue is empty");
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

    public NodoQueue<T> get(int position) {
        NodoQueue<T> retorno = null;
        NodoQueue<T> retornoNodo = head();
        if (retornoNodo != null) {
            int contador = size();
            while (retornoNodo != null) {
                if (contador == position) {
                    retorno = retornoNodo;
                    break;
                } else {
                    retornoNodo = retornoNodo.getPrevious();
                    contador--;
                }
            }
        }
        return retorno;
    }
}
