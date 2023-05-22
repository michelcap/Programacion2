package TAD.Tree;

import TAD.LinkedList.Lista;
import TAD.Queue.MyQueue;

public interface MyTree<K, T> {

    void insert(K key, T data);

    NodoTree<K,T> find(K key);

    NodoTree<K,T> getRaiz();

    NodoTree<K,T> delete(K key);

    int size();

    int countLeaf();

    int countNonLeaf();

    int countCompleteElements();

    Lista<K> inOrder();

    Lista<K> preOrder();

    Lista<K> postOrder();

    Lista<K> levelOrder() throws MyQueue.EmptyQueueException;

    boolean isEmpty();
}
