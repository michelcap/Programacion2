package TAD.TreeBinaryCompleto;
import TAD.Tree.NodoTree;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyTreeBinaryCompletoImplTest {

    @Test
    void insert() {
        MyTreeBinaryCompleto<Integer, String> arbol = new MyTreeBinaryCompletoImpl<>();
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
        arbol.insert(18, "z");
        arbol.insert(17, "y");
        assertEquals(13, arbol.size());
    }

    @Test
    void delete(){
        MyTreeBinaryCompleto<Integer, String> arbol = new MyTreeBinaryCompletoImpl<>();
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
        arbol.insert(20, "l");
        arbol.delete(10);
        NodoTree<Integer, String> borrado = arbol.delete(20);
        assertEquals(10, arbol.size());
    }
}