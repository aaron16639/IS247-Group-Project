package SupplyChain;
import java.util.Scanner;

public class Product {
    private final int length;
    private final int width;
    private final int height;

    public Product(int length, int width, int height) {
        Scanner scanner = new Scanner(System.in);

        int area = length * width * height;

        System.out.println("Area of package ordered: " + area);

        if (area > 300) {
            throw new IllegalArgumentException("Size doesn't exist for product package");
        }
        else if (area > 250) {
            System.out.println("Size of product package is Extra Large");
            this.length = length;
            this.width = width;
            this.height = height;
        }
        else if (area > 200) {
            System.out.println("Size of product package is Large");
            this.length = length;
            this.width = width;
            this.height = height;
        }
        else if (area > 150) {
            System.out.println("Size of product package is Medium");
            this.length = length;
            this.width = width;
            this.height = height;
        }
        else if (area > 100) {
            System.out.println("Size of product package is Small");
            this.length = length;
            this.width = width;
            this.height = height;
        }
        else if (area > 50) {
            System.out.println("Size of product package is Extra Small");
            this.length = length;
            this.width = width;
            this.height = height;
        }
        else {
            throw new IllegalArgumentException("Size doesn't exist for product package");
        }
    }
}
