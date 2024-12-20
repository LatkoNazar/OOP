package org.example.Functions;

import java.util.Scanner;

public class InputUtils {
    private final static Scanner scanner = new Scanner(System.in);

    public static int readInt(String prompt) {
        int value;
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                value = scanner.nextInt();
                scanner.nextLine();
                return value;
            } else {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.nextLine();
            }
        }
    }
}