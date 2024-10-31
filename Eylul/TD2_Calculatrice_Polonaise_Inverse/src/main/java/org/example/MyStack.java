package org.example;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

public class MyStack implements Stack{
    private List<Double> stack;

    public List<Double> getStack() {
        return stack;
    }

    public MyStack() {
        this.stack = new ArrayList<>();
    }

    public boolean isEmpty() {
        return getSize()==0;
    }


    public int getSize() {
        return stack.size();
    }


    public void push(double item) {
        stack.add(item);
    }


    public double peek() throws EmptyStackException {
        double peek;
        if(isEmpty()){
            throw new EmptyStackException();
        }else{
            peek=stack.getLast();
        }
        return peek;
    }

    public double pop() throws EmptyStackException {
        double peek;
        if(isEmpty()){
            throw new EmptyStackException();
        }else{
            peek=stack.removeLast();
        }
        return peek;
    }
}
