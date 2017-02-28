package com.bigdataguide.linkedlist;

public class MyLinkedListDouble<E> implements MyList<E> {

  Node head = null;
  Node tail = null;
  int size = 0;

  @Override
  public E set(int index, E item) {
    if(index > size) {
      throw new IndexOutOfBoundsException("index out of range");
    }
    if(head == null) {
      head = new Node(item,null);
      tail = head;
    } else {
      int counter = 1;
      Node current = head;
      while (counter++ < index) {
        current = current.next;
      }
      current.next = new Node(item,current);
      tail = current.next;
    }
    size++;
    return item;
  }

  @Override
  public boolean add(E item) {
    if(head == null) {
      head = tail = new Node(item,null);
    } else {
      Node current = head;
      while (current.next !=null) {
        current = current.next;
      }
      current.next = new Node(item,current);
      tail = current.next;
    }
    size++;
    return true;
  }

  @Override
  public E get(int index) {
    if(index > size) {
      throw new IndexOutOfBoundsException("index out of range");
    }
    int counter = 1;
    Node current = head;
    while(counter++ < size) {
      current = current.next;
    }
    return (E) current.item;
  }

  @Override
  public E remove(int index) {
    if(index > size) {
      throw new IndexOutOfBoundsException("index out of range");
    }
    if(size == 1) {
      head = tail = null;
    }
    int counter = 1;
    Node current = head;
    Node temp = head;
    while(counter++ < index) {
      temp = current;
      current = current.next;
    }
    E item = (E) current.item;
    if(current.next == null) {
      temp.next = null;
      tail = current;
    } else {
      temp.next = current.next;
    }
    size--;
    return item;
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public boolean isEmpty() {
    return (head == null);
  }

  @Override
  public int indexOf(E o) {
    Node current = head;
    int index = -1;
    while(current != null) {
      if(current.item == o) {
        return index+1;
      }
      index++;
      current = current.next;
    }
    return -1;
  }
}

class Node<E> {
  E item;
  Node prev;
  Node next;
  Node(E item, Node prev) {
    this.item = item;
    this.prev = prev;
  }
}
