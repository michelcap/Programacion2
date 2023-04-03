package TAD.LinkedList;

public interface ListaCircular<T> {
    void add (T value);

    T get (int position);

    T remove (int position);

    boolean exists (T value);

    int size();

    void addFirst(T value);

    void addLast(T value);
}
