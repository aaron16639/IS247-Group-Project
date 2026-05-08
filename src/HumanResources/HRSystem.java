// Aaron Saudager
// aaronsaudager@icloud.com

package HumanResources;

import Finance.FinanceSystem;
import Finance.Payroll;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HRSystem {
    private static final List<Employee> employees = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void start() {
        int choice;

        do {
            displayMainMenu();
            try {
                choice = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                choice = -1;
                continue;
            }

            switch (choice) {
                case 1 -> addEmployee();
                case 2 -> viewAllEmployees();
                case 3 -> searchEmployeeByID();
                case 4 -> searchByName();
                case 5 -> filterByDepartment();
                case 6 -> updateEmployee();
                case 7 -> removeEmployee();
                case 8 -> processPayroll();
                case 9 -> hrSummary();
                case 10 -> ptoReport();
                case 0 -> System.out.println("Returning to main menu...");
                default -> System.out.println("Invalid option. Please try again.");
            }
        } while (choice != 0);
    }

    public static void displayMainMenu() {
        System.out.println("\n--- HR System ---");
        System.out.println("1.  Add Employee");
        System.out.println("2.  View All Employees");
        System.out.println("3.  Search Employee by ID");
        System.out.println("4.  Search Employee by Name");
        System.out.println("5.  Filter by Department");
        System.out.println("6.  Update Employee");
        System.out.println("7.  Remove Employee");
        System.out.println("8.  Process Payroll for Employee");
        System.out.println("9.  HR Summary");
        System.out.println("10. PTO Report");
        System.out.println("0.  Back");
        System.out.print("Enter choice: ");
    }

    public static Employee findEmployee(String id) {
        for (Employee e : employees) {
            if (e.getEmployeeID().equalsIgnoreCase(id)) {
                return e;
            }
        }
        return null;
    }

    private static void addEmployee() {
        System.out.print("Enter Employee ID: ");
        String id = scanner.nextLine().trim();

        if (findEmployee(id) != null) {
            System.out.println("An employee with ID \"" + id + "\" already exists.");
            return;
        }

        System.out.print("Enter Name: ");
        String name = scanner.nextLine().trim();

        System.out.print("Enter Department: ");
        String department = scanner.nextLine().trim();

        System.out.println("Select Employee Type:");
        System.out.println("  1. Full-Time");
        System.out.println("  2. Part-Time");
        System.out.println("  3. Contractor");
        System.out.print("Enter choice: ");

        int typeChoice;
        try {
            typeChoice = Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Employee not added.");
            return;
        }

        switch (typeChoice) {
            case 1 -> {
                double salary = promptDouble("Enter Annual Salary: ");
                int pto = promptInt("Enter PTO Days: ");
                System.out.print("Benefits Eligible? (y/n): ");
                boolean benefits = scanner.nextLine().trim().equalsIgnoreCase("y");
                employees.add(new FullTimeEmployee(id, name, department, salary, pto, benefits));
                System.out.println("Full-time employee \"" + name + "\" added successfully.");
            }
            case 2 -> {
                double rate = promptDouble("Enter Hourly Rate: ");
                int maxHours = promptInt("Enter Max Hours Per Week: ");
                int pto = promptInt("Enter PTO Days: ");
                employees.add(new PartTimeEmployee(id, name, department, rate, maxHours, pto));
                System.out.println("Part-time employee \"" + name + "\" added successfully.");
            }
            case 3 -> {
                double rate = promptDouble("Enter Hourly Rate: ");
                System.out.print("Enter Contract End Date (YYYY-MM-DD): ");
                LocalDate endDate;
                try {
                    endDate = LocalDate.parse(scanner.nextLine().trim());
                } catch (Exception e) {
                    System.out.println("Invalid date format. Employee not added.");
                    return;
                }
                employees.add(new Contractor(id, name, department, rate, endDate));
                System.out.println("Contractor \"" + name + "\" added successfully.");
            }
            default -> System.out.println("Invalid type selection. Employee not added.");
        }
    }

    private static void viewAllEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees on record.");
            return;
        }
        System.out.println("\n--- All Employees ---");
        for (Employee e : employees) {
            e.displayInfo();
            System.out.println("---------------------");
        }
    }

    private static void searchEmployeeByID() {
        System.out.print("Enter Employee ID to search: ");
        String id = scanner.nextLine().trim();

        Employee e = findEmployee(id);
        if (e == null) {
            System.out.println("No employee found with ID \"" + id + "\".");
        } else {
            System.out.println("\n--- Employee Found ---");
            e.displayInfo();
        }
    }

    private static void searchByName() {
        System.out.print("Enter name to search: ");
        String query = scanner.nextLine().trim().toLowerCase();

        boolean found = false;
        System.out.println("\n--- Search Results ---");
        for (Employee e : employees) {
            if (e.getName().toLowerCase().contains(query)) {
                e.displayInfo();
                System.out.println("---------------------");
                found = true;
            }
        }
        if (!found) {
            System.out.println("No employees found matching \"" + query + "\".");
        }
    }

    private static void filterByDepartment() {
        System.out.print("Enter department to filter by: ");
        String dept = scanner.nextLine().trim().toLowerCase();

        boolean found = false;
        System.out.println("\n--- Employees in Department ---");
        for (Employee e : employees) {
            if (e.getDepartment().toLowerCase().contains(dept)) {
                e.displayInfo();
                System.out.println("---------------------");
                found = true;
            }
        }
        if (!found) {
            System.out.println("No employees found in department \"" + dept + "\".");
        }
    }

    private static void updateEmployee() {
        System.out.print("Enter Employee ID to update: ");
        String id = scanner.nextLine().trim();

        Employee e = findEmployee(id);
        if (e == null) {
            System.out.println("No employee found with ID \"" + id + "\".");
            return;
        }

        System.out.println("\nCurrent info:");
        e.displayInfo();
        System.out.println("(Leave a field blank to keep the current value.)");

        System.out.print("New Name [" + e.getName() + "]: ");
        String name = scanner.nextLine().trim();
        if (!name.isEmpty()) e.setName(name);

        System.out.print("New Department [" + e.getDepartment() + "]: ");
        String department = scanner.nextLine().trim();
        if (!department.isEmpty()) e.setDepartment(department);

        if (e instanceof FullTimeEmployee ft) {
            System.out.print("New Annual Salary [" + ft.getAnnualSalary() + "]: ");
            String s = scanner.nextLine().trim();
            if (!s.isEmpty()) {
                try { ft.setAnnualSalary(Double.parseDouble(s)); }
                catch (NumberFormatException ex) { System.out.println("Invalid salary — keeping current value."); }
            }

            System.out.print("New PTO Days [" + ft.getPTODays() + "]: ");
            String p = scanner.nextLine().trim();
            if (!p.isEmpty()) {
                try { ft.setPTODays(Integer.parseInt(p)); }
                catch (NumberFormatException ex) { System.out.println("Invalid PTO days — keeping current value."); }
            }

            System.out.print("Benefits Eligible (y/n) [" + (ft.isBenefitsEligible() ? "y" : "n") + "]: ");
            String b = scanner.nextLine().trim();
            if (!b.isEmpty()) ft.setBenefitsEligible(b.equalsIgnoreCase("y"));

        } else if (e instanceof PartTimeEmployee pt) {
            System.out.print("New Hourly Rate [" + pt.getHourlyRate() + "]: ");
            String r = scanner.nextLine().trim();
            if (!r.isEmpty()) {
                try { pt.setHourlyRate(Double.parseDouble(r)); }
                catch (NumberFormatException ex) { System.out.println("Invalid rate — keeping current value."); }
            }

            System.out.print("New Max Hours/Week [" + pt.getMaxHoursPerWeek() + "]: ");
            String h = scanner.nextLine().trim();
            if (!h.isEmpty()) {
                try { pt.setMaxHoursPerWeek(Integer.parseInt(h)); }
                catch (NumberFormatException ex) { System.out.println("Invalid hours — keeping current value."); }
            }

            System.out.print("New PTO Days [" + pt.getPTODays() + "]: ");
            String p = scanner.nextLine().trim();
            if (!p.isEmpty()) {
                try { pt.setPTODays(Integer.parseInt(p)); }
                catch (NumberFormatException ex) { System.out.println("Invalid PTO days — keeping current value."); }
            }

        } else if (e instanceof Contractor c) {
            System.out.print("New Hourly Rate [" + c.getHourlyRate() + "]: ");
            String r = scanner.nextLine().trim();
            if (!r.isEmpty()) {
                try { c.setHourlyRate(Double.parseDouble(r)); }
                catch (NumberFormatException ex) { System.out.println("Invalid rate — keeping current value."); }
            }

            System.out.print("New Contract End Date [" + c.getContractEndDate() + "]: ");
            String d = scanner.nextLine().trim();
            if (!d.isEmpty()) {
                try { c.setContractEndDate(LocalDate.parse(d)); }
                catch (Exception ex) { System.out.println("Invalid date — keeping current value."); }
            }
        }

        System.out.println("Employee \"" + e.getName() + "\" updated successfully.");
    }

    private static void removeEmployee() {
        System.out.print("Enter Employee ID to remove: ");
        String id = scanner.nextLine().trim();

        Employee e = findEmployee(id);
        if (e == null) {
            System.out.println("No employee found with ID \"" + id + "\".");
            return;
        }

        System.out.println("\nEmployee to remove:");
        e.displayInfo();
        System.out.print("Are you sure you want to remove this employee? (y/n): ");
        String confirm = scanner.nextLine().trim();

        if (confirm.equalsIgnoreCase("y")) {
            employees.remove(e);
            System.out.println("Employee \"" + e.getName() + "\" removed successfully.");
        } else {
            System.out.println("Removal cancelled.");
        }
    }

    private static void processPayroll() {
        System.out.print("Enter Employee ID: ");
        String id = scanner.nextLine().trim();

        Employee e = findEmployee(id);
        if (e == null) {
            System.out.println("No employee found with ID \"" + id + "\".");
            return;
        }

        String txId = "PAY-" + e.getEmployeeID() + "-" + LocalDate.now();

        if (e instanceof FullTimeEmployee ft) {
            double monthlyHours = 160.0;
            double hourlyRate = ft.getAnnualSalary() / 12.0 / monthlyHours;
            Payroll payroll = new Payroll(txId, LocalDate.now(), ft.getEmployeeID(), monthlyHours, hourlyRate);
            FinanceSystem.addTransaction(payroll);
            System.out.printf("Payroll processed for %s — $%.2f gross (160 hrs @ $%.2f/hr). Entry added to Finance system.%n",
                    ft.getName(), ft.getAnnualSalary() / 12.0, hourlyRate);

        } else if (e instanceof PartTimeEmployee pt) {
            double hours = promptDouble("Enter hours worked this period: ");
            Payroll payroll = new Payroll(txId, LocalDate.now(), pt.getEmployeeID(), hours, pt.getHourlyRate());
            FinanceSystem.addTransaction(payroll);
            System.out.printf("Payroll processed for %s — $%.2f gross (%.2f hrs @ $%.2f/hr). Entry added to Finance system.%n",
                    pt.getName(), hours * pt.getHourlyRate(), hours, pt.getHourlyRate());

        } else {
            System.out.println("Contractors are paid via invoice. Use the Finance system to add an invoice for this contractor.");
        }
    }

    private static void hrSummary() {
        int fullTime = 0, partTime = 0, contractors = 0;
        double monthlySalaried = 0.0, monthlyHourly = 0.0;

        for (Employee e : employees) {
            if (e instanceof FullTimeEmployee ft) {
                fullTime++;
                monthlySalaried += ft.getAnnualSalary() / 12.0;
            } else if (e instanceof PartTimeEmployee pt) {
                partTime++;
                monthlyHourly += pt.getHourlyRate() * pt.getMaxHoursPerWeek() * 4;
            } else if (e instanceof Contractor) {
                contractors++;
            }
        }

        System.out.println("\n=== HR Summary ===");
        System.out.println("Total Employees: " + employees.size());
        System.out.println("  Full-Time:   " + fullTime);
        System.out.println("  Part-Time:   " + partTime);
        System.out.println("  Contractors: " + contractors);
        System.out.println("\nEstimated Monthly Payroll Cost:");
        System.out.printf("  Salaried:  $%.2f%n", monthlySalaried);
        System.out.printf("  Hourly:    $%.2f%n", monthlyHourly);
        System.out.printf("  Total:     $%.2f%n", monthlySalaried + monthlyHourly);
    }

    private static void ptoReport() {
        System.out.println("\n=== PTO Report ===");
        boolean found = false;
        for (Employee e : employees) {
            if (e instanceof FullTimeEmployee ft) {
                System.out.printf("%-8s - %-20s (Full-Time)  |  %d days remaining%n",
                        ft.getEmployeeID(), ft.getName(), ft.getPTODays());
                found = true;
            } else if (e instanceof PartTimeEmployee pt) {
                System.out.printf("%-8s - %-20s (Part-Time)  |  %d days remaining%n",
                        pt.getEmployeeID(), pt.getName(), pt.getPTODays());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No full-time or part-time employees on record.");
        }
    }

    private static double promptDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Double.parseDouble(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }

    private static int promptInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a whole number.");
            }
        }
    }
}
