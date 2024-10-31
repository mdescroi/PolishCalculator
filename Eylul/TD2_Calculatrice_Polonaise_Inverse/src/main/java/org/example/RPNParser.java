package org.example;
import org.example.exceptions.DivideByZeroException;
import org.example.exceptions.NotEnoughOperandsOnStackException;
import org.example.exceptions.ParseException;

public interface RPNParser {
    /**
     * parses the string, computing and display the last result
     *
     * @param toParse
     * @return the last result
     */
    double parseAndDisplayResult(String toParse) throws
            NotEnoughOperandsOnStackException, DivideByZeroException, ParseException;
}
