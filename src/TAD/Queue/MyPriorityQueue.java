package TAD.Queue;

public interface MyPriorityQueue<T> {

    void enqueue(int priority, T element);

    NodoQueue<T> dequeue() throws MyQueue.EmptyQueueException;

    NodoQueue<T> head();

    NodoQueue<T> tail();

    int size();

    boolean isEmpty();

    class EmptyQueueException extends Exception {
        public EmptyQueueException(String message) {
            super(message);
        }
    }

    NodoQueue<T> get(int i);
}
