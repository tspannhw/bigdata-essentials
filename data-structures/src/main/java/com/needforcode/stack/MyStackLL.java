package com.needforcode.stack;

import com.needforcode.adt.MyStack;
import com.needforcode.exceptions.EmptyStackException;

public class MyStackLL<E> implements MyStack {

    private Node head = null;
    int size=0;


    @Override public boolean isEmpty() {
        return head == null;
    }

    @Override public void push(Object item) {
        Node temp = new Node((E)item);
        if(head == null) {
            head = temp;
        } else {
            temp.next = head;
            head = temp;
        }
        size++;
    }

    @Override public Object pop() {
        Node temp;
        if(head == null) {
            throw new EmptyStackException("stack is empty");
        } else {
            temp = head;
            head = head.next;
        }
        size --;
        return temp.data;
    }

    @Override public Object peek() {
        Node temp;
        if(head == null) {
            throw new EmptyStackException("stack is empty");
        } else {
            temp = head;
        }
        return temp.data;
    }

    @Override public int size() {
        return size;
    }
}

class Node<E> {
    E data;
    Node next;
    Node(E data){
        this.data=data;
    }
}
