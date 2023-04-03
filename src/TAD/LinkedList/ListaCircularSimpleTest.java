package TAD.LinkedList;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListaCircularSimpleTest {

    @Test
    void testEmptySizeIsZero() {
        Lista<Integer> nuevaLista = new ListaEnlazada<>();
        assertEquals(0, nuevaLista.size());
    }

    @Test
    void testSize() {
        Lista<Integer> nuevaLista = new ListaEnlazada<>();
        nuevaLista.add(1);
        nuevaLista.add(2);
        assertEquals(2, nuevaLista.size());
    }

    @Test
    void testAddToEmpty() {
        Lista<Integer> nuevaLista = new ListaEnlazada<>();
        assertEquals(0, nuevaLista.size());
    }

    @Test
    void testAddToNonEmpty() {
        Lista<Integer> nuevaLista = new ListaEnlazada<>();
        nuevaLista.add(1);
        nuevaLista.add(2);
        assertInstanceOf(Integer.class, nuevaLista.get(0));
        assertInstanceOf(Integer.class, nuevaLista.get(1));
        assertEquals(2, nuevaLista.size());
        Lista<String> nuevaLista2 = new ListaEnlazada<>();
        assertEquals(0, nuevaLista2.size());
        nuevaLista2.add("a");
        nuevaLista2.add("b");
        assertEquals(2, nuevaLista2.size());
    }

    @Test
    void testGetToEmpty() {
        Lista<Integer> nuevaLista = new ListaEnlazada<>();
        assertNull(nuevaLista.get(0));
        assertEquals(0, nuevaLista.size());
        Lista<String> nuevaLista2 = new ListaEnlazada<>();
        assertNull(nuevaLista2.get(0));
        assertEquals(0, nuevaLista2.size());
    }

    @Test
    void testGetToNonEmpty() {
        Lista<Integer> nuevaLista = new ListaEnlazada<>();
        nuevaLista.add(1);
        nuevaLista.add(2);
        assertInstanceOf(Integer.class, nuevaLista.get(0));
        assertInstanceOf(Integer.class, nuevaLista.get(1));
        assertEquals(1, nuevaLista.get(0));
        assertEquals(2, nuevaLista.get(1));
        assertEquals(2, nuevaLista.size());
        Lista<String> nuevaLista2 = new ListaEnlazada<>();
        assertEquals(0, nuevaLista2.size());
        nuevaLista2.add("a");
        nuevaLista2.add("b");
        assertEquals("a", nuevaLista2.get(0));
        assertEquals("b", nuevaLista2.get(1));
        assertEquals(2, nuevaLista2.size());
    }

    @Test
    void testRemoveNonEmpty() {
        Lista<Integer> nuevaLista = new ListaEnlazada<>();
        nuevaLista.add(1);
        nuevaLista.add(2);
        nuevaLista.remove(1);
        assertEquals(1, nuevaLista.size());
        nuevaLista.remove(0);
        assertEquals(0, nuevaLista.size());
    }

    @Test
    void testRemoveEmpty() {
        Lista<Integer> nuevaLista = new ListaEnlazada<>();
        nuevaLista.add(1);
        nuevaLista.add(2);
        nuevaLista.remove(1);
        assertEquals(1, nuevaLista.size());
        assertNull(nuevaLista.get(1));
        assertEquals(1, nuevaLista.get(0));
    }

    @Test
    void testExistsElement() {
        Lista<Integer> nuevaLista = new ListaEnlazada<>();
        nuevaLista.add(1);
        nuevaLista.add(2);
        assertTrue(nuevaLista.exists(1));
        assertFalse(nuevaLista.exists(3));
    }

    @Test
    void addFirst() {
        Lista<Integer> nuevaLista = new ListaEnlazada<>();
        nuevaLista.addFirst(1);
        assertEquals(1, nuevaLista.get(0));
        nuevaLista.addFirst(2);
        assertEquals(2, nuevaLista.get(0));
        nuevaLista.addFirst(3);
        assertEquals(3, nuevaLista.get(0));
    }

    @Test
    void addLast() {
        Lista<Integer> nuevaLista = new ListaEnlazada<>();
        nuevaLista.addLast(1);
        assertEquals(1, nuevaLista.get(nuevaLista.size() - 1));
        nuevaLista.addLast(2);
        assertEquals(2, nuevaLista.get(nuevaLista.size() - 1));
        nuevaLista.addLast(3);
        assertEquals(3, nuevaLista.get(nuevaLista.size() - 1));
    }
}