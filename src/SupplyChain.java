import java.util.Scanner;
public class SupplyChain{
public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Length: ");
    int a = scanner.nextInt();

    System.out.print("Width: ");
    int b = scanner.nextInt();

    System.out.print("Height: ");
    int c = scanner.nextInt();

    int area = a + b + c;

    System.out.println("Area of package ordered: " + area);


    if (area > 300) {
        System.out.println("Size doesn't exist for product package");
    }
    else if (area > 250) {
        System.out.println("Size of product package is Extra Large");
    }
    else if (area > 200) {
        System.out.println("Size of product package is Large");
    }
    else if (area > 150) {
        System.out.println("Size of product package is Medium");
    }
    else if (area > 100) {
        System.out.println("Size of product package is Small");
    }
    else if (area > 50) {
        System.out.println("Size of product package is Extra Small");
    }
    else{
        System.out.println("Size doesn't exist for product package");
    }
    scanner.close();

  }
}
