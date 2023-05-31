package TAD.TreeBinaryCompleto;

import TAD.Tree.NodoTree;

public class MyTreeBinaryCompletoImpl<K, T> implements MyTreeBinaryCompleto<K, T> {
    private NodoTree[] treeArray;
    private K key;
    private T data;
    private NodoTree<K, T> parent;
    private NodoTree<K, T> raiz;
    private int size = 0;
    private int ultimoIndice = 0;

    public MyTreeBinaryCompletoImpl() {
        int capacidad = 5;
        int cantidadNodos = (int) Math.pow(2, capacidad);
        int aux = cantidadNodos;
        while (aux > 1) {
            aux = aux / 2;
            cantidadNodos = cantidadNodos + aux;
        }
        treeArray = new NodoTree[cantidadNodos];
    }

    public MyTreeBinaryCompletoImpl(int capacidad) throws Exception {
        if (capacidad < 0) {
            throw new Exception("El calor debe de ser mayor o igual a 0");
        }
        int cantidadNodos = (int) Math.pow(2, capacidad);
        int aux = cantidadNodos;
        while (aux > 1) {
            aux = aux / 2;
            cantidadNodos = cantidadNodos + aux;
        }
        treeArray = new NodoTree[cantidadNodos];
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
        if (getRaiz() == null) {
            NodoTree<K, T> nodo = new NodoTree<K, T>(key, data);
            setParent(nodo);
            setRaiz(nodo);
            ultimoIndice = 0;
            treeArray[ultimoIndice] = nodo;
            size++;
        } else if (getParent().getLeftChild() == null || getParent().getRightChild() == null) {
            if (treeArray[2 * ultimoIndice + 1] == null) {
                NodoTree<K, T> padre = treeArray[ultimoIndice];
                NodoTree<K, T> nodo = new NodoTree<K, T>(key, data);
                padre.setLeftChild(nodo);
                treeArray[(2 * ultimoIndice) + 1] = nodo;
                size++;
            } else if (treeArray[(2 * ultimoIndice) + 2] == null) {
                NodoTree<K, T> padre = treeArray[ultimoIndice];
                NodoTree<K, T> nodo = new NodoTree<K, T>(key, data);
                padre.setRightChild(nodo);
                treeArray[(2 * ultimoIndice) + 2] = nodo;
                ultimoIndice++;
                NodoTree<K, T> nuevoPariente = treeArray[ultimoIndice];
                setParent(nuevoPariente);
                size++;
            }
        }
    }

    private NodoTree<K, T> deleteNodo(int indice, K key) {
        NodoTree<K, T> nodoRetorno;
        if (treeArray[indice].getKey().equals(key)) {
            nodoRetorno = treeArray[indice];
            if (indice != 0) {
                if (indice % 2 == 0) {
                    int index = (indice - 2) / 2;
                    NodoTree<K, T> padre = treeArray[index];
                    if (treeArray[indice+1] == null) {
                        padre.setRightChild(null);
                    } else if (treeArray[indice + 2] != null) {
                        padre.setLeftChild(treeArray[indice + 1]);
                        padre.setRightChild(treeArray[indice + 2]);
                    }
                } else {
                    int index = (indice - 1) / 2;
                    NodoTree<K, T> padre = treeArray[index];
                    if (treeArray[indice+1] == null) {
                        padre.setLeftChild(null);
                    } else if (treeArray[indice + 2] != null) {
                        padre.setLeftChild(treeArray[indice + 1]);
                        padre.setRightChild(treeArray[indice + 2]);
                    }
                }
                int index = indice;
                while (treeArray[indice] != null) {
                    treeArray[indice] = treeArray[indice + 1];
                    indice++;
                }
                while (treeArray[index] != null) {
                    NodoTree<K, T> nodo = treeArray[index];
                    nodo.setLeftChild(treeArray[(2 * index) + 1]);
                    nodo.setRightChild(treeArray[(2 * index) + 2]);
                    index++;
                }
                size--;
            } else {
                setRaiz(treeArray[indice+1]);
                int index = indice + 1;
                while (treeArray[index] != null) {
                    NodoTree<K, T> nodo = treeArray[index];
                    nodo.setLeftChild(treeArray[2 * index]);
                    nodo.setRightChild(treeArray[(2 * index) + 1]);
                    index++;
                }
                while (treeArray[indice] != null) {
                    treeArray[indice] = treeArray[indice + 1];
                    indice++;
                }
                size--;
            }
        } else {
            indice++;
            nodoRetorno = deleteNodo(indice, key);
        }
        return nodoRetorno;
    }

    @Override
    public NodoTree<K, T> delete(K key) {
        NodoTree<K, T> nodo;
        int indice = 0;
        nodo = deleteNodo(indice, key);
        return nodo;
    }

    @Override
    public int size() {
        return getSize();
    }


}
