package TAD.TreeBinaryCompleto;

import TAD.Tree.NodoTree;

public interface MyTreeBinaryCompleto<K,T> {
    void insert(K key, T data);

    NodoTree<K,T> delete(K key);

    int size();
}
