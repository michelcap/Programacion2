package TAD.Tree;

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
    }

    @Test
    void countLeaf() {
    }

    @Test
    void countNonLeaf() {
    }

    @Test
    void inOrder() {
    }

    @Test
    void preOrder() {
    }

    @Test
    void postOrder() {
    }

    @Test
    void isEmpty() {
    }
}