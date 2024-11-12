package org.example;

import java.util.Scanner;
import java.util.Stack;

import org.example.exceptions.DivideByZeroException;
import org.example.exceptions.NotEnoughOperandsOnStackException;
import org.example.exceptions.ParseException;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        System.out.println("RPN Calc");
        System.out.println("Type '.exit' at any time to quit");

        Scanner scanner = new Scanner(System.in);
        MyRPNParser parser = new MyRPNParser();  // Utiliser MyRPNParser pour interpréter les expressions

        while (true) {
            System.out.print("Input a RPN expression\n-> ");
            String input = scanner.nextLine().trim();

            // Vérification de la commande de sortie
            if (input.equals(".exit")) {
                System.out.println("Exiting...");
                break;
            }

            try {
                // Traitement de l'expression RPN et affichage du résultat
                double result = parser.parseAndDisplayResult(input);
                System.out.println(result);
            } catch (DivideByZeroException e) {
                System.out.println("Divide by zero, Try again or type '.exit' to quit");
            } catch (NotEnoughOperandsOnStackException e) {
                System.out.println("Not enough operands, Try again or type '.exit' to quit");
            } catch (ParseException e) {
                System.out.println("Invalid Expression, Try again or type '.exit' to quit");
            }
        }

        scanner.close();
    }
}