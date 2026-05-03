import CustomerRelationshipManagement.CRMSystem;
import Finance.FinanceSystem;
import HumanResources.HRSystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to the ERP system.");
        int choice;

        do {
            printOptions();
            choice = readChoice(input);

            if (choice == 1) {
                CRMSystem.Menu();
            } else if (choice == 2) {
                FinanceSystem.start();
            } else if (choice == 3) {
                HRSystem.start();
            } else if (choice == 4) {
                System.out.println("Still building the Supply Chain system..."); // TODO: Implement an entry point into the Finance system
            } else if (choice == 5){
                System.out.println("Thank you for using our ERP system! Goodbye!");
            } else {
                System.out.println("Invalid selection, please try again.");
            }
        } while (choice != 5);

        input.close();
    }


    private static int readChoice(Scanner input) {
        while (!input.hasNextInt()) {
            System.out.println("Invalid selection, please try again.");
            input.next();
        }
        int choice = input.nextInt();
        input.nextLine();
        return choice;
    }

    public static void printOptions() {
        System.out.println("Please select a choice:");
        System.out.println("1. CRM");
        System.out.println("2. Finance");
        System.out.println("3. Human Resources");
        System.out.println("4. Supply Chain");
        System.out.println("5. Exit");
    }
}
