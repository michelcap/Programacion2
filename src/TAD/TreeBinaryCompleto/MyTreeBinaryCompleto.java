package TAD.TreeBinaryCompleto;

import TAD.Tree.NodoTree;

public interface MyTreeBinaryCompleto<K extends Comparable<K>,T> {
    void insert(K key, T data) throws Exception;

    NodoTree<K,T> delete(K key);

    int size();

    String toString();
}
