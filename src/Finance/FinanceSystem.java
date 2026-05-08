package Finance;

import HumanResources.Contractor;
import HumanResources.Employee;
import HumanResources.FullTimeEmployee;
import HumanResources.HRSystem;
import HumanResources.PartTimeEmployee;

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
        System.out.print("Employee ID: ");
        String empId = scanner.nextLine().trim();

        Employee emp = HRSystem.findEmployee(empId);
        if (emp == null) {
            System.out.println("No employee found with ID \"" + empId + "\" in HR system.");
            return;
        }

        double hours;
        double rate;

        if (emp instanceof FullTimeEmployee ft) {
            hours = 160.0;
            rate = ft.getAnnualSalary() / 12.0 / 160.0;
            System.out.printf("Employee: %s (Full-Time) — Monthly payroll: $%.2f (160 hrs @ $%.2f/hr)%n",
                    ft.getName(), ft.getAnnualSalary() / 12.0, rate);
        } else if (emp instanceof PartTimeEmployee pt) {
            System.out.printf("Employee: %s (Part-Time) — HR hourly rate: $%.2f%n", pt.getName(), pt.getHourlyRate());
            System.out.print("Use HR rate? (y/n): ");
            String useHR = scanner.nextLine().trim();
            if (useHR.equalsIgnoreCase("y")) {
                rate = pt.getHourlyRate();
            } else {
                System.out.print("Enter hourly rate: ");
                rate = Double.parseDouble(scanner.nextLine().trim());
            }
            System.out.print("Hours worked: ");
            hours = Double.parseDouble(scanner.nextLine().trim());
        } else if (emp instanceof Contractor c) {
            System.out.printf("Employee: %s (Contractor) — HR hourly rate: $%.2f%n", c.getName(), c.getHourlyRate());
            System.out.print("Use HR rate? (y/n): ");
            String useHR = scanner.nextLine().trim();
            if (useHR.equalsIgnoreCase("y")) {
                rate = c.getHourlyRate();
            } else {
                System.out.print("Enter hourly rate: ");
                rate = Double.parseDouble(scanner.nextLine().trim());
            }
            System.out.print("Hours worked: ");
            hours = Double.parseDouble(scanner.nextLine().trim());
        } else {
            System.out.println("Unknown employee type.");
            return;
        }

        System.out.print("Transaction ID: ");
        String id = scanner.nextLine().trim();

        Payroll payroll = new Payroll(id, LocalDate.now(), empId, hours, rate);
        transactions.add(payroll);
        System.out.printf("Payroll entry added for %s — $%.2f gross.%n", emp.getName(), hours * rate);
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

    public static void addTransaction(Transaction t) {
        transactions.add(t);
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