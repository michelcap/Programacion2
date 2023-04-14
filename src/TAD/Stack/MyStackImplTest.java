package TAD.Stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyStackImplTest {

    @Test
    void push() {
        MyStackImpl<Integer> myStack = new MyStackImpl<>();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        assertEquals(3, myStack.top());
    }

    @Test
    void pop() {
        MyStackImpl<Integer> myStack = new MyStackImpl<>();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        assertEquals(3, myStack.pop());
        assertEquals(2, myStack.pop());
        assertEquals(1, myStack.pop());
    }

    @Test
    void top() {
        MyStackImpl<Integer> myStack = new MyStackImpl<>();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        assertEquals(3, myStack.top());
    }

    @Test
    void isEmpty() {
        MyStackImpl<Integer> myStack = new MyStackImpl<>();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        assertFalse(myStack.isEmpty());
        MyStackImpl<String> myStack2 = new MyStackImpl<>();
        assertTrue(myStack2.isEmpty());
    }

    @Test
    void makeEmpty() {
        MyStackImpl<Integer> myStack = new MyStackImpl<>();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        assertFalse(myStack.isEmpty());
        myStack.makeEmpty();
        assertTrue(myStack.isEmpty());
    }
}