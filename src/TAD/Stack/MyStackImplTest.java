package TAD.Stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyStackImplTest {

    @Test
    void push() {
        MyStack<Integer> myStack = new MyStackImpl<>();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        assertEquals(3, myStack.top().getValue());
    }

    @Test
    void pop() {
        MyStack<Integer> myStack = new MyStackImpl<>();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        assertEquals(3, myStack.pop().getValue());
        assertEquals(2, myStack.pop().getValue());
        assertEquals(1, myStack.pop().getValue());
    }

    @Test
    void top() {
        MyStack<Integer> myStack = new MyStackImpl<>();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        assertEquals(3, myStack.top().getValue());
    }

    @Test
    void isEmpty() {
        MyStack<Integer> myStack = new MyStackImpl<>();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        assertFalse(myStack.isEmpty());
        MyStackImpl<String> myStack2 = new MyStackImpl<>();
        assertTrue(myStack2.isEmpty());
    }

    @Test
    void makeEmpty() {
        MyStack<Integer> myStack = new MyStackImpl<>();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        assertFalse(myStack.isEmpty());
        myStack.makeEmpty();
        assertTrue(myStack.isEmpty());
    }
}