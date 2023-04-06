package TAD.LinkedList;

public interface Lista<T> {
    void add (T value);

    void addAscendente (T value);

    T get (int position);

    void remove (int position);

    boolean exists (T value);

    int size();

    void addFirst(T value);

    void addLast(T value);

    void intercambiar(T value, int direccion) throws Exception;
}

