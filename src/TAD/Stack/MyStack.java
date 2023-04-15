package TAD.Stack;

import TAD.LinkedList.Nodo;

import java.util.EmptyStackException;

public interface MyStack<T> {

    void push(T element);

    Nodo<T> pop() throws EmptyStackException;

    Nodo<T> top() throws EmptyStackException;

    boolean isEmpty();

    void makeEmpty();
}
