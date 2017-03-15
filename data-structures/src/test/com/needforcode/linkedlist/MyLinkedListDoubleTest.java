package com.needforcode.linkedlist;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class MyLinkedListDoubleTest {

  MyLinkedListDouble values = null;

  @Before public void setUp() throws Exception {
    values = new MyLinkedListDouble();
  }

  @Test public void testSet() throws Exception {
    values.set(0,1);
    values.set(1,2);
    assertEquals("size must be 2", 2, values.size());
    assertEquals("2nd element should be 2", 2, values.get(1));
    values.set(0,3);
    assertEquals("3rd element should be 2", 2, values.get(2));
  }

  @Test public void testAdd() throws Exception {
    values.add(1);
    values.add(2);
    values.add(3);
    values.add(4);
    assertEquals("size must be 4", 4, values.size());
    assertEquals("4th element should be 4", 4, values.get(3));
    assertEquals("tail",4,values.tail.item);
    assertEquals("head",1,values.head.item);
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
    assertEquals("tail",4,values.tail.item);
    values.remove(2);
    assertEquals("tail",3,values.tail.item);
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
