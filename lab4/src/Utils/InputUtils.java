package Utils;

import java.util.Scanner;

public class InputUtils {
    private static Scanner scanner = new Scanner(System.in);

    public static int readInt(String prompt) {
        int value;
        while (true) {
            System.out.print(prompt); // Вивести підказку
            if (scanner.hasNextInt()) {
                value = scanner.nextInt(); // Зчитати число
                scanner.nextLine(); // Очистити залишки буфера
                return value; // Повернути результат
            } else {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.nextLine(); // Очистити некоректний ввід
            }
        }
    }

    public static String readString(String prompt) {
        String value;
        while (true) {
            System.out.print(prompt); // Вивести підказку
            value = scanner.nextLine(); // Зчитати рядок
            if (!value.isBlank()) { // Перевірити, чи рядок не порожній
                return value;
            } else {
                System.out.println("Invalid input. Please enter a non-empty string.");
            }
        }
    }
}
