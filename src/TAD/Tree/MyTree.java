package TAD.Tree;

import TAD.LinkedList.Lista;

public interface MyTree<K, T> {

    void insert(K key, T data);

    NodoTree<K,T> find(K key);

    NodoTree<K,T> getRaiz();

    void delete(K key);

    int size();

    int countLeaf();

    int countNonLeaf();

    Lista<K> inOrder();

    Lista<K> preOrder();

    Lista<K> postOrder();

    boolean isEmpty();
}
