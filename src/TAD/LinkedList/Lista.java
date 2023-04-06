package TAD.LinkedList;

public interface Lista<T> {
    void add (T value);

    void addAscendente (T value);

    Nodo<T> get (int position);

    void remove (int position);

    boolean exists (T value);

    int size();

    void addFirst(T value);

    void addLast(T value);

    void intercambiar(T value, int direccion) throws Exception;

    Nodo<T> getFirst();

    Nodo<T> getLast();

    void setFirst(Nodo<T> value);

    void setLast(Nodo<T> value);

    void append(Lista<T> lista);

}

