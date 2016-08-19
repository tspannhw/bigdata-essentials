package com.needforcode.queue;

import com.needforcode.adt.MyQueue;
import com.needforcode.exceptions.EmptyQueueException;

public class MyQueueSinglyLL<E> implements MyQueue<E>{

    Node head = null;
    Node tail = null;
    int size=0;


    @Override public void EnQueue(E item) {
        Node temp = new Node(item);
        if(head == null) {
            tail = temp;
            head = tail;
        } else {
            tail.next = temp;
            tail = tail.next;
        }
        size++;
    }

    @Override public E DeQueue() {
        if(head == null) {
            throw new EmptyQueueException("queue is empty");
        }
            Node temp = head;
            head = head.next;
        size --;
        return (E) temp.data;
    }

    @Override public int size() {
        return size;
    }

    @Override public boolean isEmpty() {
        return (head == null);
    }
}

class Node<E> {
    E data;
    Node next;
    Node(E item) {
        this.data = item;
    }

}
