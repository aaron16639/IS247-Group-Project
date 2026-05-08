package SupplyChain;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SupplyChain {
    private static final Scanner scanner = new Scanner(System.in);

    public static void start() {
        int choice = -1;
        do {
            System.out.println("\nSupply Chain Menu:");
            System.out.println("1. Calculate Package Size");
            System.out.println("0. Return to Main Menu");

            try {
                choice = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
                continue;
            }

            switch (choice) {
                case 1 -> calculatePackageSize();
                case 0 -> System.out.println("Returning to main menu...");
                default -> System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
    }

    private static void calculatePackageSize() {
        try {
            System.out.print("Length: ");
            double a = Double.parseDouble(scanner.nextLine().trim());

            System.out.print("Width: ");
            double b = Double.parseDouble(scanner.nextLine().trim());

            System.out.print("Height: ");
            double c = Double.parseDouble(scanner.nextLine().trim());

            double area = SupplyChain.calculateArea(a, b, c);
            System.out.println("Volume of package ordered: " + area);

            Dimensions.printSize(area);

        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static <T extends Number> double calculateArea(T a, T b, T c) {
        double length = a.doubleValue();
        double width = b.doubleValue();
        double height = c.doubleValue();

        if (length <= 0 || width <= 0 || height <= 0) {
            throw new IllegalArgumentException("Dimensions must be greater than zero.");
        }
        return length * width * height;
    }
}

class Dimensions {

    public static void printSize(double area) {
        if (area > 300 || area <= 50) {
            throw new IllegalArgumentException("Size doesn't exist for product package");
        } else if (area > 250) {
            System.out.println("Size of product package is Extra Large");
        } else if (area > 200) {
            System.out.println("Size of product package is Large");
        } else if (area > 150) {
            System.out.println("Size of product package is Medium");
        } else if (area > 100) {
            System.out.println("Size of product package is Small");
        } else if (area > 50) {
            System.out.println("Size of product package is Extra Small");
        } else {
            System.out.println("Size doesn't exist for product package");
        }
    }
}

class MainApp {
    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Length: ");
            double a = scanner.nextDouble();

            System.out.print("Width: ");
            double b = scanner.nextDouble();

            System.out.print("Height: ");
            double c = scanner.nextDouble();

            double area = SupplyChain.calculateArea(a, b, c);
            System.out.println("Area of package orderd: " + area);

            Dimensions.printSize(area);

        } catch (InputMismatchException e) {
            System.out.println("Invalid Input");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
