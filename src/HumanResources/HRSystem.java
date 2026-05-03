// Aaron Saudager
// aaronsaudager@icloud.com
package HumanResources;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HRSystem {
    private final List<Employee> employees = new ArrayList<>();


    public static void start() {

        int choice;

        do {
            displayMainMenu();
            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Nice choice!");
                    return;
                case 2:
                    System.out.println("Nice choice!");
                    return;
                case 3:
                    System.out.println("Nice choice!");
                    return;
                case 4:
                    System.out.println("Nice choice!");
                    return;
                // TODO: Craft real choices
            }
            scanner.close();
        } while (choice != 0);
    }

    public static void displayMainMenu() {
        System.out.println("Welcome to the HR system. Please select a choice.");
        System.out.println("1. Choice one");
        System.out.println("2. Choice two");
        System.out.println("3. Choice three");
        System.out.println("4. Choice four");
    }
}
