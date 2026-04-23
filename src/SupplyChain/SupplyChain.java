package SupplyChain;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SupplyChain {
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
        Scanner scanner = new Scanner(System.in);

        try {
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
        } finally {
            scanner.close();
        }
    }
}
