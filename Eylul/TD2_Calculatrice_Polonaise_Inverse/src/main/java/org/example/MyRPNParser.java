package org.example;

import org.example.exceptions.DivideByZeroException;
import org.example.exceptions.NotEnoughOperandsOnStackException;
import org.example.exceptions.ParseException;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyRPNParser implements RPNParser {
    private MyCalculator calculator=new MyCalculator(new MyStack());

    private boolean isOperator(String operator) {
        return operator.equals("+") || operator.equals("-") || operator.equals("*") || operator.equals("/");
    }

    private boolean isNumber(String number) {
        try {
            Double.parseDouble(number);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @Override
    public double parseAndDisplayResult(String toParse) throws NotEnoughOperandsOnStackException, DivideByZeroException, ParseException {
        List<String> expressionList = Arrays.asList(toParse.split(" "));
        int i = 0;

        while (i<expressionList.size()) {
           String currentElement=expressionList.get(i);
           if(isNumber(currentElement)){
               calculator.enterValue(Double.parseDouble(currentElement));
           }else if(isOperator(currentElement)) {
               switch (currentElement) {
                   case "+":
                       calculator.add();
                       break;
                   case "-":
                       calculator.subtract();
                       break;
                   case "*":
                       calculator.multiply();
                       break;
                   case "/":
                       calculator.divide();
                       break;
               }
           }else{
               throw new ParseException("Expression Invalide");
           }
           i++;
        }
        return calculator.displayValueOnTop() ;
    }
}
