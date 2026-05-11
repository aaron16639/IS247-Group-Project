import CustomerRelationshipManagement.CRMSystem;
import Finance.FinanceSystem;
import HumanResources.HRSystem;
import SupplyChain.SupplyChain;

import java.util.Scanner;

/**
 * Entry point for the ERP system. Displays the main menu and
 * routes the user to the appropriate module.
 */
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
                SupplyChain.start();
            } else if (choice == 0){
                System.out.println("Thank you for using our ERP system!");
            } else {
                System.out.println("Invalid selection, please try again.");
            }
        } while (choice != 0);

        input.close();
    }

    /**
     * Reads and validates an integer choice from the user.
     * Loops until a valid integer is entered.
     *
     * @param input the shared Scanner instance
     * @return the validated integer choice
     */
    private static int readChoice(Scanner input) {
        while (!input.hasNextInt()) {
            System.out.println("Invalid selection, please try again.");
            input.next();
        }
        int choice = input.nextInt();
        input.nextLine();
        return choice;
    }

    /** Prints the main ERP module selection menu to the console. */
    public static void printOptions() {
        System.out.println("Please select a choice:");
        System.out.println("1. CRM");
        System.out.println("2. Finance");
        System.out.println("3. Human Resources");
        System.out.println("4. Supply Chain");
        System.out.println("0. Exit");
    }
}