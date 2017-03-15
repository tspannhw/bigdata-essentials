package com.bigdataguide.stack;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MyStackLLTest {

    MyStackLL<String> stack=null;

    @Before
    public void setUp() {
        stack = new MyStackLL<String>();
    }

    @Test public void testIsEmpty() throws Exception {
        assertTrue(stack.isEmpty());
    }

    @Test public void testPush() throws Exception {
        stack.push("A");
        assertEquals(stack.size(),1);
    }

    @Test public void testPop() throws Exception {
        stack.push("A");
        assertEquals(stack.pop(),"A");
        assertEquals(stack.size(),0);
    }

    @Test public void testPeek() throws Exception {
        stack.push("A");
        assertEquals(stack.peek(),"A");
        assertEquals(stack.size(),1);
    }

    @Test public void testSize() throws Exception {
        stack.push("A");
        assertEquals(stack.size(),1);
    }
}
