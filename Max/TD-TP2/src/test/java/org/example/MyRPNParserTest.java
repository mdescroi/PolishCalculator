package org.example;

import org.junit.Test;
import org.junit.*;

import java.text.ParseException;

import static org.junit.Assert.*;

public class MyRPNParserTest {

    private RPNParser parser;

    // Initialisation avant chaque test
    @Before
    public void setUp() {
        parser = new MyRPNParser(); // Utilisation de l'implémentation MyRPNParser
    }

    @Test
    public void testParseAndDisplayResult_MultiplicationAndAddition() throws Exception {
        String expression = "3 5 2 * +";
        double result = parser.parseAndDisplayResult(expression);
        assertEquals(13.0, result, 0.0);
    }

    // Test pour l'expression "10 20 -"
    @Test
    public void testParseAndDisplayResult_Subtraction() throws Exception {
        String expression = "10 20 -";
        double result = parser.parseAndDisplayResult(expression);
        assertEquals(-10.0, result, 0.0);
    }

    // Test pour l'expression "10 20 /"
    @Test
    public void testParseAndDisplayResult_Division() throws Exception {
        String expression = "10 20 /";
        double result = parser.parseAndDisplayResult(expression);
        assertEquals(0.5, result, 0.0);
    }

    // Test pour l'expression "1 1 1 1 + + +"
    @Test
    public void testParseAndDisplayResult_AdditionMultiple() throws Exception {
        String expression = "1 1 1 1 + + +";
        double result = parser.parseAndDisplayResult(expression);
        assertEquals(4.0, result, 0.0);
    }

    // Test pour une exception lors de l'utilisation d'une opération inconnue
    @Test(expected = ParseException.class)
    public void testParseAndDisplayResult_InvalidOperation() throws Exception {
        String expression = "3 5 &";
        parser.parseAndDisplayResult(expression); // Devrait lever une ParseException
    }

    // Test pour une exception lors d'une division par zéro
    @Test(expected = DivideByZeroException.class)
    public void testParseAndDisplayResult_DivideByZero() throws Exception {
        String expression = "10 0 /";
        parser.parseAndDisplayResult(expression); // Devrait lever une DivideByZeroException
    }

    // Test pour vérifier une exception lorsqu'il n'y a pas assez d'opérandes
    @Test(expected = NotEnoughOperandsOnStackException.class)
    public void testParseAndDisplayResult_NotEnoughOperands() throws Exception {
        String expression = "5 +";
        parser.parseAndDisplayResult(expression); // Devrait lever NotEnoughOperandsOnStackException
    }
}