package org.example;

import org.example.exceptions.DivideByZeroException;
import org.example.exceptions.NotEnoughOperandsOnStackException;
import org.junit.Before;
import org.junit.Test;

import java.util.EmptyStackException;

import static org.junit.Assert.*;

public class MyCalculatorTest {
    private Calc calcStack;
    private Calc calcSubStack;

    @Before
    public void setUp() throws Exception {
        calcStack=new MyCalculator(new MyStack());
        calcSubStack=new MyCalculator(new SubStack());
    }

    @Test
    public void testEnterValue() throws NotEnoughOperandsOnStackException {
        //Verifying if the stacks are empty in the beginning
        assertTrue("Stack used for calculator isn't empty",calcStack.getMyStack().isEmpty());
        assertTrue("SubStack used for calculator isn't empty",calcSubStack.getMyStack().isEmpty());
        calcStack.enterValue(45);
        calcSubStack.enterValue(3);
        assertEquals("The added item to calStack doesn't match",45,calcStack.displayValueOnTop(),1);
        assertEquals("The added item to calSubStack doesn't match",3,calcSubStack.displayValueOnTop(),1);
    }

    @Test
    public void testAdd() throws NotEnoughOperandsOnStackException {
        //Verifying if the stacks are empty in the beginning
        assertTrue("Stack used for calculator isn't empty",calcStack.getMyStack().isEmpty());
        assertTrue("SubStack used for calculator isn't empty",calcSubStack.getMyStack().isEmpty());

        //Current stack is: [45, 30, 5]
        calcStack.enterValue(45);
        calcStack.enterValue(30);
        calcStack.enterValue(5);

        // Verify the top value after addition
        calcStack.add();
        assertEquals("Add of two last numbers doesn't match", 35, calcStack.displayValueOnTop(), 1);

        //Expected new stack should be [45, 35] after add
        Stack expected=new MyStack();
        expected.push(45);
        expected.push(35);
        assertEquals("The modified stack after add doesn't match", expected.getStack(), calcStack.getMyStack().getStack());

        //Current substack is: [45, 30]
        calcSubStack.enterValue(45);
        assertThrows(NotEnoughOperandsOnStackException.class, () -> calcSubStack.add());
        calcSubStack.enterValue(30);

        // Verify the top value after addition
        calcSubStack.add();
        Stack expected2=new SubStack();
        expected2.push(75);
        assertEquals("The modified substack after add doesn't match",expected2.peek(),calcSubStack.displayValueOnTop(),1);
    }

    @Test
    public void testSubtract() throws NotEnoughOperandsOnStackException {
        // Verifying if the stacks are empty in the beginning
        assertTrue("Stack used for calculator isn't empty", calcStack.getMyStack().isEmpty());
        assertTrue("SubStack used for calculator isn't empty", calcSubStack.getMyStack().isEmpty());

        // Test for calcStack: [45, 30]
        calcStack.enterValue(45);
        calcStack.enterValue(30);
        calcStack.subtract();
        assertEquals("Subtract of two last numbers doesn't match", 15, calcStack.displayValueOnTop(), 1);

        // Expected stack should be [15] after subtraction
        Stack expected = new MyStack();
        expected.push(15);
        assertEquals("The modified stack after subtract doesn't match", expected.getStack(), calcStack.getMyStack().getStack());

        // Test for calcSubStack: [20, 5]
        calcSubStack.enterValue(20);
        calcSubStack.enterValue(5);
        calcSubStack.subtract();
        Stack expected2 = new SubStack();
        expected2.push(15);
        assertEquals("The modified substack after subtract doesn't match", expected2.peek(), calcSubStack.displayValueOnTop(), 1);
    }

    @Test
    public void testMultiply() throws NotEnoughOperandsOnStackException {
        // Verifying if the stacks are empty in the beginning
        assertTrue("Stack used for calculator isn't empty", calcStack.getMyStack().isEmpty());
        assertTrue("SubStack used for calculator isn't empty", calcSubStack.getMyStack().isEmpty());

        // Test for calcStack: [10, 5]
        calcStack.enterValue(10);
        calcStack.enterValue(5);
        calcStack.multiply();
        assertEquals("Multiply of two last numbers doesn't match", 50, calcStack.displayValueOnTop(), 1);

        // Expected stack should be [50] after multiplication
        Stack expected = new MyStack();
        expected.push(50);
        assertEquals("The modified stack after multiply doesn't match", expected.getStack(), calcStack.getMyStack().getStack());

        // Test for calcSubStack: [3, 4]
        calcSubStack.enterValue(3);
        calcSubStack.enterValue(4);
        calcSubStack.multiply();
        Stack expected2 = new SubStack();
        expected2.push(12);
        assertEquals("The modified substack after multiply doesn't match", expected2.peek(), calcSubStack.displayValueOnTop(), 1);
    }

    @Test
    public void testDivideTest() throws NotEnoughOperandsOnStackException, DivideByZeroException {
        // Verifying if the stacks are empty in the beginning
        assertTrue("Stack used for calculator isn't empty", calcStack.getMyStack().isEmpty());
        assertTrue("SubStack used for calculator isn't empty", calcSubStack.getMyStack().isEmpty());

        // Test for calcStack: [100, 5]
        calcStack.enterValue(100);
        calcStack.enterValue(5);
        calcStack.divide();
        assertEquals("Division of two last numbers doesn't match", 20, calcStack.displayValueOnTop(), 1);

        // Expected stack should be [20] after division
        Stack expected = new MyStack();
        expected.push(20);
        assertEquals("The modified stack after divide doesn't match", expected.getStack(), calcStack.getMyStack().getStack());

        // Test for calcSubStack: [30, 6]
        calcSubStack.enterValue(30);
        calcSubStack.enterValue(6);
        calcSubStack.divide();
        Stack expected2 = new SubStack();
        expected2.push(5);
        assertEquals("The modified substack after divide doesn't match", expected2.peek(), calcSubStack.displayValueOnTop(), 1);
    }

    @Test
    public void testDisplayValueOnTop() throws NotEnoughOperandsOnStackException {
        //Verifying if the exception for empty stacks functions as expected
        assertThrows("The stack isn't empty", NotEnoughOperandsOnStackException.class, () -> calcStack.displayValueOnTop());
        assertThrows("The stack isn't empty",NotEnoughOperandsOnStackException.class, () -> calcSubStack.displayValueOnTop());

        calcStack.enterValue(5);
        assertEquals("The peek of the stack doesn't match",5,calcStack.displayValueOnTop(),1);

        calcSubStack.enterValue(23);
        assertEquals("The peek of the stack doesn't match",23,calcSubStack.displayValueOnTop(),1);
    }
}