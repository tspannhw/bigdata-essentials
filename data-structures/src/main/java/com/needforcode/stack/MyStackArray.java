package com.needforcode.stack;

import com.needforcode.adt.MyStack;
import com.needforcode.exceptions.EmptyStackException;

class MyStackArray<E> implements MyStack<E> {

    private E[] stack = null;
    private int top = -1;

    MyStackArray() {
        stack = (E[]) new Object[10];
    }

    @Override public boolean isEmpty() {
        return top == -1;
    }

    @Override public void push(E item) {
        if(++top < stack.length) {
            stack[top]=item;
        }
    }

    @Override public E pop() {
       if(top==-1) {
           throw new EmptyStackException("stack is empty");
       }
       E temp = stack[top];
       stack[top--]=null;
       return temp;
    }

    @Override public E peek() {
        if(top==-1) {
            throw new EmptyStackException("stack is empty");
        }
            return stack[top];
    }

    @Override public int size() {
        return top+1;
    }
}
