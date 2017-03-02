package com.bigdataguide.adt;

public interface MyStack<E> {

    public boolean isEmpty();

    public void push(E item);

    public E pop();

    public E peek();

    public int size();

}
