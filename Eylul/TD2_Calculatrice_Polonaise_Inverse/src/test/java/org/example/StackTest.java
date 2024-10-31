package org.example;


import org.junit.*;

import java.util.EmptyStackException;

import static org.junit.Assert.*;

public class StackTest {

    @Test
    public void testStack() {
        Stack emptyStack = new MyStack();
        assertTrue("The stack isnt empty", emptyStack.isEmpty());

        Stack stack1 = new MyStack();
        Stack stack2 = new MyStack();

        stack1.push(3);
        for(int i=0; i<20 ; i++){
            stack2.push(i);
        }

        assertEquals("The stack size isnt "+emptyStack.getSize(), 0,emptyStack.getSize());
        assertEquals("The stack size isnt "+stack2.getSize(), 20,stack2.getSize());
        assertEquals("The stack size isnt "+stack1.getSize(), 1,stack1.getSize());

        System.out.println("-------- Peek Test ---------");
        double actualPeek2= stack2.peek();
        assertEquals("The peek of the stack doesnt match", 19,actualPeek2,1);
        assertEquals("The peek of the stack doesnt match", 3,stack1.peek(),1);
        assertEquals("The peek of the stack doesnt match", 3,stack1.pop(),1);
        assertThrows(EmptyStackException.class, () -> stack1.peek());

        assertThrows(EmptyStackException.class, () -> emptyStack.peek());
        assertThrows(EmptyStackException.class, () -> emptyStack.pop());

    }
}