package TAD.LinkedList;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ListaDobleEnlazadaTest {

    @Test
    void testEmptySizeIsZero() {
        ListaDoble<Integer> nuevaListaDoble = new ListaDobleEnlazada<>();
        assertEquals(0, nuevaListaDoble.size());
    }

    @Test
    void testSize() {
        ListaDoble<Integer> nuevaListaDoble = new ListaDobleEnlazada<>();
        nuevaListaDoble.addAscendente(1);
        nuevaListaDoble.addAscendente(2);
        assertEquals(2, nuevaListaDoble.size());
    }

    @Test
    void testaddAscendenteToEmpty() {
        ListaDoble<Integer> nuevaListaDoble = new ListaDobleEnlazada<>();
        assertEquals(0, nuevaListaDoble.size());
    }

    @Test
    void testAddAscendenteToNonEmpty() {
        ListaDoble<Integer> nuevaListaDoble = new ListaDobleEnlazada<>();
        nuevaListaDoble.addAscendente(1);
        nuevaListaDoble.addAscendente(2);
        assertEquals(1, nuevaListaDoble.get(0));
        assertEquals(2, nuevaListaDoble.get(1));
        nuevaListaDoble.addAscendente(10);
        nuevaListaDoble.addAscendente(11);
        assertEquals(10, nuevaListaDoble.get(2));
        assertEquals(11, nuevaListaDoble.get(3));
        nuevaListaDoble.addAscendente(6);
        nuevaListaDoble.addAscendente(7);
        nuevaListaDoble.addAscendente(4);
        nuevaListaDoble.addAscendente(5);
        nuevaListaDoble.addAscendente(3);
        nuevaListaDoble.addAscendente(0);

        ArrayList<Integer> listaNumeros = new ArrayList<>(10);
        for (int i = 0; i < nuevaListaDoble.size(); i++) {
            listaNumeros.add(nuevaListaDoble.get(i));
        }
        assertArrayEquals(new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 10, 11}, listaNumeros.toArray());
    }

    @Test
    void testGetToEmpty() {
        ListaDoble<Integer> nuevaListaDoble = new ListaDobleEnlazada<>();
        assertNull(nuevaListaDoble.get(0));
        assertEquals(0, nuevaListaDoble.size());
        ListaDoble<String> nuevaListaDoble2 = new ListaDobleEnlazada<>();
        assertNull(nuevaListaDoble2.get(0));
        assertEquals(0, nuevaListaDoble2.size());
    }

    @Test
    void testGetToNonEmpty() {
        ListaDoble<Integer> nuevaListaDoble = new ListaDobleEnlazada<>();
        nuevaListaDoble.addAscendente(1);
        nuevaListaDoble.addAscendente(2);
        assertInstanceOf(Integer.class, nuevaListaDoble.get(0));
        assertInstanceOf(Integer.class, nuevaListaDoble.get(1));
        assertEquals(1, nuevaListaDoble.get(0));
        assertEquals(2, nuevaListaDoble.get(1));
        assertEquals(2, nuevaListaDoble.size());
        ListaDoble<String> nuevaListaDoble2 = new ListaDobleEnlazada<>();
        assertEquals(0, nuevaListaDoble2.size());
        nuevaListaDoble2.addAscendente("a");
        nuevaListaDoble2.addAscendente("b");
        assertEquals("a", nuevaListaDoble2.get(0));
        assertEquals("b", nuevaListaDoble2.get(1));
        assertEquals(2, nuevaListaDoble2.size());
    }

    @Test
    void testRemoveNonEmpty() {
        ListaDoble<Integer> nuevaListaDoble = new ListaDobleEnlazada<>();
        nuevaListaDoble.addAscendente(1);
        nuevaListaDoble.addAscendente(2);
        nuevaListaDoble.addAscendente(0);
        nuevaListaDoble.remove(1);
        assertEquals(0, nuevaListaDoble.get(0));
        assertEquals(2, nuevaListaDoble.get(1));
    }

    @Test
    void testRemoveEmpty() {
        ListaDoble<Integer> nuevaListaDoble = new ListaDobleEnlazada<>();
        nuevaListaDoble.remove(0);
    }

    @Test
    void testExistsElement() {
        ListaDoble<Integer> nuevaListaDoble = new ListaDobleEnlazada<>();
        nuevaListaDoble.addAscendente(1);
        nuevaListaDoble.addAscendente(2);
        assertTrue(nuevaListaDoble.exists(1));
        assertFalse(nuevaListaDoble.exists(3));
    }
}