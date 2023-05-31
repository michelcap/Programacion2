package TAD.Queue;

import org.junit.jupiter.api.Test;

import java.util.function.BooleanSupplier;

import static org.junit.jupiter.api.Assertions.*;

class MyQueueImplTest {

    @Test
    void enqueue() {
        MyQueue<Integer> queue = new MyQueueImpl<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        assertEquals(1, queue.head().getValue());
        assertEquals(3, queue.tail().getValue());
    }

    @Test
    void dequeue() throws MyQueue.EmptyQueueException {
        MyQueue<Integer> queue;
        queue = new MyQueueImpl<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        assertEquals(1, queue.dequeue().getValue());
        assertEquals(2, queue.head().getValue());
        assertEquals(3, queue.tail().getValue());
    }

    @Test
    void dequeueColaConSoloUnElemento() throws MyQueue.EmptyQueueException {
        MyQueue<Integer> queue;
        queue = new MyQueueImpl<>();
        queue.enqueue(1);
        assertEquals(1, queue.dequeue().getValue());
    }

    @Test
    void isEmpty() {
        MyQueue<Integer> queue = new MyQueueImpl<>();
        assertTrue(queue.isEmpty());
        queue.enqueue(1);
        assertFalse(queue.isEmpty());
    }

    @Test
    void head() throws MyQueue.EmptyQueueException {
        MyQueue<Integer> queue = new MyQueueImpl<>();
        assertTrue(queue.isEmpty());
        queue.enqueue(1);
        assertEquals(1, queue.head().getValue());
    }
}