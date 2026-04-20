// Aaron Saudager
// aaronsaudager@icloud.com

package HumanResources;

public class Employee   {
    private String employeeID;
    private String name;
    private String department;
    private int salary;
    private int PTODays;

    public Employee(String name, int salary, int PTODays) {
        this.name = name;
        this.salary = salary;
        this.PTODays = PTODays;
    }

    public String getEmployeeID() { return employeeID; }
    public String getName() {
        return name;
    }

    public String getDepartment() {return department; }

    public int getSalary() {
        return salary;
    }

    public int getPTODays() { return PTODays; }

    public void setEmployeeID(String employeeID) { this.employeeID = employeeID; }

    public void setName(String name) {
        this.name = name;
    }

    public void setDepartment(String department) {this.department = department;}

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setPTODays(int days) {
        this.PTODays = days;
    }

    public void displayInfo() {
        System.out.println("Name: " + name + ", Salary: $" + salary + ", PTO Days: " + PTODays);
    }
}
