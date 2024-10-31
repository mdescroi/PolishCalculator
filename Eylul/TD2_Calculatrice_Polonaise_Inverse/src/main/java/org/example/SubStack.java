package org.example;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

public class SubStack implements Stack{
    private int nbVal = 0;
    private double val1 = -1;
    private double val2 = -1;

    @Override
    public boolean isEmpty() {
        return nbVal==0;
    }

    @Override
    public int getSize() {
        return nbVal ;
    }

    @Override
    public void push(double item) {
        switch(nbVal) {
        case 0:
            val1 = item;
            nbVal=1;
            break;
        case 1:
            val2 = val1;
            val1 = item;
            nbVal=2;
            break; }
    }

    @Override
    public double peek() throws EmptyStackException {
        switch(nbVal) {
            case 0:
                throw new EmptyStackException();
            case 1:
                return val1;
            case 2:
                return val1;
            default:
                throw new IllegalStateException("Invalid stack size");
        }
    }


    @Override
    public double pop() throws EmptyStackException {
        switch (nbVal) {
            case 0:
                throw new EmptyStackException();
            case 1:
                double temp1 = val1;
                val1 = -1;
                nbVal = 0;
                return temp1;
            case 2:
                double temp2 = val1;
                val1 = val2;
                val2 = -1;
                nbVal = 1;
                return temp2;
            default:
                throw new IllegalStateException("Invalid stack size");
        }
    }

    @Override
    public List<Double> getStack() {
        List<Double> stackContents = new ArrayList<>();
        if (nbVal >= 1) stackContents.add(val1);
        if (nbVal == 2) stackContents.add(val2);
        return stackContents;
    }
}
