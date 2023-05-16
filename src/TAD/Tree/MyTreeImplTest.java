package TAD.Tree;

import TAD.LinkedList.Lista;
import TAD.LinkedList.ListaEnlazada;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyTreeImplTest {

    @Test
    void insert() {
        MyTree<Integer, String> arbol = new MyTreeImpl<>();
        arbol.insert(1, "a");
        arbol.insert(4, "b");
        arbol.insert(3, "c");
        arbol.insert(5, "d");
        arbol.insert(2, "e");
        arbol.insert(6, "f");
        arbol.insert(10, "g");
        assertEquals(7, arbol.size());
        assertEquals("a", arbol.find(1).getData());
        assertEquals("b", arbol.find(4).getData());
        assertEquals("c", arbol.find(3).getData());
        assertEquals("d", arbol.find(5).getData());
        assertEquals("e", arbol.find(2).getData());
        assertEquals("f", arbol.find(6).getData());
        assertEquals("g", arbol.find(10).getData());
    }

    @Test
    void find() {
        MyTree<Integer, String> arbol = new MyTreeImpl<>();
        arbol.insert(1, "a");
        arbol.insert(4, "b");
        arbol.insert(3, "c");
        arbol.insert(5, "d");
        arbol.insert(2, "e");
        arbol.insert(6, "f");
        arbol.insert(10, "g");
        assertEquals(7, arbol.size());
        assertEquals("d", arbol.find(5).getData());
        assertEquals("e", arbol.find(2).getData());
        assertEquals("f", arbol.find(6).getData());
        assertEquals("g", arbol.find(10).getData());
        assertEquals("a", arbol.find(1).getData());
        assertEquals("b", arbol.find(4).getData());
        assertEquals("c", arbol.find(3).getData());
    }

    @Test
    void delete() {
    }

    @Test
    void size() {
        MyTree<Integer, String> arbol = new MyTreeImpl<>();
        arbol.insert(10, "a");
        arbol.insert(4, "b");
        arbol.insert(15, "c");
        arbol.insert(5, "d");
        arbol.insert(30, "e");
        arbol.insert(6, "f");
        arbol.insert(1, "g");
        arbol.insert(3, "h");
        arbol.insert(25, "i");
        arbol.insert(12, "j");
        arbol.insert(0, "k");
        assertEquals(11, arbol.size());
    }

    @Test
    void countLeaf() {
        MyTree<Integer, String> arbol = new MyTreeImpl<>();
        arbol.insert(10, "a");
        arbol.insert(4, "b");
        arbol.insert(15, "c");
        arbol.insert(5, "d");
        arbol.insert(30, "e");
        arbol.insert(6, "f");
        arbol.insert(1, "g");
        arbol.insert(3, "h");
        arbol.insert(25, "i");
        arbol.insert(12, "j");
        arbol.insert(0, "k");
        assertEquals(11, arbol.size());
        assertEquals(5, arbol.countLeaf());
    }

    @Test
    void cuentaNodoLleno() {
        MyTree<Integer, String> arbol = new MyTreeImpl<>();
        arbol.insert(10, "a");
        arbol.insert(4, "b");
        arbol.insert(15, "c");
        arbol.insert(5, "d");
        arbol.insert(30, "e");
        arbol.insert(6, "f");
        arbol.insert(1, "g");
        arbol.insert(3, "h");
        arbol.insert(25, "i");
        arbol.insert(12, "j");
        arbol.insert(0, "k");
        assertEquals(4, (arbol.countCompleteElements()));
    }

    @Test
    void countNonLeaf() {
    }

    @Test
    void inOrder() {
        MyTree<Integer, String> arbol = new MyTreeImpl<>();
        arbol.insert(10, "a");
        arbol.insert(4, "b");
        arbol.insert(15, "c");
        arbol.insert(6, "e");
        arbol.insert(30, "g");
        arbol.insert(5, "j");
        arbol.insert(7, "k");
        arbol.insert(1, "d");
        arbol.insert(3, "i");
        arbol.insert(25, "n");
        arbol.insert(12, "f");
        arbol.insert(0, "h");
        Lista<String> lista = new ListaEnlazada<>();
        lista = arbol.inOrder();
        for (int i = 0; i < lista.size(); i++) {
            System.out.print(lista.get(i).getValue() + " ");
        }
    }

    @Test
    void preOrder() {
        MyTree<Integer, String> arbol = new MyTreeImpl<>();
        arbol.insert(10, "a");
        arbol.insert(4, "b");
        arbol.insert(15, "c");
        arbol.insert(6, "e");
        arbol.insert(30, "g");
        arbol.insert(5, "j");
        arbol.insert(7, "k");
        arbol.insert(1, "d");
        arbol.insert(3, "i");
        arbol.insert(25, "n");
        arbol.insert(12, "f");
        arbol.insert(0, "h");
        Lista<String> lista = new ListaEnlazada<>();
        lista = arbol.preOrder();
        for (int i = 0; i < lista.size(); i++) {
            System.out.print(lista.get(i).getValue() + " ");
        }
    }

    @Test
    void postOrder() {
        MyTree<Integer, String> arbol = new MyTreeImpl<>();
        arbol.insert(10, "a");
        arbol.insert(4, "b");
        arbol.insert(15, "c");
        arbol.insert(6, "e");
        arbol.insert(30, "g");
        arbol.insert(5, "j");
        arbol.insert(7, "k");
        arbol.insert(1, "d");
        arbol.insert(3, "i");
        arbol.insert(25, "n");
        arbol.insert(12, "f");
        arbol.insert(0, "h");
        Lista<String> lista = new ListaEnlazada<>();
        lista = arbol.postOrder();
        for (int i = 0; i < lista.size(); i++) {
            System.out.print(lista.get(i).getValue() + " ");
        }
    }

    @Test
    void isEmpty() {
    }


}