package TAD.LinkedList;

public class Nodo<T> {
    private T value;
    private Nodo<T> previous;
    private Nodo<T> next;

    public Nodo(T value) {
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
    public Nodo<T> getPrevious() {
        return (Nodo<T>) previous;
    }

    // Setter previous
    public void setPrevious(Nodo<T> new_Previous) {
        this.previous = new_Previous;
    }

    // Getter next
    public Nodo<T> getNext() {
        return (Nodo<T>) next;
    }

    // Setter next
    public void setNext(Nodo<T> new_Next) {
        this.next = new_Next;
    }
}