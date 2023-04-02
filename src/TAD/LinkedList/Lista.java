package TAD.LinkedList;

public interface Lista<T> {
    void add (T value);

    T get (int position);

    void remove (int position);

    boolean exists (T value);

    int size();

    void addFirst(T value);

    void addLast(T value);
}

