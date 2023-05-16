package TAD.Tree;

import TAD.LinkedList.Lista;
import TAD.LinkedList.ListaEnlazada;

public class MyTreeImpl<K, T> implements MyTree<K, T> {
    K key;
    T data;
    NodoTree<K, T> parent;
    NodoTree<K, T> raiz;
    int size = 0;

    public MyTreeImpl() {
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

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public void insert(K key, T data) {
        NodoTree<K, T> nodo = new NodoTree<>(key, data);
        if (getRaiz() == null) {
            NodoTree<K, T> kayParent = new NodoTree<>(key, data);
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

    private NodoTree<K, T> serch(K key) {
        NodoTree<K, T> nodo = new NodoTree<>(key, null);
        NodoTree<K, T> retorno = null;
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
    public NodoTree<K, T> find(K key) {
        NodoTree<K,T> retorno = null;
        if (getRaiz() == null) {
            retorno = null;
        } else {
            setParent(getRaiz());
            retorno = serch(key);
        }
        return retorno;
    }

    @Override
    public void delete(K key) {

    }

    @Override
    public int size() {
        return getSize();
    }

    private int cuentaHoja(NodoTree<K, T> nodo) {
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

    int cuentaNodoLleno(NodoTree<K, T> nodo) {
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

    private Lista<T> inOrden(NodoTree<K, T> nodo, Lista<T> lista) {
        if (nodo!= null) {
            inOrden(nodo.getLeftChild(),lista);
            lista.add(nodo.getData());
            inOrden(nodo.getRightChild(), lista);
        }
        return lista;
    }
    @Override
    public Lista<T> inOrder() {
        Lista<T> lista = new ListaEnlazada();
        return inOrden(raiz, lista);
    }

    private Lista<T> preOrden(NodoTree<K, T> nodo, Lista<T> lista) {
        if (nodo!= null) {
            lista.add(nodo.getData());
            preOrden(nodo.getLeftChild(),lista);
            preOrden(nodo.getRightChild(), lista);
        }
        return lista;
    }
    @Override
    public Lista<T> preOrder() {
        Lista<T> lista = new ListaEnlazada();
        return preOrden(raiz, lista);
    }

    private Lista<T> postOrden(NodoTree<K, T> nodo, Lista<T> lista) {
        if (nodo!= null) {
            postOrden(nodo.getLeftChild(),lista);
            postOrden(nodo.getRightChild(), lista);
            lista.add(nodo.getData());
        }
        return lista;
    }
    @Override
    public Lista<T> postOrder() {
        Lista<T> lista = new ListaEnlazada();
        return postOrden(raiz, lista);
    }

    @Override
    public boolean isEmpty() {
        return getRaiz() == null;
    }


}
