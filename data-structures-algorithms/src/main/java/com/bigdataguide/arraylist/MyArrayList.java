package com.bigdataguide.arraylist;

import com.bigdataguide.adt.MyList;

public class MyArrayList<E> implements MyList<E> {

    E[] values;
    private int size;

    // default constructor
    public MyArrayList() {
        this.values = (E[]) new Object[10];
    }

    // parameterize constructor
    public MyArrayList(int n) {
        this.values = (E[]) new Object[n];
    }

    @Override public E set(int index, E item) {
        IOBCheck(index);

        E oldValue = get(index);
        values[index] = item;
        this.size++;
        return oldValue;
    }

    @Override public boolean add(E item) {
        if (this.size < values.length) {
            values[size++] = item;
            return true;
        } else {
            resizeArray();
            values[size++] = item;
        }
        return false;
    }

    @Override public E get(int index) {
        IOBCheck(index);
        return values[index];
    }

    @Override public E remove(int index) {
        IOBCheck(index);
        E oldValue = values[index];
        for (int i = index; i + 1 < values.length; i++) {
            values[i] = values[i + 1];
        }
        values[--size] = null;
        return oldValue;
    }

    @Override public int size() {
        return this.size;
    }

    @Override public boolean isEmpty() {
        return 0 == this.size;
    }

    @Override public int indexOf(E o) {
        if (null == o) {
            for (int i = 0; i < values.length; i++) {
                if (values[i] == o) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < values.length; i++) {
                if (o.equals(values[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    private void IOBCheck(int index) {
        if (index > this.size) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
    }

    private void resizeArray() {
        E[] newArray = (E[]) new Object[values.length * 2]; // double the array

        // copy the elements to new array
        for (int i = 0; i < values.length; i++) {
            newArray[i] = values[i];
        }
        this.values = newArray;
    }
}
