package org.example;

import org.example.exceptions.DivideByZeroException;
import org.example.exceptions.NotEnoughOperandsOnStackException;
import org.example.exceptions.ParseException;
import org.junit.*;
import static org.junit.Assert.*;

public class MyRPNParserTest {
    private RPNParser rpnParser;

    @Before
    public void setUp() {
        rpnParser=new MyRPNParser();
    }

    @Test
    public void testParseAndDisplayResult_AddAndMultiply() throws Exception {
        // Test case: "3 5 2 * +" => 13
        double result = rpnParser.parseAndDisplayResult("3 5 2 * +");
        assertEquals("3 5 2 * + should equal 13", 13, result, 0.0001);
    }

    @Test
    public void testParseAndDisplayResult_Subtract() throws Exception {
        // Test case: "10 20 -" => -10
        double result = rpnParser.parseAndDisplayResult("10 20 -");
        assertEquals("10 20 - should equal -10", -10, result, 0.0001);
    }

    @Test
    public void testParseAndDisplayResult_Divide() throws Exception {
        // Test case: "10 20 /" => 0.5
        double result = rpnParser.parseAndDisplayResult("10 20 /");
        assertEquals("10 20 / should equal 0.5", 0.5, result, 0.0001);
    }

    @Test
    public void testParseAndDisplayResult_MultipleAdds() throws Exception {
        // Test case: "1 1 1 1 + + +" => 4
        double result = rpnParser.parseAndDisplayResult("1 1 1 1 + + +");
        assertEquals("1 1 1 1 + + + should equal 4", 4, result, 0.0001);
    }

    @Test(expected = ParseException.class)
    public void testParseAndDisplayResult_InvalidOperation() throws Exception {
        String expression = "3 5 &";
        rpnParser.parseAndDisplayResult(expression);
    }

    @Test(expected = DivideByZeroException.class)
    public void testParseAndDisplayResult_DivideByZero() throws Exception {
        String expression = "10 0 /";
        rpnParser.parseAndDisplayResult(expression);
    }

    @Test(expected = NotEnoughOperandsOnStackException.class)
    public void testParseAndDisplayResult_NotEnoughOperands() throws Exception {
        String expression = "5 +";
        rpnParser.parseAndDisplayResult(expression);
    }
    @Test(expected = ParseException.class)
    public void testParseExceptionWithInvalidCharacters() throws NotEnoughOperandsOnStackException, DivideByZeroException, ParseException {
        rpnParser.parseAndDisplayResult("3 5 @"); // L'usage de '@' devrait lancer une ParseException
    }

}