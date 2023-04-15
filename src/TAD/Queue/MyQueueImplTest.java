package TAD.Queue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyQueueImplTest {

    @Test
    void enqueue() {
        MyQueueImpl<Integer> queue = new MyQueueImpl();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        assertEquals(1, queue.getHead().getValue());
        assertEquals(3, queue.getTail().getValue());
    }

    @Test
    void dequeue() throws MyQueue.EmptyQueueException {
        MyQueueImpl<Integer> queue = new MyQueueImpl();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        assertEquals(1, queue.dequeue().getValue());
        assertEquals(2, queue.getHead().getValue());
        assertEquals(3, queue.getTail().getValue());
    }

    @Test
    void isEmpty() {
        MyQueueImpl<Integer> queue = new MyQueueImpl();
        assertTrue(queue.isEmpty());
        queue.enqueue(1);
        assertFalse(queue.isEmpty());
    }
}