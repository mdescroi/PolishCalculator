package org.example;

import org.example.exceptions.DivideByZeroException;
import org.example.exceptions.NotEnoughOperandsOnStackException;

public class MyCalculator implements Calc{
    private Stack myStack;

    public Stack getMyStack() {
        return myStack;
    }

    public MyCalculator(Stack stack) {
        this.myStack = stack;
    }

    public void enterValue(double value) {
        myStack.push(value);
    }

    public void add() throws NotEnoughOperandsOnStackException {
        if(myStack.getSize()<2){
            throw new NotEnoughOperandsOnStackException();
        }else{
            double val1=myStack.pop();
            double val2=myStack.pop();
            double result=val1+val2;
            myStack.push(result);
        }
    }


    public void subtract() throws NotEnoughOperandsOnStackException {
        if(myStack.getSize()<2){
            throw new NotEnoughOperandsOnStackException();
        }else{
            double val1=myStack.pop();
            double val2=myStack.pop();
            double result=val2-val1;
            myStack.push(result);
        }
    }


    public void multiply() throws NotEnoughOperandsOnStackException {
        if(myStack.getSize()<2){
            throw new NotEnoughOperandsOnStackException();
        }else{
            double val1=myStack.pop();
            double val2=myStack.pop();
            double result=val1*val2;
            myStack.push(result);
        }
    }


    public void divide() throws NotEnoughOperandsOnStackException, DivideByZeroException {
        if(myStack.getSize()<2){
            throw new NotEnoughOperandsOnStackException();
        }else{
            double val1=myStack.pop();
            double val2=myStack.pop();

        if(val1 == 0.0) {
            throw new DivideByZeroException();
        }
        double result=val2/val1;
        myStack.push(result);
        }
    }


    public double displayValueOnTop() throws NotEnoughOperandsOnStackException {
        double onTop;
        if(myStack.isEmpty()){
            throw new NotEnoughOperandsOnStackException();
        }else{
            onTop=myStack.peek();
        }
        return onTop;
    }

}
