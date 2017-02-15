package com.bigdataguide.adt;

public interface MyList<E> {

    public E set(int index, E item);

    public boolean add(E item);

    public E get(int index);

    public E remove(int index);

    public int size();

    public boolean isEmpty();

    public int indexOf(E o);
}
