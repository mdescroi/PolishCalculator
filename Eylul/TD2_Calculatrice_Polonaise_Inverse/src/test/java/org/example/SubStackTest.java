package org.example;

import org.junit.Test;

import static org.junit.Assert.*;

public class SubStackTest {

    @Test
    public void testSubStack() {
        Stack stack=new SubStack();
        assertTrue("Stack isnt empty", stack.isEmpty());
        stack.push(2);
        stack.push(3);
        assertEquals("The peek doesnt match",3,stack.peek(),1);
        double expectedPeek= stack.pop();
        assertEquals("The peek doesnt match",2,stack.peek(),1);
        assertEquals("Stack isnt empty", 1,stack.getSize());
    }

    }
