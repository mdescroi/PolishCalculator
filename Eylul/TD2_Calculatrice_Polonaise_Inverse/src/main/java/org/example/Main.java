package org.example;

import org.example.exceptions.DivideByZeroException;
import org.example.exceptions.NotEnoughOperandsOnStackException;
import org.example.exceptions.ParseException;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws DivideByZeroException, NotEnoughOperandsOnStackException {
        MyRPNParser rpnParser=new MyRPNParser();

        System.out.println("RPN Calc");
        System.out.println("Type '.exit' at any time to quit");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input a RPN expression");
        System.out.print("-> ");
        String inputString = scanner.nextLine();

        if(inputString.equals(".exit")){
            System.out.println("Are you sure you want to quit ? Y/N");
            inputString=scanner.nextLine();
            if(inputString.contains("Y")){
                System.out.println("Input a RPN expression");
                System.out.println("-> ");
                inputString=scanner.nextLine();
            }
        }

        while(!inputString.equals(".exit")){
            try {
                double result = rpnParser.parseAndDisplayResult(inputString);
                System.out.println(result);
            } catch (NotEnoughOperandsOnStackException e) {
                System.out.println("Not enough operands, Try again or type '.exit' to quit");
            } catch (DivideByZeroException e) {
                System.out.println("Divide by zero, Try again or type '.exit' to quit");
            } catch (ParseException e) {
                System.out.println("Invalid Expression, Try again or type '.exit' to quit");
            }
            System.out.println("Input a RPN expression");
            System.out.print("-> ");
            inputString = scanner.nextLine();
        }
    }
}