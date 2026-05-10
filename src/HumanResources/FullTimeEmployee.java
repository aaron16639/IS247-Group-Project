// Aaron Saudager
// aaronsaudager@icloud.com

package HumanResources;

/**
 * Represents a full-time, salaried employee in the HR system.
 *
 * <p>A full-time employee receives an annual salary (paid monthly), accrues paid
 * time off (PTO) days, and may be eligible for benefits. This class provides
 * overloaded versions of {@link #displayInfo()} and {@link #calculatePay()} to
 * support conditional salary display and multi-month pay projections.
 *
 * @author IS247 Group Project Team
 * @version 1.0
 * @see Employee
 */
public class FullTimeEmployee extends Employee {
    private double annualSalary;
    private int PTODays;
    private boolean benefitsEligible;

    /**
     * Constructs a new FullTimeEmployee with all required employment details.
     *
     * @param employeeID        the unique identifier for this employee (e.g., {@code "E001"})
     * @param name              the full name of the employee
     * @param department        the department to which this employee belongs
     * @param annualSalary      the gross annual salary in dollars; should be {@code >= 0}
     * @param PTODays           the number of PTO days accrued; should be {@code >= 0}
     * @param benefitsEligible  {@code true} if the employee qualifies for benefits
     */
    public FullTimeEmployee(String employeeID, String name, String department,
                            double annualSalary, int PTODays, boolean benefitsEligible) {
        super(employeeID, name, department);
        this.annualSalary = annualSalary;
        this.PTODays = PTODays;
        this.benefitsEligible = benefitsEligible;
    }

    /**
     * Returns the employee's gross annual salary.
     *
     * @return the annual salary in dollars
     */
    public double getAnnualSalary() { return annualSalary; }

    /**
     * Returns the number of PTO days this employee has accrued.
     *
     * @return the PTO day count
     */
    public int getPTODays() { return PTODays; }

    /**
     * Returns whether this employee is eligible for benefits.
     *
     * @return {@code true} if benefits-eligible; {@code false} otherwise
     */
    public boolean isBenefitsEligible() { return benefitsEligible; }

    /**
     * Updates the employee's annual salary.
     *
     * @param annualSalary the new annual salary in dollars; should be {@code >= 0}
     */
    public void setAnnualSalary(double annualSalary) { this.annualSalary = annualSalary; }

    /**
     * Updates the employee's accrued PTO days.
     *
     * @param PTODays the new PTO day count; should be {@code >= 0}
     */
    public void setPTODays(int PTODays) { this.PTODays = PTODays; }

    /**
     * Sets whether this employee is eligible for benefits.
     *
     * @param benefitsEligible {@code true} to mark as benefits-eligible
     */
    public void setBenefitsEligible(boolean benefitsEligible) { this.benefitsEligible = benefitsEligible; }

    /**
     * Displays full employee details including annual salary to standard output.
     *
     * <p>Equivalent to calling {@link #displayInfo(boolean) displayInfo(true)}.
     */
    @Override
    public void displayInfo() {
        System.out.println("Employee ID: " + getEmployeeID());
        System.out.println("Name: " + getName());
        System.out.println("Department: " + getDepartment());
        System.out.println("Type: Full-Time");
        System.out.printf("Annual Salary: $%.2f%n", annualSalary);
        System.out.println("PTO Days: " + PTODays);
        System.out.println("Benefits Eligible: " + (benefitsEligible ? "Yes" : "No"));
    }

    /**
     * Displays employee details, optionally including the annual salary.
     *
     * <p>Use {@code showSalary = false} when rendering information for audiences
     * that should not see compensation data (e.g., peer-facing reports).
     *
     * @param showSalary {@code true} to include the annual salary in the output;
     *                   {@code false} to omit it
     */
    public void displayInfo(boolean showSalary) {
        System.out.println("Employee ID: " + getEmployeeID());
        System.out.println("Name: " + getName());
        System.out.println("Department: " + getDepartment());
        System.out.println("Type: Full-Time");
        if (showSalary) {
            System.out.printf("Annual Salary: $%.2f%n", annualSalary);
        }
        System.out.println("PTO Days: " + PTODays);
        System.out.println("Benefits Eligible: " + (benefitsEligible ? "Yes" : "No"));
    }

    /**
     * Calculates the estimated monthly pay for this employee.
     *
     * <p>Computed as {@code annualSalary / 12}.
     *
     * @return the monthly gross pay in dollars
     */
    @Override
    public double calculatePay() {
        return annualSalary / 12;
    }

    /**
     * Calculates the estimated gross pay for a given number of months.
     *
     * <p>Computed as {@code (annualSalary / 12) * months}.
     *
     * @param months the number of months to project; should be {@code > 0}
     * @return the projected gross pay in dollars for the specified period
     */
    public double calculatePay(int months) {
        return (annualSalary / 12) * months;
    }

    /**
     * Returns a concise string representation of this full-time employee.
     *
     * <p>Format: {@code [ID] Name | Dept | Monthly Pay: $X.XX}
     *
     * @return a formatted summary string
     */
    @Override
    public String toString() {
        return "[" + getEmployeeID() + "] " + getName() + " - Full-Time | Dept: " + getDepartment()
                + String.format(" | Monthly Pay: $%.2f", calculatePay());
    }
}
