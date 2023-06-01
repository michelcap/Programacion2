package TAD.Heap;

import TAD.Tree.NodoTree;

import java.util.Arrays;
import java.util.Objects;

public class MyHeapImpl<K, T> implements MyHeap<K, T> {
    private NodoTree[] treeArray;
    private K key;
    private T data;
    private NodoTree<K, T> parent;
    private NodoTree<K, T> raiz;
    private int size = 0;
    private int cantidadNodos = 0;
    private String maxMin;

    public MyHeapImpl(String tipoHeap) {
        maxMin = tipoHeap;
        int capacidad = 5;
        cantidadNodos = (int) Math.pow(2, capacidad);
        int aux = cantidadNodos;
        while (aux > 1) {
            aux = aux / 2;
            cantidadNodos = cantidadNodos + aux;
        }
        treeArray = new NodoTree[cantidadNodos];
    }

    public MyHeapImpl(String maxMin, int capacidad) throws Exception {
        maxMin = maxMin;
        if (capacidad < 0) {
            throw new Exception("Capacidad debe de ser mayor o igual a 0");
        }
        cantidadNodos = (int) Math.pow(2, capacidad);
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

    public int getCantidadNodos() {
        return cantidadNodos;
    }

    public void insert(K key, T data) throws Exception {
        if (maxMin.equals("maximo") || maxMin.equals("minimo")) {
            if (getSize() >= treeArray.length) {
                expandirCapacidad();
            }

            treeArray[getSize()] = new NodoTree<>(key, data);

            heapUp(getSize());
            buildTree();
            setRaiz(treeArray[0]);
            size++;
        } else {
            throw new Exception("No se definio si quiere un HEAP Maximo o Minimo");
        }
    }

    public NodoTree<K, T> delete() {
        if (size <= 0) {
            throw new IllegalStateException("Monticulo Vacio");
        }
        NodoTree<K, T> nodo = treeArray[0];
        treeArray[0] = treeArray[size - 1];
        treeArray[size - 1] = null;
        size--;
        heapDown(0);
        buildTree();
        setRaiz(treeArray[0]);
        return nodo;
    }

    public int size() {
        return getSize();
    }

    public boolean isEmpty() {
        return getSize() == 0;
    }

    private void heapUp(int index) {
        int parentIndex = (index - 1) / 2;
        if (maxMin.equals("maximo")) {
            if (parentIndex >= 0 && (treeArray[index].compareTo(treeArray[parentIndex])) > 0) {
                swap(index, parentIndex);
                heapUp(parentIndex);
            }
        } else if (maxMin.equals("minimo")) {
            if (parentIndex >= 0 && (treeArray[index].compareTo(treeArray[parentIndex])) < 0) {
                swap(index, parentIndex);
                heapUp(parentIndex);
            }
        }
    }

    private void heapDown(int index) {
        int leftChildIndex = 2 * index + 1;
        int rightChildIndex = 2 * index + 2;
        int largestIndex = index;

        if (maxMin.equals("maximo")) {
            if (leftChildIndex < size && treeArray[leftChildIndex].compareTo(treeArray[largestIndex]) > 0) {
                largestIndex = leftChildIndex;
            }

            if (rightChildIndex < size && treeArray[rightChildIndex].compareTo(treeArray[largestIndex]) > 0) {
                largestIndex = rightChildIndex;
            }
        } else if (maxMin.equals("minimo")) {
            if (leftChildIndex < size && treeArray[leftChildIndex].compareTo(treeArray[largestIndex]) < 0) {
                largestIndex = leftChildIndex;
            }

            if (rightChildIndex < size && treeArray[rightChildIndex].compareTo(treeArray[largestIndex]) < 0) {
                largestIndex = rightChildIndex;
            }
        }

        if (largestIndex != index) {
            swap(index, largestIndex);
            heapDown(largestIndex);
        }
    }

    private void swap(int index1, int index2) {
        NodoTree<K, T> temp = treeArray[index1];
        treeArray[index1] = treeArray[index2];
        treeArray[index2] = temp;
    }

    private void buildTree() {
        int index = 0;
        while (treeArray[index] != null) {
            NodoTree<K, T> nodo = treeArray[index];
            nodo.setLeftChild(treeArray[(2 * index) + 1]);
            nodo.setRightChild(treeArray[(2 * index) + 2]);
            index++;
        }
    }

    private void expandirCapacidad() {
        treeArray = Arrays.copyOf(treeArray, treeArray.length * 2);
    }
}
