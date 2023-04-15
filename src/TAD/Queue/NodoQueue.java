package TAD.Queue;

public class NodoQueue<T> {
    private T value;
    private NodoQueue<T> previous;
    private NodoQueue<T> next;
    private NodoQueue<T> head;
    private NodoQueue<T> tail;

    public NodoQueue(T value) {
        this.value = value;
    }

    // Getter value
    public T getValue() {
        return value;
    }

    // Setter value
    public void setValue(T new_Value) {
        this.value = new_Value;
    }

    // Getter previous
    public NodoQueue<T> getPrevious() {
        return previous;
    }

    // Setter previous
    public void setPrevious(NodoQueue<T> new_Previous) {
        this.previous = new_Previous;
    }

    // Getter next
    public NodoQueue<T> getNext() {
        return next;
    }
    // Setter next
    public void setNext(NodoQueue<T> new_Next) {
        this.next = new_Next;
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
}