// Aaron Saudager
// aaronsaudager@icloud.com

package HumanResources;

import java.time.LocalDate;

/**
 * Represents a contractor employed on a fixed-term basis in the HR system.
 *
 * <p>Contractors are paid an hourly rate and have a defined contract end date.
 * Unlike {@link FullTimeEmployee} and {@link PartTimeEmployee}, contractors do not
 * accrue PTO and are not benefits-eligible. The {@link #calculatePay()} method
 * returns the base hourly rate — callers must multiply by hours worked for actual pay.
 *
 * @author IS247 Group Project Team
 * @version 1.0
 * @see Employee
 */
public class Contractor extends Employee {
    private double hourlyRate;
    private LocalDate contractEndDate;

    /**
     * Constructs a new Contractor with all required engagement details.
     *
     * @param employeeID       the unique identifier for this contractor (e.g., {@code "C001"})
     * @param name             the full name of the contractor
     * @param department       the department to which this contractor is assigned
     * @param hourlyRate       the pay rate in dollars per hour; should be {@code >= 0}
     * @param contractEndDate  the date on which this contractor's engagement ends;
     *                         should be non-null
     */
    public Contractor(String employeeID, String name, String department,
                      double hourlyRate, LocalDate contractEndDate) {
        super(employeeID, name, department);
        this.hourlyRate = hourlyRate;
        this.contractEndDate = contractEndDate;
    }

    /**
     * Returns the contractor's hourly pay rate.
     *
     * @return the hourly rate in dollars
     */
    public double getHourlyRate() { return hourlyRate; }

    /**
     * Returns the date on which this contractor's engagement ends.
     *
     * @return the contract end date as a {@link java.time.LocalDate}
     */
    public LocalDate getContractEndDate() { return contractEndDate; }

    /**
     * Updates the contractor's hourly pay rate.
     *
     * @param hourlyRate the new hourly rate in dollars; should be {@code >= 0}
     */
    public void setHourlyRate(double hourlyRate) { this.hourlyRate = hourlyRate; }

    /**
     * Updates the contract end date for this contractor.
     *
     * @param contractEndDate the new end date; should be non-null
     */
    public void setContractEndDate(LocalDate contractEndDate) { this.contractEndDate = contractEndDate; }

    /**
     * Displays all contractor details including hourly rate and contract end date
     * to standard output.
     */
    @Override
    public void displayInfo() {
        System.out.println("Employee ID: " + getEmployeeID());
        System.out.println("Name: " + getName());
        System.out.println("Department: " + getDepartment());
        System.out.println("Type: Contractor");
        System.out.printf("Hourly Rate: $%.2f%n", hourlyRate);
        System.out.println("Contract End Date: " + contractEndDate);
    }

    /**
     * Returns the contractor's base hourly rate.
     *
     * <p>Unlike salaried or part-time employees, this method returns the raw hourly
     * rate rather than a monthly estimate. Callers are responsible for multiplying
     * by hours worked to compute actual compensation.
     *
     * @return the hourly rate in dollars
     */
    @Override
    public double calculatePay() {
        return hourlyRate;
    }

    /**
     * Returns a concise string representation of this contractor.
     *
     * <p>Format: {@code [<employeeID>] <name> - Contractor | Dept: <department> | Hourly Rate: $<rate> | Contract ends: <contractEndDate>}
     *
     * @return a formatted summary string
     */
    @Override
    public String toString() {
        return "[" + getEmployeeID() + "] " + getName() + " - Contractor | Dept: " + getDepartment()
                + String.format(" | Hourly Rate: $%.2f", hourlyRate) + " | Contract ends: " + contractEndDate;
    }
}
