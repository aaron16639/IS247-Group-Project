package SupplyChain;
import java.util.Scanner;

public class Product {
    private final int length;
    private final int width;
    private final int height;

    public Product(int length, int width, int height) {
        Scanner scanner = new Scanner(System.in);

        int area = length * width * height;

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
}