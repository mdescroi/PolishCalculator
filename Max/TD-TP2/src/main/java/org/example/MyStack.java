package org.example;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class MyStack implements Stack {
    private ArrayList<Double> elements;

    // Constructeur par défaut
    public MyStack() {
        elements = new ArrayList<>();
    }

    /**
     * Tests if this stack is empty.
     */
    @Override
    public boolean isEmpty() {
        return elements.isEmpty();
    }

    /**
     * Returns the number of items in this stack.
     */
    @Override
    public int getSize() {
        return elements.size();
    }

    /**
     * Adds a new item on top of the stack.
     */
    @Override
    public void push(double item) {
        elements.add(item); // Ajoute l'élément en haut de la pile
    }

    /**
     * Looks at the object at the top of this stack without removing it.
     * @throws EmptyStackException if this stack is empty.
     */
    @Override
    public double peek() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException(); // Lever une exception si la pile est vide
        }
        return elements.get(elements.size() - 1); // Retourner l'élément au sommet sans le retirer
    }

    /**
     * Removes the object at the top of this stack and returns it.
     * @throws EmptyStackException if this stack is empty.
     */
    @Override
    public double pop() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException(); // Lever une exception si la pile est vide
        }
        return elements.remove(elements.size() - 1); // Retirer et retourner l'élément au sommet
    }
}
