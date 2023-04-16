package TAD.Tree;

import TAD.LinkedList.Lista;

public interface MyTree<K, T> {

    NodoTree<K,T> find(K key);

    void insert(K key, T data);

    void delete(K key);

    int size();

    int countLeaf();

    int countNonLeaf();

    Lista<K> inOrder();

    Lista<K> preOrder();

    Lista<K> postOrder();

    boolean isEmpty();
}
