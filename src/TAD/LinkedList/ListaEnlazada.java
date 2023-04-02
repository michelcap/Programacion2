package TAD.LinkedList;

public class ListaEnlazada<T> implements Lista<T> {

    private Nodo<T> primero;
    private Nodo<T> ultimo;
    private int size = 0;

    // Getter primero
    public Nodo<T> getPrimero() {
        return primero;
    }

    // Setter primero
    public void setPrimero(Nodo<T> new_Primero) {
        this.primero = new_Primero;
    }

    // Getter ultimo
    public Nodo<T> getUltimo() {
        return ultimo;
    }

    // Setter ultimo
    public void setUltimo(Nodo<T> new_Ultimo) {
        this.ultimo = new_Ultimo;
    }

    // Getter size
    public int getSize() {
        return size;
    }

    @Override
    public void add(T value) {
        if (getPrimero() == null) {
            Nodo<T> nuevoNodo = new Nodo<T>(value);
            setPrimero(nuevoNodo);
            setUltimo(nuevoNodo);
            size++;
        } else {
            Nodo<T> ultimoNodo = getUltimo();
            Nodo<T> nuevoNodo = new Nodo<T>(value);
            ultimoNodo.setNext(nuevoNodo);
            setUltimo(nuevoNodo);
            size++;
        }
    }

    @Override
    public T get(int position) {
        T retorno = null;
        Nodo<T> retornoNodo = getPrimero();
        if (retornoNodo != null) {
            int contador = 0;
            while (retornoNodo != null) {
                if (contador == position) {
                    retorno = retornoNodo.getValue();
                    break;
                } else {
                    retornoNodo = retornoNodo.getNext();
                    contador++;
                }
            }
        }
        return retorno;
    }

    @Override
    public void remove(int position) {
        try {
            if ((0 <= position) && (position < getSize())) {
                Nodo<T> currentNodo = getPrimero();
                Nodo<T> lastNodo = currentNodo;
                if (currentNodo != null) {
                    int contador = 0;
                    while (currentNodo != null) {
                        if (contador == position) {
                            lastNodo.setNext(currentNodo.getNext());
                            size--;
                            break;
                        } else {
                            lastNodo = currentNodo;
                            currentNodo = currentNodo.getNext();
                            contador++;
                        }
                    }
                }
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Out of Range");
        }
    }

        @Override
        public boolean exists (T value){
            boolean retorno = false;
            Nodo<T> retornoNodo = getPrimero();
            if (retornoNodo != null) {
                while (retornoNodo != null) {
                    if (retornoNodo.getValue().equals(value)) {
                        retorno = true;
                        break;
                    } else {
                        retornoNodo = retornoNodo.getNext();
                    }
                }
            }
            return retorno;
        }

        @Override
        public int size () {
            return getSize();
        }

    @Override
    public void addFirst(T value) {
        Nodo<T> nuevoNodo = new Nodo<T>(value);
        if (getPrimero() == null) {
            setPrimero(nuevoNodo);
            setUltimo(nuevoNodo);
            size++;
        } else {
            Nodo<T> primerNodo = getPrimero();
            nuevoNodo.setNext(primerNodo);
            setPrimero(nuevoNodo);
            size++;
        }
    }

    @Override
    public void addLast(T value) {
        Nodo<T> nuevoNodo = new Nodo<T>(value);
        if (getPrimero() == null) {
            setPrimero(nuevoNodo);
            setUltimo(nuevoNodo);
            size++;
        } else {
            Nodo<T> ultimoNodo = getUltimo();
            ultimoNodo.setNext(nuevoNodo);
            setUltimo(nuevoNodo);
            size++;
        }
    }


}
