package TAD.TreeBinarySearch;

import TAD.LinkedList.Lista;
import TAD.LinkedList.ListaEnlazada;
import TAD.Queue.MyQueue;
import TAD.Queue.MyQueueImpl;

import TAD.TreeBinarySearch.NodoBST;

public class MyBinarySearchTreeImpl<K extends Comparable<K>, T> implements MyBinarySearchTree<K, T> {
    K key;
    T data;
    NodoBST<K, T> parent;
    NodoBST<K, T> raiz;
    int size = 0;

    public MyBinarySearchTreeImpl() {
        this.key = null;
        this.data = null;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public NodoBST<K, T> getParent() {
        return parent;
    }

    public void setParent(NodoBST<K, T> parent) {
        this.parent = parent;
    }

    public NodoBST<K, T> getRaiz() {
        return raiz;
    }

    public void setRaiz(NodoBST<K, T> raiz) {
        this.raiz = raiz;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public void insert(K key, T data) {
        NodoBST<K, T> nodo = new NodoBST<>(key, data);
        if (getRaiz() == null) {
            NodoBST<K, T> kayParent = new NodoBST<>(key, data);
            setParent(kayParent);
            setRaiz(kayParent);
            nodo.setLeftChild(null);
            nodo.setRightChild(null);
            size++;
        } else {
            if (getParent().compareTo(nodo) < 0) {
                if (getParent().getRightChild() == null) {
                    getParent().setRightChild(nodo);
                    nodo.setLeftChild(null);
                    nodo.setRightChild(null);
                    setParent(getRaiz());
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
                    setParent(getRaiz());
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

    private NodoBST<K, T> serch(K key) {
        NodoBST<K, T> nodo = new NodoBST<>(key, null);
        NodoBST<K, T> retorno = null;
        if (getParent().compareTo(nodo) < 0) {
            if (getParent().getRightChild() == null) {
                retorno = null;
            }
            if (nodo.compareTo(getParent().getRightChild()) == 0) {
                return getParent().getRightChild();
            } else {
                setParent(getParent().getRightChild());
                retorno = serch(key);
            }
        } else if (getParent().compareTo(nodo) > 0) {
            if (getParent().getLeftChild() == null) {
                retorno = null;
            }
            if (nodo.compareTo(getParent().getLeftChild()) == 0) {
                retorno = getParent().getLeftChild();
            } else {
                setParent(getParent().getLeftChild());
                retorno = serch(key);
            }
        } else {
            retorno = getParent();
        }
        return retorno;
    }

    @Override
    public NodoBST<K, T> find(K key) {
        NodoBST<K, T> retorno = null;
        if (getRaiz() == null) {
            retorno = null;
        } else {
            setParent(getRaiz());
            retorno = serch(key);
        }
        return retorno;
    }

    NodoBST<K,T> deleteNodo(NodoBST<K, T> nodo, K key) {
        NodoBST<K, T> nodoKey = new NodoBST<K,T>(key, null);
        if (nodo == null)
            return nodo;
        int comparacion = nodoKey.compareTo(nodo);
        if (comparacion < 0)
            nodo.setLeftChild(deleteNodo(nodo.getLeftChild(), key));
        else if (comparacion > 0)
            nodo.setRightChild(deleteNodo(nodo.getRightChild(), key));
        else {
            // Nodo encontrado, realizar la eliminación
            if (nodo.getLeftChild() == null)
                return nodo.getRightChild();
            else if (nodo.getRightChild() == null)
                return nodo.getLeftChild();
            // Nodo con dos hijos: obtener el sucesor inmediato (el más pequeño en el subárbol derecho)
            K value = minValue(nodo.getRightChild());
            NodoBST<K, T> sucesor = find(value);
            nodo.setData(sucesor.getData());
            nodo.setKey(sucesor.getKey());
            // Eliminar el sucesor inmediato
            nodo.setRightChild(deleteNodo(nodo.getRightChild(), nodo.getKey()));
        }
        return nodo;
    }

    K minValue(NodoBST<K,T> minNodo) {
        K minv = minNodo.getKey();
        while (minNodo.getLeftChild() != null) {
            minv = minNodo.getLeftChild().getKey();
            minNodo = minNodo.getLeftChild();
        }
        return minv;
    }

    @Override
    public NodoBST<K,T> delete(K key) {
        NodoBST<K, T> nodo;
        nodo = deleteNodo(raiz, key);
        return nodo;
    }

    @Override
    public int size() {
        return getSize();
    }

    private int cuentaHoja(NodoBST<K, T> nodo) {
        if (nodo == null) {
            return 0;
        }
        if (nodo.getLeftChild() == null && nodo.getRightChild() == null) {
            return 1;
        }
        int left = cuentaHoja(nodo.getLeftChild());
        int right = cuentaHoja(nodo.getRightChild());
        return left + right;
    }

    @Override
    public int countLeaf() {
        return cuentaHoja(raiz);
    }

    @Override
    public int countNonLeaf() {
        return 0;
    }

    int cuentaNodoLleno(NodoBST<K, T> nodo) {
        if (nodo == null) {
            return 0;
        }
        int left = cuentaNodoLleno(nodo.getLeftChild());
        int right = cuentaNodoLleno(nodo.getRightChild());
        if (nodo.getLeftChild() != null && nodo.getRightChild() != null) {
            return left + right + 1;
        } else {
            return left + right;
        }
    }

    @Override
    public int countCompleteElements() {
        return cuentaNodoLleno(raiz);
    }

    private Lista<K> inOrden(NodoBST<K, T> nodo, Lista<K> lista) {
        if (nodo != null) {
            inOrden(nodo.getLeftChild(), lista);
            lista.add(nodo.getKey());
            inOrden(nodo.getRightChild(), lista);
        }
        return lista;
    }

    @Override
    public Lista<K> inOrder() {
        Lista<K> lista = new ListaEnlazada();
        return inOrden(raiz, lista);
    }

    private Lista<K> preOrden(NodoBST<K, T> nodo, Lista<K> lista) {
        if (nodo != null) {
            lista.add(nodo.getKey());
            preOrden(nodo.getLeftChild(), lista);
            preOrden(nodo.getRightChild(), lista);
        }
        return lista;
    }

    @Override
    public Lista<K> preOrder() {
        Lista<K> lista = new ListaEnlazada();
        return preOrden(raiz, lista);
    }

    private Lista<K> postOrden(NodoBST<K, T> nodo, Lista<K> lista) {
        if (nodo != null) {
            postOrden(nodo.getLeftChild(), lista);
            postOrden(nodo.getRightChild(), lista);
            lista.add(nodo.getKey());
        }
        return lista;
    }

    @Override
    public Lista<K> postOrder() {
        Lista<K> lista = new ListaEnlazada();
        return postOrden(raiz, lista);
    }

    private Lista<K> porNivel(Lista<K> lista, MyQueue<NodoBST<K, T>> queue) throws MyQueue.EmptyQueueException {
        while (!queue.isEmpty()) {
            NodoBST<K, T> nodo = queue.dequeue().getValue();
            lista.add(nodo.getKey());
            if (nodo.getLeftChild() != null) {
                queue.enqueue(nodo.getLeftChild());
            }
            if (nodo.getRightChild() != null) {
                queue.enqueue(nodo.getRightChild());
            }
        }
        return lista;
    }

    @Override
    public Lista<K> levelOrder() throws MyQueue.EmptyQueueException {
        Lista<K> lista = new ListaEnlazada();
        MyQueue<NodoBST<K, T>> queue = new MyQueueImpl<>();
        queue.enqueue(raiz);
        lista = porNivel(lista, queue);
        return lista;
    }

    @Override
    public boolean isEmpty() {
        return getRaiz() == null;
    }
}
