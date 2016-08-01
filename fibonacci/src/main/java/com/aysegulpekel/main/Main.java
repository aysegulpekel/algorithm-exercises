package com.aysegulpekel.main;

import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Fibonacci fibonacci = new Fibonacci();
        Scanner numberScanner = new Scanner(System.in);

        System.out.print("Please enter an integer number to see its Fibonacci value: ");

        while (!numberScanner.hasNextInt()) {
            System.out.print("You entered something is not an integer, please try again: ");
            numberScanner.next();
        }

        int givenNumber = numberScanner.nextInt();

        if (givenNumber >= 47 || givenNumber < 0) {
            System.out.println("This program can only compute the numbers between 0 and 47, " +
                    "since it just computes positive numbers with int32 size");
            return;
        }

        System.out.println("Fibonacci result of your number calculated by different methods:\n"
                + "Iterative method:\t" + fibonacci.calculateIteratively(givenNumber) + "\n"
                + "Recursive method:\t" + fibonacci.calculateRecursively(givenNumber) + "\n"
                + "Binet's formula:\t" + fibonacci.calculateWithBinet(givenNumber) + "\n");
    }
}