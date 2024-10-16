package org.example;

import java.util.EmptyStackException;

public class SubStack implements Stack {

    private int nbVal = 0;
    private double val1 = -1;
    private double val2 = -1;

    @Override
    public void push(double item) {
        switch (nbVal) {
            case 0:
                val1 = item;
                nbVal = 1;
                break;
            case 1:
                val2 = val1;
                val1 = item;
                nbVal = 2;
                break;
            case 2:
                val2 = val1;
                val1 = item;
                break;
        }
    }

    @Override
    public boolean isEmpty() {
        return nbVal == 0;
    }

    @Override
    public int getSize() {
        return nbVal;
    }

    @Override
    public double peek() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return val1;
    }

    @Override
    public double pop() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        double topVal = val1;
        if (nbVal == 2) {
            val1 = val2;
            nbVal = 1;
        } else {
            nbVal = 0;
        }
        return topVal;
    }
}
