package com.bigdataguide.arraylist;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class MyArrayListTest {

    MyArrayList values = null;

    @Before public void setUp() throws Exception {
        values = new MyArrayList(8);
    }

    @Test public void testSet() throws Exception {
        values.add(1);
        values.add(2);
        assertEquals("size must be 2", 2, values.size());
        assertEquals("2nd element should be 2", 2, values.get(1));
    }

    @Test public void testAdd() throws Exception {
        values.add(1);
        values.add(2);
        values.add(3);
        values.add(4);
        assertEquals("size must be 4", 4, values.size());
        assertEquals("4th element should be 4", 4, values.get(3));
    }

    @Test public void testGet() throws Exception {
        values.add(1);
        values.add(2);
        values.add(3);
        values.add(4);
        assertEquals("4th element should be 4", 4, values.get(3));
    }

    @Test public void testRemove() throws Exception {
        values.add(1);
        values.add(2);
        values.add(3);
        values.add(4);
        values.remove(1);
        assertEquals("size must be 4", 3, values.size());
        assertEquals("2nd element should be 3", 3, values.get(1));
    }

    @Test public void testSize() throws Exception {
        values.add(1);
        assertEquals("size must be 1", 1, values.size());
    }

    @Test public void testIndexOf() throws Exception {
        values.add(1);
        values.add(2);
        values.add(3);
        values.add(4);
        assertEquals("index of 2", 1, values.indexOf(2));
        assertEquals("index of 5", -1, values.indexOf(5));
    }
}
