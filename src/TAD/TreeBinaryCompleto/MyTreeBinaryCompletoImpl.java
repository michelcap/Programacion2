package TAD.TreeBinaryCompleto;

import TAD.Heap.MyHeap;
import TAD.Tree.NodoTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyTreeBinaryCompletoImpl<K extends Comparable<K>, T> implements MyTreeBinaryCompleto<K, T> {
    private NodoTree[] treeArray;
    private K key;
    private T data;
    private NodoTree<K, T> parent;
    private NodoTree<K, T> raiz;
    private int size = 0;
    private int ultimoIndice = 0;
    private int cantidadNodos = 0;

    public MyTreeBinaryCompletoImpl() {
        int capacidad = 5;
        cantidadNodos = (int) Math.pow(2, capacidad);
        int aux = cantidadNodos;
        while (aux > 1) {
            aux = aux / 2;
            cantidadNodos = cantidadNodos + aux;
        }
        treeArray = new NodoTree[cantidadNodos];
    }

    public MyTreeBinaryCompletoImpl(int capacidad) throws Exception {
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

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public void insert(K key, T data) throws Exception {
        if (cantidadNodos > getSize()) {
            if (getRaiz() == null) {
                NodoTree<K, T> nodo = new NodoTree<K, T>(key, data);
                setParent(nodo);
                setRaiz(nodo);
                ultimoIndice = 0;
                treeArray[ultimoIndice] = nodo;
                size++;
                ultimoIndice++;
            } else {
                NodoTree<K, T> nodo = new NodoTree<K, T>(key, data);
                treeArray[ultimoIndice] = nodo;
                if (ultimoIndice % 2 == 0) {
                    int index = (ultimoIndice - 2) / 2;
                    NodoTree<K, T> padre = treeArray[index];
                    padre.setRightChild(nodo);
                } else {
                    int index = (ultimoIndice - 1) / 2;
                    NodoTree<K, T> padre = treeArray[index];
                    padre.setLeftChild(nodo);
                }
                size++;
                ultimoIndice++;
            }
        } else {
            expandirCapacidad();
            throw new Exception("Se a expandido la capacidad reintente de nuevo");
        }
    }

    private NodoTree<K, T> deleteNodo(int indice, K key) {
        NodoTree<K, T> nodoRetorno;
        if (treeArray[indice].getKey().equals(key)) {
            nodoRetorno = treeArray[indice];
            while (treeArray[indice] != null) {
                treeArray[indice] = treeArray[indice + 1];
                indice++;
            }
            int index = 0;
            while (treeArray[index] != null) {
                NodoTree<K, T> nodo = treeArray[index];
                nodo.setLeftChild(treeArray[(2 * index) + 1]);
                nodo.setRightChild(treeArray[(2 * index) + 2]);
                index++;
            }
            size--;
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

    public String toString() {
        List<List<String>> lines = new ArrayList<List<String>>();

        List<NodoTree<K,T>> level = new ArrayList<NodoTree<K,T>>();
        List<NodoTree<K,T>> next = new ArrayList<NodoTree<K,T>>();

        level.add(getRaiz());
        int nn = 1;

        int widest = 0;

        while (nn != 0) {
            List<String> line = new ArrayList<String>();

            nn = 0;

            for (NodoTree<K,T> n : level) {
                if (n == null) {
                    line.add(null);

                    next.add(null);
                    next.add(null);
                } else {
                    // Aca es para alterar y visualizar lo que segun guste
                    String aa = n.getKey().toString();
                    line.add(aa);
                    if (aa.length() > widest) widest = aa.length();

                    next.add(n.getLeftChild());
                    next.add(n.getRightChild());

                    if (n.getLeftChild() != null) nn++;
                    if (n.getRightChild() != null) nn++;
                }
            }

            if (widest % 2 == 1) widest++;

            lines.add(line);

            List<NodoTree<K,T>> tmp = level;
            level = next;
            next = tmp;
            next.clear();
        }

        int perpiece = lines.get(lines.size() - 1).size() * (widest + 4);
        for (int i = 0; i < lines.size(); i++) {
            List<String> line = lines.get(i);
            int hpw = (int) Math.floor(perpiece / 2f) - 1;

            if (i > 0) {
                for (int j = 0; j < line.size(); j++) {

                    // split node
                    char c = ' ';
                    if (j % 2 == 1) {
                        if (line.get(j - 1) != null) {
                            c = (line.get(j) != null) ? '┴' : '┘';
                        } else {
                            if (j < line.size() && line.get(j) != null) c = '└';
                        }
                    }
                    System.out.print(c);

                    // lines and spaces
                    if (line.get(j) == null) {
                        for (int k = 0; k < perpiece - 1; k++) {
                            System.out.print(" ");
                        }
                    } else {

                        for (int k = 0; k < hpw; k++) {
                            System.out.print(j % 2 == 0 ? " " : "─");
                        }
                        System.out.print(j % 2 == 0 ? "┌" : "┐");
                        for (int k = 0; k < hpw; k++) {
                            System.out.print(j % 2 == 0 ? "─" : " ");
                        }
                    }
                }
                System.out.println();
            }

            // print line of numbers
            for (int j = 0; j < line.size(); j++) {

                String f = line.get(j);
                if (f == null) f = "";
                int gap1 = (int) Math.ceil(perpiece / 2f - f.length() / 2f);
                int gap2 = (int) Math.floor(perpiece / 2f - f.length() / 2f);

                // a number
                for (int k = 0; k < gap1; k++) {
                    System.out.print(" ");
                }
                System.out.print(f);
                for (int k = 0; k < gap2; k++) {
                    System.out.print(" ");
                }
            }
            System.out.println();

            perpiece /= 2;
        }
        return "Árbol Completo";
    }

    private void expandirCapacidad() {
        treeArray = Arrays.copyOf(treeArray, treeArray.length * 2);
    }
}


//    @Override
//    public void insert(K key, T data) throws Exception {
//        if (cantidadNodos > getSize()) {
//            if (getRaiz() == null) {
//                NodoTree<K, T> nodo = new NodoTree<K, T>(key, data);
//                setParent(nodo);
//                setRaiz(nodo);
//                ultimoIndice = 0;
//                treeArray[ultimoIndice] = nodo;
//                size++;
//            } else if (getParent().getLeftChild() == null || getParent().getRightChild() == null) {
//                if (treeArray[2 * ultimoIndice + 1] == null) {
//                    NodoTree<K, T> padre = treeArray[ultimoIndice];
//                    NodoTree<K, T> nodo = new NodoTree<K, T>(key, data);
//                    padre.setLeftChild(nodo);
//                    treeArray[(2 * ultimoIndice) + 1] = nodo;
//                    size++;
//                } else if (treeArray[(2 * ultimoIndice) + 2] == null) {
//                    NodoTree<K, T> padre = treeArray[ultimoIndice];
//                    NodoTree<K, T> nodo = new NodoTree<K, T>(key, data);
//                    padre.setRightChild(nodo);
//                    treeArray[(2 * ultimoIndice) + 2] = nodo;
//                    ultimoIndice++;
//                    NodoTree<K, T> nuevoPariente = treeArray[ultimoIndice];
//                    setParent(nuevoPariente);
//                    size++;
//                }
//            }
//        } else {
//            throw new Exception("Array lleno");
//        }
//    }
//
//    private NodoTree<K, T> deleteNodo(int indice, K key) {
//        NodoTree<K, T> nodoRetorno;
//        if (treeArray[indice].getKey().equals(key)) {
//            nodoRetorno = treeArray[indice];
//            if (indice != 0) {
//                if (indice % 2 == 0) {
//                    int index = (indice - 2) / 2;
//                    NodoTree<K, T> padre = treeArray[index];
//                    if (treeArray[indice + 1] == null) {
//                        padre.setRightChild(null);
//                    } else if (treeArray[indice + 2] != null) {
//                        padre.setLeftChild(treeArray[indice + 1]);
//                        padre.setRightChild(treeArray[indice + 2]);
//                    }
//                } else {
//                    int index = (indice - 1) / 2;
//                    NodoTree<K, T> padre = treeArray[index];
//                    if (treeArray[indice + 1] == null) {
//                        padre.setLeftChild(null);
//                    } else if (treeArray[indice + 2] != null) {
//                        padre.setLeftChild(treeArray[indice + 1]);
//                        padre.setRightChild(treeArray[indice + 2]);
//                    }
//                }
//                int index = indice;
//                while (treeArray[indice] != null) {
//                    treeArray[indice] = treeArray[indice + 1];
//                    indice++;
//                }
//                while (treeArray[index] != null) {
//                    NodoTree<K, T> nodo = treeArray[index];
//                    nodo.setLeftChild(treeArray[(2 * index) + 1]);
//                    nodo.setRightChild(treeArray[(2 * index) + 2]);
//                    index++;
//                }
//                size--;
//            } else {
//                setRaiz(treeArray[indice + 1]);
//                int index = indice + 1;
//                while (treeArray[index] != null) {
//                    NodoTree<K, T> nodo = treeArray[index];
//                    nodo.setLeftChild(treeArray[2 * index]);
//                    nodo.setRightChild(treeArray[(2 * index) + 1]);
//                    index++;
//                }
//                while (treeArray[indice] != null) {
//                    treeArray[indice] = treeArray[indice + 1];
//                    indice++;
//                }
//                size--;
//            }
//        } else {
//            indice++;
//            nodoRetorno = deleteNodo(indice, key);
//        }
//        return nodoRetorno;
//    }
//

