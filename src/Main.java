import CustomerRelationshipManagement.CRMSystem;
import Finance.FinanceSystem;
import HumanResources.HRSystem;
import SupplyChain.SCMSystem;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        CRMSystem crmSystem = new CRMSystem();
        FinanceSystem financeSystem = new FinanceSystem();
        HRSystem hrSystem = new HRSystem();
        SCMSystem scmSystem = new SCMSystem();

        int choice;

        do {
            printOptions();
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("\n--- Redirecting to Customer Relationship Management (CRM) System ---");
                    // TODO: Start CRM system using CRMSystem.start();
                    break;
                case 2:
                    System.out.println("\n--- Redirecting to Finance System ---");
                    // TODO: FinanceSystem.start();
                    break;
                case 3:
                    System.out.println("\n--- Redirecting to Human Resources (HR) System ---");
                    hrSystem.start();
                    break;
                case 4:
                    System.out.println("\n--- Redirecting to Supply Chain Management (SCM) System ---");
                    // TODO: SCM.start();
                    break;
                case 0:
                    System.out.println("Exiting ERP System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (choice != 0);

        input.close();
    }


    public static void printOptions() {
        System.out.println("\n===== ERP System Main Menu =====");
        System.out.println("1. CRM System");
        System.out.println("2. Finance System ");
        System.out.println("3. HR System");
        System.out.println("4. Supply Chain System ");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }
}
