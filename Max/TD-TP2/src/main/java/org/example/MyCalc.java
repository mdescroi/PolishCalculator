package org.example;

public class MyCalc implements Calc {

    private Stack stack;

    // Constructeur qui initialise la pile
    public MyCalc(MyStack stack) {
        this.stack = stack;
    }

    // Constructeur par défaut
    public MyCalc() {
        this.stack = new MyStack();
    }

    public MyCalc(SubStack subStack) {
        this.stack = new SubStack();
    }

    /**
     * Ajoute une valeur sur la pile (NPI).
     */
    @Override
    public void enterValue(double value) {
        stack.push(value); // Utilisation de la méthode push() de MyStack
    }

    /**
     * Additionne les deux dernières valeurs et les remplace par le résultat.
     */
    @Override
    public void add() throws NotEnoughOperandsOnStackException {
        if (stack.getSize() < 2) {
            throw new NotEnoughOperandsOnStackException("Pas assez d'opérandes sur la pile pour effectuer une addition.");
        }
        double b = stack.pop(); // Dernier élément
        double a = stack.pop(); // Avant-dernier élément
        stack.push(a + b); // Ajouter le résultat
    }

    /**
     * Soustrait les deux dernières valeurs et les remplace par le résultat.
     */
    @Override
    public void subtract() throws NotEnoughOperandsOnStackException {
        if (stack.getSize() < 2) {
            throw new NotEnoughOperandsOnStackException("Pas assez d'opérandes sur la pile pour effectuer une soustraction.");
        }
        double b = stack.pop(); // Dernier élément
        double a = stack.pop(); // Avant-dernier élément
        stack.push(a - b); // Ajouter le résultat
    }

    /**
     * Multiplie les deux dernières valeurs et les remplace par le résultat.
     */
    @Override
    public void multiply() throws NotEnoughOperandsOnStackException {
        if (stack.getSize() < 2) {
            throw new NotEnoughOperandsOnStackException("Pas assez d'opérandes sur la pile pour effectuer une multiplication.");
        }
        double b = stack.pop(); // Dernier élément
        double a = stack.pop(); // Avant-dernier élément
        stack.push(a * b); // Ajouter le résultat
    }

    /**
     * Divise les deux dernières valeurs et les remplace par le résultat.
     */
    @Override
    public void divide() throws NotEnoughOperandsOnStackException, DivideByZeroException {
        if (stack.getSize() < 2) {
            throw new NotEnoughOperandsOnStackException("Pas assez d'opérandes sur la pile pour effectuer une division.");
        }
        double b = stack.pop(); // Dernier élément (diviseur)
        if (b == 0) {
            throw new DivideByZeroException("Division par zéro impossible.");
        }
        double a = stack.pop(); // Avant-dernier élément (dividende)
        stack.push(a / b); // Ajouter le résultat
    }

    /**
     * Affiche la valeur au sommet de la pile.
     */
    @Override
    public double displayValueOnTop() throws NotEnoughOperandsOnStackException {
        if (stack.isEmpty()) {
            throw new NotEnoughOperandsOnStackException("Pas assez d'opérandes sur la pile.");
        }
        return stack.peek(); // Utilisation de peek() pour afficher sans retirer l'élément
    }
}
