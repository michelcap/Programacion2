package TAD.Queue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyPriorityQueueImplTest {

    @Test
    void enqueue() {
        MyPriorityQueue<String> cola = new MyPriorityQueueImpl<>();
        cola.enqueue(50,"a");
        cola.enqueue(100,"b");
        cola.enqueue(460,"c");
        cola.enqueue(60,"d");
        cola.enqueue(1003,"e");
        cola.enqueue(1, "f");

        assertEquals("f", cola.tail().getValue());
        assertEquals("e", cola.head().getValue());

        for (int i = cola.size(); i >= 1; i--) {
            System.out.printf("%-5s %-5s %n", cola.get(i).getKey(), cola.get(i).getValue());
        }
    }

    @Test
    void dequeue() {
    }

    @Test
    void isEmpty() {
    }
}