import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

public class NumberOperations {
    public static void main(String[] args) {

        /*
        Set default locale to US for easier reading of float and double numbers
        because in other cases all numbers with 2 digits after comma were with "," and not with "."
        */
        Locale.setDefault(Locale.US);

        // Integer, short, float, double etc are subclasses of Number class so my ArrayList has Number type
        ArrayList<Number> numbers = new ArrayList<>(Arrays.asList(10, 20.5, 30, 40.7, 50, 60.3, 70, 80.1, 90, 100.9));

        // Create numbers of different types
        byte num0 = 127;
        short num1 = 5;
        int num2 = 1000;
        float num3 = 1.0f;
        double num4 = 928.555;
        long num5 = 298;

        // Add num0-num5 numbers to numbers
        numbers.add(num0);
        numbers.add(num1);
        numbers.add(num2);
        numbers.add(num3);
        numbers.add(num4);
        numbers.add(num5);

        // Print out the numbers
        System.out.print("Numbers: " + numbers);

        System.out.println();

        // Print out the integers
        System.out.print("Numbers (Integers): ");
        for (int i = 0; i < numbers.size(); i++) {
            String delimeter = (i != numbers.size() - 1) ? ", " : ".";
            System.out.print((numbers.get(i)).intValue() + delimeter);
        }

        System.out.println();

        // Print out floating point numbers with two digits after comma
        System.out.print("Numbers (Float): ");
        for (int i = 0; i < numbers.size(); i++) {
            String number = String.format("%.2f", numbers.get(i).doubleValue());
            String delimeter = (i != numbers.size() - 1) ? ", " : ".";
            System.out.print((number + delimeter));
        }

        System.out.println();

        // Create list of different types of numbers
        ArrayList<Byte> byteNumbers = new ArrayList<>();
        ArrayList<Short> shortNumbers = new ArrayList<>();
        ArrayList<Integer> integerNumbers = new ArrayList<>();
        ArrayList<Long> longNumbers = new ArrayList<>();
        ArrayList<Float> floatNumbers = new ArrayList<>();
        ArrayList<Double> doubleNumbers = new ArrayList<>();

        distributeNumbers(numbers, byteNumbers, shortNumbers, integerNumbers, longNumbers, floatNumbers, doubleNumbers);

        System.out.println("Byte numbers: " + byteNumbers);
        System.out.println("Short numbers: " + shortNumbers);
        System.out.println("Integer numbers: " + integerNumbers);
        System.out.println("Long numbers: " + longNumbers);
        System.out.println("Float numbers: " + floatNumbers);
        System.out.println("Double numbers: " + doubleNumbers);

        System.out.println("Sum of all numbers squared: " + sumOfSquares(numbers));
    }

    // Method to distribute numbers to different type of ArrayLists (Byte, Short, Integer, Long, Float, Double)
    public static void distributeNumbers(ArrayList<Number> numbers,
                                         ArrayList<Byte> byteNumbers,
                                         ArrayList<Short> shortNumbers,
                                         ArrayList<Integer> integerNumbers,
                                         ArrayList<Long> longNumbers,
                                         ArrayList<Float> floatNumbers,
                                         ArrayList<Double> doubleNumbers) {

        for (Number num : numbers) {
            if (num instanceof Byte) {
                byteNumbers.add((Byte) num);
            } else if (num instanceof Short) {
                shortNumbers.add((Short) num);
            } else if (num instanceof Integer) {
                integerNumbers.add((Integer) num);
            } else if (num instanceof Long) {
                longNumbers.add((Long) num);
            } else if (num instanceof Float) {
                floatNumbers.add((Float) num);
            } else if (num instanceof Double) {
                doubleNumbers.add((Double) num);
            }
        }
    }

    // Sum of all numbers squared
    public static double sumOfSquares(ArrayList<Number> numbers) {
        double sum = 0;
        for (Number number : numbers) {
            double doubleNum = number.doubleValue();
            sum += doubleNum * doubleNum;
        }
        return sum;
    }
}
