package org.example;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyCalcTestSubStack {

    private MyCalc calc;

    @Before
    public void setUp() {
        calc = new MyCalc(new SubStack());
    }

    @Test
    public void testEnterValue() throws NotEnoughOperandsOnStackException {
        calc.enterValue(5.0);
        assertEquals("La valeur au sommet de la pile devrait être 5.0", 5.0, calc.displayValueOnTop(), 0.0);
    }

    @Test
    public void testAdd() throws NotEnoughOperandsOnStackException {
        calc.enterValue(2.0);
        calc.enterValue(3.0);
        calc.add();
        assertEquals(5.0, calc.displayValueOnTop(), 0.0);
    }

    // Test pour soustraire deux valeurs
    @Test
    public void testSubtract() throws NotEnoughOperandsOnStackException {
        calc.enterValue(5.0);
        calc.enterValue(3.0);
        calc.subtract();
        assertEquals(2.0, calc.displayValueOnTop(), 0.0);
    }

    @Test
    public void testMultiply() throws NotEnoughOperandsOnStackException {
        calc.enterValue(2.0);
        calc.enterValue(4.0);
        calc.multiply();
        assertEquals(8.0, calc.displayValueOnTop(), 0.0);
    }

    @Test
    public void testDivide() throws NotEnoughOperandsOnStackException, DivideByZeroException {
        calc.enterValue(10.0);
        calc.enterValue(2.0);
        calc.divide();
        assertEquals(5.0, calc.displayValueOnTop(), 0.0);
    }

    @Test(expected = DivideByZeroException.class)
    public void testDivideByZero() throws NotEnoughOperandsOnStackException, DivideByZeroException {
        calc.enterValue(10.0);
        calc.enterValue(0.0);
        calc.divide(); // Devrait lever une exception DivideByZeroException
    }

    @Test(expected = NotEnoughOperandsOnStackException.class)
    public void testAddNotEnoughOperands() throws NotEnoughOperandsOnStackException {
        calc.enterValue(5.0);
        calc.add(); // Devrait lever une exception NotEnoughOperandsOnStackException
    }
}