package TAD.Heap;

import TAD.Tree.NodoTree;

public interface MyHeap<K,T> {
    void insert(K key, T data) throws Exception;

    NodoTree<K,T> delete();

    int size();

    String toString();
}
