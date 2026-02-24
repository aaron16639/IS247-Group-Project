
import java.util.Scanner;

public class SupplyChain{
public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("length: ");
    int a = scanner.nextInt();

    System.out.print("width: ");
    int b = scanner.nextInt();

    System.out.print("height: ");
    int c = scanner.nextInt();

    System.out.println("Area of package ordered: " + (a * b * c));


    if ((a * b * c) > 300) {
        System.out.println("Size doesn't exist for product package");
}
    else if ((a * b * c) <= 300 && (a * b *c) > 250) {
        System.out.println("Size of product package is XL");
    }
    else if ((a * b * c) <= 250 && (a * b * c) > 200){
        System.out.println("Size of product package is L");
    }
    else if ((a * b * c) <= 200 && (a * b * c) > 150) {
        System.out.println("Size of product package is M");
    }
    else if ((a * b * c) <= 150 && (a * b * c) > 100) {
        System.out.println("Size of product package is S");
    }
    else if ((a * b * c) <= 100 && (a * b * c) > 50) {
        System.out.println("Size of product package is XS");
    }
    else{
        System.out.println("Size doesn't exist for product package");
    }
    scanner.close();

  }
}
