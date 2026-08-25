package main;
public class Main {

    public static void main(String[] args) {

        // Primitive data types
        int age = 18;
        double gpa = 8.5;

        // Wrapper classes
        Integer ageObj = Integer.valueOf(age);
        Double gpaObj = Double.valueOf(gpa);

        // Display primitive values
        System.out.println("=== PRIMITIVE TYPES ===");
        System.out.println("Age: " + age);
        System.out.println("GPA: " + gpa);

        // Display wrapper objects
        System.out.println("\n=== WRAPPER OBJECTS ===");
        System.out.println("Age Object: " + ageObj);
        System.out.println("GPA Object: " + gpaObj);

        // Using wrapper class constants
        System.out.println("\n=== CONSTANTS ===");
        System.out.println("Integer MAX VALUE: " + Integer.MAX_VALUE);
        System.out.println("Integer MIN VALUE: " + Integer.MIN_VALUE);

        // Convert String to Number
        String scoreText = "95";

        Integer score = Integer.valueOf(scoreText);

        System.out.println("\n=== STRING TO NUMBER ===");
        System.out.println("Score: " + score);

        // Convert Number to other primitive types
        double scoreDouble = score.doubleValue();

        System.out.println("\n=== TYPE CONVERSION ===");
        System.out.println("Score as double: " + scoreDouble);

        // Example method using Number object
        printNumber(ageObj);
        printNumber(gpaObj);
    }

    // Method using Number object
    public static void printNumber(Number n) {

        System.out.println("\nPrinting Number Object: " + n);
    }
}