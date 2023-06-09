package TAD.Queue;

public interface MyQueue<T> {

    void enqueue(T element);

    NodoQueue<T> dequeue() throws EmptyQueueException;

    NodoQueue<T> head();

    NodoQueue<T> tail();

    int size();

    boolean isEmpty();

    class EmptyQueueException extends Exception {
        public EmptyQueueException(String message) {
            super(message);
        }
    }


}
