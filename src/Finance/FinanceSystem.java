package Finance;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FinanceSystem {

    private static final List<Transaction> transactions = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void start() {
        int choice = -1;

        do {
            displayMainMenu();
            try {
                choice = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
                continue;
            }

            switch (choice) {
                case 1 -> addInvoice();
                case 2 -> addPayroll();
                case 3 -> addCustomerPayment();
                case 4 -> viewAllTransactions();
                case 5 -> processAllTransactions();
                case 0 -> System.out.println("Returning to main menu...");
                default -> System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 0);
    }

    private static void displayMainMenu() {
        System.out.println("\n--- Finance System ---");
        System.out.println("1. Add Invoice");
        System.out.println("2. Add Payroll Entry");
        System.out.println("3. Add Customer Payment");
        System.out.println("4. View All Transactions");
        System.out.println("5. Process All Transactions");
        System.out.println("0. Back to Main Menu");
        System.out.print("Choice: ");
    }

    private static void addInvoice() {
        System.out.print("Transaction ID: ");
        String id = scanner.nextLine();
        System.out.print("Amount: ");
        double amount = Double.parseDouble(scanner.nextLine());
        System.out.print("Vendor name: ");
        String vendor = scanner.nextLine();
        System.out.print("Days until due: ");
        int days = Integer.parseInt(scanner.nextLine());

        Invoice invoice = new Invoice(id, amount, LocalDate.now(),
                "Invoice from " + vendor, vendor, LocalDate.now().plusDays(days));
        transactions.add(invoice);
        System.out.println("Invoice added.");
    }

    private static void addPayroll() {
        System.out.print("Transaction ID: ");
        String id = scanner.nextLine();
        System.out.print("Employee ID: ");
        String empId = scanner.nextLine();
        System.out.print("Hours worked: ");
        double hours = Double.parseDouble(scanner.nextLine());
        System.out.print("Hourly rate: ");
        double rate = Double.parseDouble(scanner.nextLine());

        Payroll payroll = new Payroll(id, LocalDate.now(), empId, hours, rate);
        transactions.add(payroll);
        System.out.println("Payroll entry added.");
    }

    private static void addCustomerPayment() {
        System.out.print("Transaction ID: ");
        String id = scanner.nextLine();
        System.out.print("Customer ID: ");
        String customerId = scanner.nextLine();
        System.out.print("Amount: ");
        double amount = Double.parseDouble(scanner.nextLine());

        CustomerPayment payment = new CustomerPayment(id, amount, LocalDate.now(), customerId);
        transactions.add(payment);
        System.out.println("Customer payment recorded.");
    }

    private static void viewAllTransactions() {
        if (transactions.isEmpty()) {
            System.out.println("No transactions on record.");
            return;
        }
        System.out.println("\n--- All Transactions ---");
        for (Transaction t : transactions) {
            System.out.println(t.getDetails());
        }
    }

    private static void processAllTransactions() {
        if (transactions.isEmpty()) {
            System.out.println("No transactions to process.");
            return;
        }
        System.out.println("\n--- Processing All Transactions ---");
        for (Transaction t : transactions) {
            t.processTransaction();
        }
    }
}