package com.bigdataguide.linkedlist;

import com.bigdataguide.adt.MyList;

public class MyLinkedListDouble<E> implements MyList<E> {

    Node head = null;
    Node tail = null;
    int size = 0;

    @Override public E set(int index, E item) {
        if (index > size) {
            throw new IndexOutOfBoundsException("index out of range");
        }
        size++;
        if (head == null) {
            head = new Node(item, null);
            tail = head;
            return item;
        }
        if (index == 0) {
            Node temp = new Node(item, null);
            temp.next = head;
            head.prev = temp;
            head = temp;
            return item;
        }
        int counter = 1;
        Node current = head;
        while (counter++ < index) {
            current = current.next;
        }
        Node temp = current.next;
        current.next = new Node(item, current,temp);
        if(temp==null) {
            tail=current.next;
        }
        return item;
    }

    @Override public boolean add(E item) {
        Node temp = new Node(item, null);
        if (head == null) {
            head = tail = temp;
        } else {
            tail.next = temp;
            tail = temp;
        }
        size++;
        return true;
    }

    @Override public E get(int index) {
        if (index > size) {
            throw new IndexOutOfBoundsException("index out of range");
        }
        int counter = 1;
        Node current = head;
        while (counter++ <= index) {
            current = current.next;
        }
        return (E) current.item;
    }

    @Override public E remove(int index) {
        if (index > size) {
            throw new IndexOutOfBoundsException("index out of range");
        }
        size--;
        if (size == 1) {
            head = tail = null;
        }
        int counter = 1;
        E item = null;
        Node current = head;
        while (counter++ < index) {
            current = current.next;
        }
        if (current.next.next != null) {
            item = (E) current.next.item;
            current.next = current.next.next;
            current.next.prev=current;
        } else {
            item = (E) current.next.item;
            current.next = null;
            tail = current;
        }
        return item;
    }

    @Override public int size() {
        return size;
    }

    @Override public boolean isEmpty() {
        return (head == null);
    }

    @Override public int indexOf(E o) {
        Node current = head;
        int counter = 0;
        if (o == null) {
            while (current != null) {
                if (current.item == null) {
                    return counter;
                } else {
                    counter++;
                    current = current.next;
                }
            }
        } else {
            while(current!=null) {
                if (o.equals(current.item)) {
                    return counter;
                } else {
                    counter++;
                    current = current.next;
                }
            }
        }
        return -1;
    }

    class Node<E> {
        E item;
        Node prev;
        Node next;

        Node(E item, Node next) {
            this.item = item;
            this.next = next;
        }

        Node(E item, Node prev, Node next) {
            this.item=item;
            this.prev=prev;
            this.next=next;
        }
    }
}
