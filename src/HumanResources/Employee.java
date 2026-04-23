// Aaron Saudager
// aaronsaudager@icloud.com

package HumanResources;

public class Employee   {
    private String employeeID;
    private String name;
    private String department;
    private double salary;
    private int PTODays;

    public Employee(String employeeID, String name, double salary, int PTODays) {
        this.employeeID = employeeID;
        this.name = name;
        this.salary = salary;
        this.PTODays = PTODays;
    }

    public String getEmployeeID() {
        return employeeID;
    }
    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public int getSalary() {
        return salary;
    }

    public int getPTODays() {
        return PTODays;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setSalary(double salary) {
        this.salary = salary;}

    public void setPTODays(int days) {
        this.PTODays = days;
    }

    public void displayInfo() {
        System.out.println("Employee ID: " + employeeID)
        System.out.println("Name: " + name);
        System.out.println("Salary: $" + salary);
        System.out.println("PTO Days: " + PTODays);
    }
}
