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
    }
}