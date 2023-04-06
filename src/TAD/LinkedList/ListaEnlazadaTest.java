package TAD.LinkedList;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ListaEnlazadaTest {

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
        assertInstanceOf(Integer.class, nuevaLista.get(0).getValue());
        assertInstanceOf(Integer.class, nuevaLista.get(1).getValue());
        assertEquals(2, nuevaLista.size());
        Lista<String> nuevaLista2 = new ListaEnlazada<>();
        assertEquals(0, nuevaLista2.size());
        nuevaLista2.add("a");
        nuevaLista2.add("b");
        assertEquals(2, nuevaLista2.size());
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
        assertInstanceOf(Integer.class, nuevaLista.get(0).getValue());
        assertInstanceOf(Integer.class, nuevaLista.get(1).getValue());
        assertEquals(1, nuevaLista.get(0).getValue());
        assertEquals(2, nuevaLista.get(1).getValue());
        assertEquals(2, nuevaLista.size());
        Lista<String> nuevaLista2 = new ListaEnlazada<>();
        assertEquals(0, nuevaLista2.size());
        nuevaLista2.add("a");
        nuevaLista2.add("b");
        assertEquals("a", nuevaLista2.get(0).getValue());
        assertEquals("b", nuevaLista2.get(1).getValue());
        assertEquals(2, nuevaLista2.size());
    }
    @Test
    void testRemoveNonEmpty() {
        Lista<Integer> nuevaLista = new ListaEnlazada<>();
        nuevaLista.add(1);
        nuevaLista.add(2);
        nuevaLista.remove(1);
        assertEquals(1, nuevaLista.size());
        assertNull(nuevaLista.get(1));
        assertEquals(1, nuevaLista.get(0).getValue());
    }

    @Test
    void testRemoveEmpty() {
        Lista<Integer> nuevaLista = new ListaEnlazada<>();
        nuevaLista.remove(0);
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
    void testAddFirst() {
        Lista<Integer> nuevaLista = new ListaEnlazada<>();
        nuevaLista.addFirst(1);
        assertEquals(1, nuevaLista.get(0).getValue());
        nuevaLista.addFirst(2);
        assertEquals(2, nuevaLista.get(0).getValue());
        nuevaLista.addFirst(3);
        assertEquals(3, nuevaLista.get(0).getValue());
    }

    @Test
    void testAddLast() {
        Lista<Integer> nuevaLista = new ListaEnlazada<>();
        nuevaLista.addLast(1);
        assertEquals(1, nuevaLista.get(nuevaLista.size() - 1).getValue());
        nuevaLista.addLast(2);
        assertEquals(2, nuevaLista.get(nuevaLista.size() - 1).getValue());
        nuevaLista.addLast(3);
        assertEquals(3, nuevaLista.get(nuevaLista.size() - 1).getValue());
    }

    @Test
    void testIntercambiarHEADPositivamente() {
        Lista<Integer> nuevaLista = new ListaEnlazada<>();
        nuevaLista.add(1);
        nuevaLista.add(2);
        nuevaLista.add(3);
        nuevaLista.add(4);
        nuevaLista.add(5);
        try {
            nuevaLista.intercambiar(1,1);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        assertEquals(2, nuevaLista.get(0).getValue());
        assertEquals(1, nuevaLista.get(1).getValue());
        ArrayList<Integer> listaNumeros = new ArrayList<>(5);
        for (int i = 0; i < nuevaLista.size(); i++) {
            listaNumeros.add(nuevaLista.get(i).getValue());
        }
        assertArrayEquals(new Integer[]{2, 1, 3, 4, 5}, listaNumeros.toArray());
    }

    @Test
    void testIntercambiarSectorMedioPositivamente() {
        Lista<Integer> nuevaLista = new ListaEnlazada<>();
        nuevaLista.add(1);
        nuevaLista.add(2);
        nuevaLista.add(3);
        nuevaLista.add(4);
        nuevaLista.add(5);
        try {
            nuevaLista.intercambiar(3,1);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        assertEquals(4, nuevaLista.get(2).getValue());
        assertEquals(3, nuevaLista.get(3).getValue());

        ArrayList<Integer> listaNumeros = new ArrayList<>(5);
        for (int i = 0; i < nuevaLista.size(); i++) {
            listaNumeros.add(nuevaLista.get(i).getValue());
        }
        assertArrayEquals(new Integer[]{1, 2, 4, 3, 5}, listaNumeros.toArray());
    }

    @Test
    void testIntercambiarFEETPositivamente() {
        Lista<Integer> nuevaLista = new ListaEnlazada<>();
        nuevaLista.add(1);
        nuevaLista.add(2);
        nuevaLista.add(3);
        nuevaLista.add(4);
        nuevaLista.add(5);
        try {
            nuevaLista.intercambiar(4,1);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        assertEquals(4, nuevaLista.get(4).getValue());
        assertEquals(5, nuevaLista.get(3).getValue());

        ArrayList<Integer> listaNumeros = new ArrayList<>(5);
        for (int i = 0; i < nuevaLista.size(); i++) {
            listaNumeros.add(nuevaLista.get(i).getValue());
        }
        assertArrayEquals(new Integer[]{1, 2, 3, 5, 4}, listaNumeros.toArray());
    }

    @Test
    void testIntercambiarHEADNegativamente() {
        Lista<Integer> nuevaLista = new ListaEnlazada<>();
        nuevaLista.add(1);
        nuevaLista.add(2);
        nuevaLista.add(3);
        nuevaLista.add(4);
        nuevaLista.add(5);
        try {
            nuevaLista.intercambiar(1,-1);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        assertEquals(5, nuevaLista.get(0).getValue());
        assertEquals(1, nuevaLista.get(4).getValue());
        ArrayList<Integer> listaNumeros = new ArrayList<>(5);
        for (int i = 0; i < nuevaLista.size(); i++) {
            listaNumeros.add(nuevaLista.get(i).getValue());
        }
        assertArrayEquals(new Integer[]{5, 2, 3, 4, 1}, listaNumeros.toArray());
    }

    @Test
    void testIntercambiarSectorMedioNegativamente() throws Exception {
        Lista<Integer> nuevaLista = new ListaEnlazada<>();
        nuevaLista.add(1);
        nuevaLista.add(2);
        nuevaLista.add(3);
        nuevaLista.add(4);
        nuevaLista.add(5);
        try {
            nuevaLista.intercambiar(4,-1);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        assertEquals(4, nuevaLista.get(2).getValue());
        assertEquals(3, nuevaLista.get(3).getValue());

        ArrayList<Integer> listaNumeros = new ArrayList<>(5);
        for (int i = 0; i < nuevaLista.size(); i++) {
            listaNumeros.add(nuevaLista.get(i).getValue());
        }
        assertArrayEquals(new Integer[]{1, 2, 4, 3, 5}, listaNumeros.toArray());
    }

    @Test
    void testIntercambiarFEETNegativamente() throws Exception {
        Lista<Integer> nuevaLista = new ListaEnlazada<>();
        nuevaLista.add(1);
        nuevaLista.add(2);
        nuevaLista.add(3);
        nuevaLista.add(4);
        nuevaLista.add(5);
        try {
            nuevaLista.intercambiar(5,-1);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        assertEquals(4, nuevaLista.get(4).getValue());
        assertEquals(5, nuevaLista.get(3).getValue());

        ArrayList<Integer> listaNumeros = new ArrayList<>(5);
        for (int i = 0; i < nuevaLista.size(); i++) {
            listaNumeros.add(nuevaLista.get(i).getValue());
        }
        assertArrayEquals(new Integer[]{1, 2, 3, 5, 4}, listaNumeros.toArray());
    }

    @Test
    void testAppend() {
        Lista<Integer> nuevaLista = new ListaEnlazada<>();
        nuevaLista.add(1);
        nuevaLista.add(2);
        nuevaLista.add(3);
        nuevaLista.add(4);
        nuevaLista.add(5);

        Lista<Integer> nuevaLista1 = new ListaEnlazada<>();
        nuevaLista1.add(6);
        nuevaLista1.add(7);
        nuevaLista1.add(8);
        nuevaLista1.add(9);
        nuevaLista1.add(10);

        nuevaLista.append(nuevaLista1);

        ArrayList<Integer> listaNumeros = new ArrayList<>(5);
        for (int i = 0; i < nuevaLista.size(); i++) {
            listaNumeros.add(nuevaLista.get(i).getValue());
        }
        assertArrayEquals(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, listaNumeros.toArray());
    }
}