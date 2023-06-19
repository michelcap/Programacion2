package TADs.adt.linkedlist;

public interface MyList<T> extends Iterable<T> {

    void add(T value);

    T get(int position);

    T get(T valor);

    boolean contains(T value);

    void remove(T value);

    int size();

}
