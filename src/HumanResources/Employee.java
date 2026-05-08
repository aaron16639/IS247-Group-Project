// Aaron Saudager
// aaronsaudager@icloud.com

package HumanResources;

import Common.DetailsDisplayable;

public abstract class Employee implements DetailsDisplayable {
    private String employeeID;
    private String name;
    private String department;

    public Employee(String employeeID, String name, String department) {
        this.employeeID = employeeID;
        this.name = name;
        this.department = department;
    }

    public String getEmployeeID() { return employeeID; }
    public String getName() { return name; }
    public String getDepartment() { return department; }

    public void setEmployeeID(String employeeID) { this.employeeID = employeeID; }
    public void setName(String name) { this.name = name; }
    public void setDepartment(String department) { this.department = department; }

    @Override
    public abstract void displayInfo();
    public abstract double calculatePay();
}
