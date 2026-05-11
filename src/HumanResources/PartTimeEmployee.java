// Aaron Saudager
// aaronsaudager@icloud.com

package HumanResources;

/**
 * Represents a part-time, hourly employee in the HR system.
 *
 * <p>A part-time employee is paid by the hour and is subject to a maximum number
 * of hours per week. Monthly pay is estimated as
 * {@code hourlyRate * maxHoursPerWeek * 4}. Part-time employees also accrue PTO days.
 *
 * @author IS247 Group Project Team
 * @version 1.0
 * @see Employee
 */
public class PartTimeEmployee extends Employee {
    private double hourlyRate;
    private int maxHoursPerWeek;
    private int PTODays;

    /**
     * Constructs a new PartTimeEmployee with all required employment details.
     *
     * @param employeeID      the unique identifier for this employee (e.g., {@code "E002"})
     * @param name            the full name of the employee
     * @param department      the department to which this employee belongs
     * @param hourlyRate      the pay rate in dollars per hour; should be {@code >= 0}
     * @param maxHoursPerWeek the maximum number of hours this employee may work per week;
     *                        should be {@code > 0}
     * @param PTODays         the number of PTO days accrued; should be {@code >= 0}
     */
    public PartTimeEmployee(String employeeID, String name, String department,
                            double hourlyRate, int maxHoursPerWeek, int PTODays) {
        super(employeeID, name, department);
        this.hourlyRate = hourlyRate;
        this.maxHoursPerWeek = maxHoursPerWeek;
        this.PTODays = PTODays;
    }

    /**
     * Returns the employee's hourly pay rate.
     *
     * @return the hourly rate in dollars
     */
    public double getHourlyRate() { return hourlyRate; }

    /**
     * Returns the maximum number of hours this employee may work per week.
     *
     * @return the weekly hour cap
     */
    public int getMaxHoursPerWeek() { return maxHoursPerWeek; }

    /**
     * Returns the number of PTO days this employee has accrued.
     *
     * @return the PTO day count
     */
    public int getPTODays() { return PTODays; }

    /**
     * Updates the employee's hourly pay rate.
     *
     * @param hourlyRate the new hourly rate in dollars; should be {@code >= 0}
     */
    public void setHourlyRate(double hourlyRate) { this.hourlyRate = hourlyRate; }

    /**
     * Updates the maximum weekly hours for this employee.
     *
     * @param maxHoursPerWeek the new weekly hour cap; should be {@code > 0}
     */
    public void setMaxHoursPerWeek(int maxHoursPerWeek) { this.maxHoursPerWeek = maxHoursPerWeek; }

    /**
     * Updates the employee's accrued PTO days.
     *
     * @param PTODays the new PTO day count; should be {@code >= 0}
     */
    public void setPTODays(int PTODays) { this.PTODays = PTODays; }

    /**
     * Displays all employee details including hourly rate, max weekly hours, and PTO
     * to standard output.
     */
    @Override
    public void displayInfo() {
        System.out.println("Employee ID: " + getEmployeeID());
        System.out.println("Name: " + getName());
        System.out.println("Department: " + getDepartment());
        System.out.println("Type: Part-Time");
        System.out.printf("Hourly Rate: $%.2f%n", hourlyRate);
        System.out.println("Max Hours/Week: " + maxHoursPerWeek);
        System.out.println("PTO Days: " + PTODays);
    }

    /**
     * Calculates the estimated monthly pay for this employee.
     *
     * <p>Computed as {@code hourlyRate * maxHoursPerWeek * 4}, assuming four weeks
     * per month at the maximum scheduled hours.
     *
     * @return the estimated monthly gross pay in dollars
     */
    @Override
    public double calculatePay() {
        return hourlyRate * maxHoursPerWeek * 4;
    }

    /**
     * Returns a concise string representation of this part-time employee.
     *
     * <p>Format: {@code [employeeID] name - Part-Time | Dept: department | Est. Monthly Pay: $XX.XX}
     *
     * @return a formatted summary string
     */
    @Override
    public String toString() {
        return "[" + getEmployeeID() + "] " + getName() + " - Part-Time | Dept: " + getDepartment()
                + String.format(" | Est. Monthly Pay: $%.2f", calculatePay());
    }
}
