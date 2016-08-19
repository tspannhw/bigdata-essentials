package com.needforcode.adt;

public interface MyQueue<E> {

    public void EnQueue(E item);

    public E DeQueue();

    public int size();

    public boolean isEmpty();
}
