package org.example;

import java.text.ParseException;
import java.util.Stack;

public class MyRPNParser implements RPNParser {

    private MyStack stack; // Utilisation de MyStack

    // Constructeur par défaut
    public MyRPNParser() {
        this.stack = new MyStack(); // Instanciation de MyStack
    }

    @Override
    public double parseAndDisplayResult(String toParse) throws NotEnoughOperandsOnStackException, DivideByZeroException, ParseException {
        String[] tokens = toParse.split(" ");

        for (String token : tokens) {
            try {
                // Si le token est un nombre, on le met dans la pile
                double value = Double.parseDouble(token);
                stack.push(value); // Utilisation de la méthode push() de MyStack
            } catch (NumberFormatException e) {
                // Si ce n'est pas un nombre, c'est une opération
                if (stack.getSize() < 2) {
                    throw new NotEnoughOperandsOnStackException("Pas assez d'opérandes pour effectuer l'opération.");
                }
                double b = stack.pop(); // Récupérer le dernier élément
                double a = stack.pop(); // Récupérer l'avant-dernier élément

                switch (token) {
                    case "+":
                        stack.push(a + b); // Addition
                        break;
                    case "-":
                        stack.push(a - b); // Soustraction
                        break;
                    case "*":
                        stack.push(a * b); // Multiplication
                        break;
                    case "/":
                        if (b == 0) {
                            throw new DivideByZeroException("Division par zéro interdite.");
                        }
                        stack.push(a / b); // Division
                        break;
                    default:
                        throw new ParseException("Opération inconnue : " + token, 0);
                }
            }
        }

        if (stack.getSize() != 1) {
            throw new ParseException("Expression mal formée", 0);
        }

        return stack.pop(); // Retourner le dernier élément de la pile
    }
}

