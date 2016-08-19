package com.needforcode.linkedlist;


import com.needforcode.adt.MyList;

public class MyLinkedList<E> implements MyList<E>{

    Node head=null;
    int size = 0;

    public E set(int index, E item) {
        if(head == null) {
            head = new Node(item,null);
        } else {
            int position=1;
            Node current = head;
            while(position<index) {
                current = current.next;
            }
            Node temp = current.next;
            current.next = new Node(item,temp);
        }
        size++;
        return item;
    }

    @Override public boolean add(E item) {
        if(head == null) {
            head = new Node(item,null);
        } else {
            Node current = head;
            while(current.next!=null) {
                current = current.next;
            }
            current.next = new Node(item,null);
        }
        size++;
        return true;
    }

    @Override public E get(int index) {
        if(index<-1 && index>size) {
            IOBException(index);
        }
        Node current = head;
        int position=0;
        while(position++ < index) {
            current = current.next;
        }
        return current.item;
    }

    @Override public E remove(int index) {
        if(index<-1 && index>size) {
            IOBException(index);
        }
        Node current = head;
        int position = 1;
        while(position < index) {
            current = current.next;
        }
        E oldValue = current.next.item;
        current.next = current.next.next;
        size--;
        return oldValue;
    }

    @Override public int size() {
        return size;
    }

    @Override public boolean isEmpty() {
        return head == null;
    }

    @Override public int indexOf(E o) {
        if(head == null) {
            return 0;
        }
        Node current = head;
        int position =0;
        while(current.next!=null) {
            if(o==null && current.item==o) {
                return position;
            } else if(o.equals(current.item)) {
                return position;
            }
            position++;
            current = current.next;
        }
        return -1;
    }

    private void IOBException(int index) {
        System.out.println("index out of bounds: " + index);
    }

    class Node {

        E item;
        Node next;

        Node(E item,Node next) {
            this.item=item;
            this.next=next;
        }
    }
}

