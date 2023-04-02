package TAD.LinkedList;

public interface ListaDoble<T> {
    void addAscendente (T value);

    T get (int position);

    void remove (int position);

    boolean exists (T value);

    int size();
}