package TAD.Stack;

import java.util.EmptyStackException;

public interface MyStack<T> {

    void push(T element);

    T pop() throws EmptyStackException;

    T top() throws EmptyStackException;

    boolean isEmpty();

    void makeEmpty();
}
