package com.bigdataguide.stack;

import com.bigdataguide.adt.MyStack;
import com.bigdataguide.exceptions.EmptyStackException;

public class MyStackLL<E> implements MyStack{

    private Node head = null;
    int size=0;


    @Override public boolean isEmpty() {
        return head == null;
    }

    @Override public void push(Object item) {
        if(head == null) {
            head = new Node((E)item);
        } else {
            head.next = new Node((E)item);
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
