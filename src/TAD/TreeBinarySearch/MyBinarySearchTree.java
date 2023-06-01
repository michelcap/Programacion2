package TAD.TreeBinarySearch;

import TAD.LinkedList.Lista;
import TAD.Queue.MyQueue;

public interface MyBinarySearchTree<K extends Comparable<K>, T>  {
    void insert(K key, T data);

    NodoBST<K,T> find(K key);

    NodoBST<K,T> getRaiz();

    NodoBST<K,T> delete(K key);

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
