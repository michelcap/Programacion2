package TAD.Tree;

import TAD.LinkedList.Lista;
import TAD.LinkedList.Nodo;

public class MyTreeImpl<K, T> implements MyTree<K, T> {
    K key;
    T data;
    NodoTree<K, T> parent;
    NodoTree<K, T> raiz;
    int size = 0;

    MyTreeImpl() {
        this.key = null;
        this.data = null;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public NodoTree<K, T> getParent() {
        return parent;
    }

    public void setParent(NodoTree<K, T> parent) {
        this.parent = parent;
    }

    public NodoTree<K, T> getRaiz() {
        return raiz;
    }

    public void setRaiz(NodoTree<K, T> raiz) {
        this.raiz = raiz;
    }

    @Override
    public void insert(K key, T data) {
        NodoTree<K, T> nodo = new NodoTree<>(key, data);
        if (getRaiz() == null) {
            NodoTree<K, T> kayParent = new NodoTree<>(key, data);
            setParent(kayParent);
            nodo.setLeftChild(null);
            nodo.setRightChild(null);
            size++;
        } else {
            if (getParent().compareTo(nodo) < 0) {
                if (getParent().getRightChild() == null) {
                    getParent().setRightChild(nodo);
                    nodo.setLeftChild(null);
                    nodo.setRightChild(null);
                    size++;
                } else if (nodo.compareTo(getParent().getRightChild()) == 0) {
                    getParent().getRightChild().setCount();
                } else {
                    setParent(getParent().getRightChild());
                    insert(key, data);
                }
            } else if (getParent().compareTo(nodo) > 0) {
                if (getParent().getLeftChild() == null) {
                    getParent().setLeftChild(nodo);
                    nodo.setLeftChild(null);
                    nodo.setRightChild(null);
                    size++;
                } else if (nodo.compareTo(getParent().getLeftChild()) == 0) {
                    getParent().getLeftChild().setCount();
                } else {
                    setParent(getParent().getLeftChild());
                    insert(key, data);
                }
            } else {
                getParent().setCount();
            }
        }
    }

    @Override
    public NodoTree<K, T> find(K key) {
        return null;
    }

    @Override
    public void delete(K key) {

    }

    @Override
    public int size() {
        return getSize();
    }

    @Override
    public int countLeaf() {
        return 0;
    }

    @Override
    public int countNonLeaf() {
        return 0;
    }

    @Override
    public Lista<K> inOrder() {
        return null;
    }

    @Override
    public Lista<K> preOrder() {
        return null;
    }

    @Override
    public Lista<K> postOrder() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return getRaiz() == null;
    }


}
