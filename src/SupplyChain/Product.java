package SupplyChain;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Product {
    private final int length;
    private final int width;
    private final int height;

    public Product(int length, int width, int height) {
        int area = (int)calculateArea(length, width, height);

        boolean valid = sizeCheck(area);

        if (valid) {
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

    public static boolean sizeCheck(int area) {
        if (area > 300) {
            return false;
        }
        else if (area > 250) {
            System.out.println("Size of product package is Extra Large and");
            return true;

        }
        else if (area > 200) {
            System.out.println("Size of product package is Large and");
            return true;
        }
        else if (area > 150) {
            System.out.println("Size of product package is Medium and");
            return true;
        }
        else if (area > 100) {
            System.out.println("Size of product package is Small and");
            return true;
        }
        else if (area > 50) {
            System.out.println("Size of product package is Extra Small and");
            return true;
        }
        else {
            return false;
        }
        return;
    }

    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Length: ");
            double a = scanner.nextDouble();

            System.out.print("Width: ");
            double b = scanner.nextDouble();

            System.out.print("Height: ");
            double c = scanner.nextDouble();

            Product product = new Product((int) a, (int) b, (int) c);

            // Dimensions.printSize(area);

        } catch (InputMismatchException e) {
            System.out.println("Invalid Input");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }
}