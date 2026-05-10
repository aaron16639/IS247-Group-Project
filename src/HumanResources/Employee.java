// Aaron Saudager
// aaronsaudager@icloud.com

package HumanResources;

import Common.DetailsDisplayable;

/**
 * Abstract base class representing a generic employee in the HR system.
 *
 * <p>All employee types share a common identity: an employee ID, a name, and a
 * department assignment. Subclasses must implement {@link #displayInfo()} to render
 * their type-specific details and {@link #calculatePay()} to compute their monthly
 * compensation.
 *
 * <p>This class implements {@link DetailsDisplayable} to enforce a consistent display
 * contract across all employee types.
 *
 * @author IS247 Group Project Team
 * @version 1.0
 * @see FullTimeEmployee
 * @see PartTimeEmployee
 * @see Contractor
 */
public abstract class Employee implements DetailsDisplayable {
    private String employeeID;
    private String name;
    private String department;

    /**
     * Constructs a new Employee with the specified identity information.
     *
     * @param employeeID the unique identifier for this employee (e.g., {@code "E001"})
     * @param name       the full name of the employee
     * @param department the department to which this employee belongs
     */
    public Employee(String employeeID, String name, String department) {
        this.employeeID = employeeID;
        this.name = name;
        this.department = department;
    }

    /**
     * Returns the unique employee ID.
     *
     * @return the employee ID string
     */
    public String getEmployeeID() { return employeeID; }

    /**
     * Returns the employee's full name.
     *
     * @return the employee's name
     */
    public String getName() { return name; }

    /**
     * Returns the department this employee belongs to.
     *
     * @return the department name
     */
    public String getDepartment() { return department; }

    /**
     * Sets the employee's ID.
     *
     * @param employeeID the new employee ID; should be non-null and non-empty
     */
    public void setEmployeeID(String employeeID) { this.employeeID = employeeID; }

    /**
     * Sets the employee's full name.
     *
     * @param name the new name; should be non-null and non-empty
     */
    public void setName(String name) { this.name = name; }

    /**
     * Sets the department for this employee.
     *
     * @param department the new department name; should be non-null and non-empty
     */
    public void setDepartment(String department) { this.department = department; }

    /**
     * Displays detailed information about this employee to standard output.
     *
     * <p>Each subclass formats its own output to include type-specific fields
     * (e.g., salary for full-time, hourly rate for part-time and contractors).
     */
    @Override
    public abstract void displayInfo();

    /**
     * Calculates and returns the employee's estimated monthly pay.
     *
     * <p>The calculation formula varies by subclass:
     * <ul>
     *   <li>{@link FullTimeEmployee}: {@code annualSalary / 12}</li>
     *   <li>{@link PartTimeEmployee}: {@code hourlyRate * maxHoursPerWeek * 4}</li>
     *   <li>{@link Contractor}: returns the base {@code hourlyRate} — callers must multiply by hours worked for actual pay</li>
     * </ul>
     *
     * @return the estimated monthly compensation as a {@code double}
     */
    public abstract double calculatePay();
}
