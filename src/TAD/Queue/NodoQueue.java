package TAD.Queue;

public class NodoQueue<T> implements Comparable<NodoQueue<T>> {
    private Integer key;
    private T value;
    private NodoQueue<T> previous;
    private NodoQueue<T> next;
    private NodoQueue<T> head;
    private NodoQueue<T> tail;

    public NodoQueue(int key, T value) {
        this.key = key;
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

    public int getKey() {
        return key;
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

    @Override
    public int compareTo(NodoQueue<T> o) {

        return this.key.compareTo(o.getKey());
    }

    public boolean equals(NodoQueue<T> o) {
        return this.key.equals(o.getKey()) && this.value.equals(o.getValue());
    }

    public T sumar(T num2) {
        if (num2 == null) {
            if (getValue() instanceof Integer) {
                return (T) Integer.valueOf(((Integer) getValue()).intValue() + 1);
            } else if (getValue() instanceof Double) {
                return (T) Double.valueOf(((Double) getValue()).doubleValue() + 1);
            } else {
                throw new IllegalArgumentException("Los números deben ser del mismo tipo (entero o doble)");
            }
        }
        if (num2 instanceof Integer) {
            return (T) Integer.valueOf(((Integer) getValue()).intValue() + ((Integer) num2).intValue());
        } else if (num2 instanceof Double) {
            return (T) Double.valueOf(((Double) getValue()).doubleValue() + ((Double) num2).doubleValue());
        } else {
            throw new IllegalArgumentException("Los números deben ser del mismo tipo (entero o doble)");
        }
    }

    public T restar(T num2) {
        if (num2 == null) {
            if (getValue() instanceof Integer) {
                return (T) Integer.valueOf(((Integer) getValue()).intValue() - 1);
            } else if (getValue() instanceof Double) {
                return (T) Double.valueOf(((Double) getValue()).doubleValue() - 1);
            } else {
                throw new IllegalArgumentException("Los números deben ser del mismo tipo (entero o doble)");
            }
        }
        if (num2 instanceof Integer) {
            return (T) Integer.valueOf(((Integer) getValue()).intValue() - ((Integer) num2).intValue());
        } else if (num2 instanceof Double) {
            return (T) Double.valueOf(((Double) getValue()).doubleValue() - ((Double) num2).doubleValue());
        } else {
            throw new IllegalArgumentException("Los números deben ser del mismo tipo (entero o doble)");
        }
    }
}