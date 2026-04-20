package SupplyChain;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Product {
    private final int length;
    private final int width;
    private final int height;

    public Scanner scanner = new Scanner(System.in);

    public Product(int length, int width, int height) {
        int area = (int)calculateArea(length, width, height);

        if (sizeCheck(area)) {
            System.out.println("Area of package ordered: " + area);

            this.length = length;
            this.width = width;
            this.height = height;
        } else {
            //TODO Create custom exception
            // Dependency injection
            throw new IllegalArgumentException("Size doesn't exist for product package");
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

    public boolean sizeCheck(int area) {
        if (area > 300) {
            return false;
        }
        else if (area > 250) {
            System.out.println("Size of product package is Extra Large");
            return true;
        }
        else if (area > 200) {
            System.out.println("Size of product package is Large");
            return true;
        }
        else if (area > 150) {
            System.out.println("Size of product package is Medium");
            return true;
        }
        else if (area > 100) {
            System.out.println("Size of product package is Small");
            return true;
        }
        else if (area > 50) {
            System.out.println("Size of product package is Extra Small");
            return true;
        }
        else {
            return false;
        }
    }

    public String printProductDetails() {
        try {
            System.out.print("Length: ");
            double a = scanner.nextDouble();

            System.out.print("Width: ");
            double b = scanner.nextDouble();

            System.out.print("Height: ");
            double c = scanner.nextDouble();

            double area = Product.calculateArea(a, b, c);
            System.out.println("Area of package orderd: " + area);

            // Dimensions.printSize(area);

        } catch (InputMismatchException e) {
            System.out.println("Invalid Input");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
        return "okay";
    }
}