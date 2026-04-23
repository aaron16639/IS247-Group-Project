// Aaron Saudager
// aaronsaudager@icloud.com
package HumanResources;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HRSystem {
    private final List<Employee> employees = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public static void start() {
        int choice = -1;

        do {
            displayMainMenu();
            // TODO: Accept input

            switch (choice) {
                // TODO: Craft choices
            }

        } while (choice != 0);
    }

    public static void displayMainMenu() {
        System.out.println("Welcome to the HR system.");
    }
}
