// Aaron Saudager
// aaronsaudager@icloud.com

package HumanResources;

import java.time.LocalDate;

public class Contractor extends Employee {
    private double hourlyRate;
    private LocalDate contractEndDate;

    public Contractor(String employeeID, String name, String department,
                      double hourlyRate, LocalDate contractEndDate) {
        super(employeeID, name, department);
        this.hourlyRate = hourlyRate;
        this.contractEndDate = contractEndDate;
    }

    public double getHourlyRate() { return hourlyRate; }
    public LocalDate getContractEndDate() { return contractEndDate; }

    public void setHourlyRate(double hourlyRate) { this.hourlyRate = hourlyRate; }
    public void setContractEndDate(LocalDate contractEndDate) { this.contractEndDate = contractEndDate; }

    @Override
    public void displayInfo() {
        System.out.println("Employee ID: " + getEmployeeID());
        System.out.println("Name: " + getName());
        System.out.println("Department: " + getDepartment());
        System.out.println("Type: Contractor");
        System.out.printf("Hourly Rate: $%.2f%n", hourlyRate);
        System.out.println("Contract End Date: " + contractEndDate);
    }

    @Override
    public double calculatePay() {
        return hourlyRate;
    }

    @Override
    public String toString() {
        return "[" + getEmployeeID() + "] " + getName() + " - Contractor | Dept: " + getDepartment()
                + String.format(" | Hourly Rate: $%.2f", hourlyRate) + " | Contract ends: " + contractEndDate;
    }
}
