package org.example;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyCalcTest {

    private MyCalc calc;

    // Initialisation avant chaque test
    @Before
    public void setUp() {
        calc = new MyCalc(); // Instanciation de la classe MyCalc
    }

    // Test pour vérifier que la pile est initialement vide
    @Test
    public void testEnterValue_InitialPileVide() {
        try {
            calc.displayValueOnTop();
            fail("Une exception devrait être levée car la pile est vide.");
        } catch (NotEnoughOperandsOnStackException e) {
            // Test réussi
        }
    }

    // Test pour ajouter une valeur dans la pile et vérifier l'affichage
    @Test
    public void testEnterValue() throws NotEnoughOperandsOnStackException {
        calc.enterValue(5.0);
        assertEquals("La valeur au sommet de la pile devrait être 5.0", 5.0, calc.displayValueOnTop(), 0.0);
    }

    // Test pour vérifier l'addition
    @Test
    public void testAdd() throws NotEnoughOperandsOnStackException {
        calc.enterValue(2.0);
        calc.enterValue(3.0);
        calc.add();
        assertEquals("Le résultat de l'addition devrait être 5.0", 5.0, calc.displayValueOnTop(), 0.0);
    }

    // Test pour vérifier la soustraction
    @Test
    public void testSubtract() throws NotEnoughOperandsOnStackException {
        calc.enterValue(5.0);
        calc.enterValue(3.0);
        calc.subtract();
        assertEquals("Le résultat de la soustraction devrait être 2.0", 2.0, calc.displayValueOnTop(), 0.0);
    }

    // Test pour vérifier la multiplication
    @Test
    public void testMultiply() throws NotEnoughOperandsOnStackException {
        calc.enterValue(2.0);
        calc.enterValue(4.0);
        calc.multiply();
        assertEquals("Le résultat de la multiplication devrait être 8.0", 8.0, calc.displayValueOnTop(), 0.0);
    }

    // Test pour vérifier la division
    @Test
    public void testDivide() throws NotEnoughOperandsOnStackException, DivideByZeroException {
        calc.enterValue(10.0);
        calc.enterValue(2.0);
        calc.divide();
        assertEquals("Le résultat de la division devrait être 5.0", 5.0, calc.displayValueOnTop(), 0.0);
    }

    // Test pour la division par zéro
    @Test(expected = DivideByZeroException.class)
    public void testDivideByZero() throws NotEnoughOperandsOnStackException, DivideByZeroException {
        calc.enterValue(10.0);
        calc.enterValue(0.0);
        calc.divide(); // Devrait lancer une exception DivideByZeroException
    }

    // Test pour l'addition avec un nombre insuffisant d'opérandes
    @Test(expected = NotEnoughOperandsOnStackException.class)
    public void testAddWithNotEnoughOperands() throws NotEnoughOperandsOnStackException {
        calc.enterValue(5.0);
        calc.add(); // Devrait lancer une exception NotEnoughOperandsOnStackException
    }

    // Test pour la soustraction avec un nombre insuffisant d'opérandes
    @Test(expected = NotEnoughOperandsOnStackException.class)
    public void testSubtractWithNotEnoughOperands() throws NotEnoughOperandsOnStackException {
        calc.enterValue(5.0);
        calc.subtract(); // Devrait lancer une exception NotEnoughOperandsOnStackException
    }

    // Test pour la multiplication avec un nombre insuffisant d'opérandes
    @Test(expected = NotEnoughOperandsOnStackException.class)
    public void testMultiplyWithNotEnoughOperands() throws NotEnoughOperandsOnStackException {
        calc.enterValue(5.0);
        calc.multiply(); // Devrait lancer une exception NotEnoughOperandsOnStackException
    }

    // Test pour la division avec un nombre insuffisant d'opérandes
    @Test(expected = NotEnoughOperandsOnStackException.class)
    public void testDivideWithNotEnoughOperands() throws NotEnoughOperandsOnStackException, DivideByZeroException {
        calc.enterValue(5.0);
        calc.divide(); // Devrait lancer une exception NotEnoughOperandsOnStackException
    }
}
